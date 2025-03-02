Function CalculaNutrientes(miElemento As Long, _
                           miTipoElemento As TipoElemento, _
                  Optional Cantidad As Double, _
                  Optional miFactor As Double = -1) As Double()


    Dim miSQL         As String
    Dim rsTemporal    As Recordset
    Dim Elementos(35) As Double
    Dim i             As Integer
    Dim miSuma        As Double

    For i = 1 To 35
        misAusencias(i) = False
    Next i

  Set rsTemporal = New Recordset

  Select Case miTipoElemento
    Case miEncuesta
      Dim arrElementosEncuesta() As Double
      Dim arrSumaEncuesta(35) As Double

      miSQL = "SELECT id as [Codigo Elemento] " & _
              "FROM tDieta " & _
              "WHERE idEncuesta = " & miElemento
      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          arrElementosEncuesta() = CalculaNutrientes(.Fields("Codigo Elemento"), 400)
          For i = 1 To 35
              arrSumaEncuesta(i) = SumaComponentes(arrSumaEncuesta(i), arrElementosEncuesta(i))
          Next i
          .MoveNext
        Loop
        .Close
        CalculaNutrientes = arrSumaEncuesta
      End With


    Case miDieta '400

      Dim arrElementosDieta() As Double
      Dim arrSumaDieta(35) As Double

      miSQL = "SELECT id as [Codigo Elemento] " & _
              "FROM tMenu " & _
              "WHERE idDieta = " & miElemento
      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          arrElementosDieta() = CalculaNutrientes(.Fields("Codigo Elemento"), 300)
          For i = 1 To 35
            arrSumaDieta(i) = SumaComponentes(arrSumaDieta(i), arrElementosDieta(i))
          Next i
          .MoveNext
        Loop
        .Close
        CalculaNutrientes = arrSumaDieta
      End With


    Case miMenu ' 300

      Dim arrElementosMenu() As Double
      Dim arrSumaMenu(35) As Double

      miSQL = "SELECT idElemento as [Codigo Elemento], [Tipo Elemento], Cantidad " & _
              "FROM tMenuElemento " & _
              "WHERE idMenu = " & miElemento & " " & _
              "ORDER BY [Tipo Elemento]"

      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          Select Case .Fields("Tipo Elemento")
            Case "A"
              arrElementosMenu() = CalculaNutrientes(.Fields("Codigo Elemento"), 100, .Fields("Cantidad"))
            Case "R"
              arrElementosMenu() = CalculaNutrientes(.Fields("Codigo Elemento"), 200, .Fields("Cantidad"))
          End Select
            If .Fields("Tipo Elemento").Value <> "C" Then
                    For i = 1 To 35
                    arrSumaMenu(i) = SumaComponentes(arrSumaMenu(i), arrElementosMenu(i))
                    Next i
            End If
        .MoveNext
        Loop
        .Close
      End With
      CalculaNutrientes = arrSumaMenu

    Case miReceta ' 200
      miSQL = "SELECT SUM(Cantidad) as miCantidad " & _
              "FROM tRecetaElemento " & _
              "WHERE CodigoReceta = " & miElemento
      With rsTemporal
        .Open miSQL, miConeccion
        miSuma = .Fields("miCantidad").Value
        .Close
      End With
      miFactor = Cantidad / miSuma

      Dim arrElementosReceta() As Double
      Dim arrSumaReceta(35) As Double

      miSQL = "SELECT [Codigo Elemento], [Tipo Elemento], Cantidad " & _
              "FROM tRecetaElemento " & _
              "WHERE CodigoReceta = " & miElemento & " " & _
              "ORDER BY [Tipo Elemento]"

      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          Select Case .Fields("Tipo Elemento")
            Case "A"
              arrElementosReceta() = CalculaNutrientes(.Fields("Codigo Elemento"), 100, .Fields("Cantidad").Value * miFactor)
            Case "R"
              arrElementosReceta() = CalculaNutrientes(.Fields("Codigo Elemento"), 200, .Fields("Cantidad") * miFactor)
          End Select
        For i = 1 To 35
          arrSumaReceta(i) = SumaComponentes(arrSumaReceta(i), arrElementosReceta(i))
        Next i
        .MoveNext
        Loop
        .Close
      End With
      CalculaNutrientes = arrSumaReceta

    Case miAlimento ' 100
      Dim miPorcionComestible As Double

      miSQL = "SELECT Comestible FROM mAlimentos WHERE id = " & miElemento
      miPorcionComestible = miConeccion.Execute(miSQL).Fields(0).Value / 100

      miSQL = "SELECT idComponente, Valor * " & miPorcionComestible * Cantidad & " as Componente " & _
              "FROM mAlimentosComponentes " & _
              "WHERE idAlimento = " & miElemento & " " & _
              "ORDER BY idComponente"

      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          If .Fields("Componente") > 0 Then
            Elementos(.Fields("idComponente")) = Val("" & .Fields("Componente").Value) / 100  '* Cantidad
          Else
              Elementos(.Fields("idComponente")) = Val("" & .Fields("Componente").Value) / (miPorcionComestible * Cantidad)
            If .Fields("Componente") = -1 Then
              misAusencias(.Fields("idComponente")) = True
            End If
          End If
          .MoveNext
        Loop
        .Close
      End With
      CalculaNutrientes = Elementos

    Case miEnteral ' 700
      miSQL = "SELECT idComponente, Valor * " & Cantidad & " as Componente " & _
              "FROM mEnteralesComponentesAlimentos " & _
              "WHERE idAlimento = " & miElemento & " " & _
              "ORDER BY idComponente"

      With rsTemporal
        .Open miSQL, miConeccion
        Do While Not .EOF
          If .Fields("Componente") > 0 Then
            Elementos(.Fields("idComponente")) = .Fields("Componente") / 100 '* Cantidad
          Else
            Elementos(.Fields("idComponente")) = 0
            If .Fields("Componente") = -1 Then
              misAusencias(.Fields("idComponente")) = True
            End If
          End If
          .MoveNext
        Loop
        .Close
      End With
      CalculaNutrientes = Elementos

  End Select

End Function