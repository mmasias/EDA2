Sub CrearArbol(miArbol As TreeView, _
               miElemento, _
               miTipoElemento As String, _
               miRama As String, _
      Optional miCantidad As Double = -1, _
      Optional miFactor As Double = 1)
' Crear un arbol es mostrar el elemento en su rama padre y segun
' sea su tipo llamar a sus componentes y mostrarlos como sus hijos

  Dim miSQL         As String
  Dim rsTemporal    As Recordset
  Dim i             As Integer
  Dim miNuevoNodo   As Node
  Dim Nombre        As String
  Dim miSuma        As Double

  Nombre = VerNombre(miElemento, miTipoElemento)
  
  Set miNuevoNodo = miArbol.Nodes.Add(miRama, tvwChild, miRama & miElemento & miTipoElemento, "ID: [" & miElemento & "] - Key: " & miRama & miElemento & miTipoElemento)
  
  With miArbol.Nodes(miNuevoNodo.Index)
    
    Select Case miTipoElemento
      Case "A", "R", "M"
        .Expanded = False
      Case Else
        .Expanded = True
    End Select
    
    .Tag = miElemento & "|" & miCantidad
    
    If miCantidad > 0 Then
      '.Text = Nombre & " [" & Format(miCantidad * miFactor, "0") & " g ]"
      .Text = Nombre '& " [" & Format(miCantidad * miFactor, "0") & " g ]"
    Else
      .Text = Nombre
    End If
  
  ' Mejora para la imagen
    If miTipoElemento <> "A" Then
      
' ********************************************************************************
' EXPERIMENTO PURAMENTE EXPERIMENTAL; LUEGO LO MEJORAREMOS
' (en el año dos mil quinientos)
' ********************************************************************************
      If miTipoElemento = "D" Then
      ' Si el tipo de elemento es D (Dieta), debemos ver si es que tiene
      ' un intercambio asociado, y asi representarlo.
        miSQL = "SELECT idIntercambioAsociado " & _
                "FROM tDieta " & _
                "WHERE id=" & miElemento
        If miConeccion.Execute(miSQL).Fields(0).Value > 0 Then
          .Image = UCase(miTipoElemento) & "*"
        Else
          .Image = UCase(miTipoElemento)
        End If
        miSQL = vbNullString
      Else
        .Image = UCase(miTipoElemento)
      End If
' ********************************************************************************
' ********************************************************************************
      
    Else
      .Image = "G" & VerGrupo(miElemento)
    End If
    
    If miTipoElemento = "A" Then .Bold = False Else .Bold = True
    
    .ForeColor = VerColor(miTipoElemento)
    
    .Checked = True
    
  End With
  
  Set rsTemporal = New Recordset
  
  Select Case miTipoElemento
  
    Case "E"
      miSQL = "SELECT Id " & _
              "FROM  tDieta " & _
              "WHERE idEncuesta = " & miElemento & " " & _
              "ORDER BY Dia"
      With rsTemporal
        .Open miSQL, miConeccion, adOpenStatic
        Do While Not .EOF
          CrearArbol miArbol, .Fields(0).Value, "D", miRama & miElemento & miTipoElemento
          .MoveNext
        Loop
        .Close
      End With

    Case "D"
      miSQL = "SELECT id " & _
              "FROM tMenu " & _
              "WHERE idDieta = " & miElemento & " " & _
              "ORDER BY idIngesta"
      With rsTemporal
        .Open miSQL, miConeccion, adOpenStatic
        Do While Not .EOF
          CrearArbol miArbol, .Fields(0).Value, "M", miRama & miElemento & miTipoElemento
          .MoveNext
        Loop
        .Close
      End With

    Case "M"
      miSQL = "SELECT [IdElemento], [Tipo Elemento], [Cantidad] " & _
              "FROM tMenuElemento " & _
              "WHERE IdMenu = " & miElemento & " " & _
              "ORDER BY Orden"
              
      With rsTemporal
        .Open miSQL, miConeccion, adOpenStatic
        Do While Not .EOF
          CrearArbol miArbol, .Fields(0).Value, .Fields(1).Value, miRama & miElemento & miTipoElemento, .Fields(2)
          .MoveNext
        Loop
        .Close
      End With

    Case "R"
      miSQL = "SELECT SUM(Cantidad) as miCantidad " & _
              "FROM tRecetaElemento " & _
              "WHERE CodigoReceta = " & miElemento
      With rsTemporal
        .Open miSQL, miConeccion, adOpenStatic
        miSuma = Val("" & .Fields("miCantidad").Value)
        .Close

      ' Cantidad por defecto de una receta
      ' Luego el Factor ajusta las cantidades de los componentes
        If miCantidad = -1 Then miCantidad = 100
        miFactor = miCantidad / miSuma

        miSQL = "SELECT [Codigo Elemento], [Tipo Elemento], [Cantidad] " & _
                "FROM tRecetaElemento " & _
                "WHERE CodigoReceta = " & miElemento

        .Open miSQL, miConeccion, adOpenStatic
        Do While Not .EOF
          CrearArbol miArbol, .Fields(0).Value, .Fields(1).Value, miRama & miElemento & miTipoElemento, .Fields(2) * miFactor
          .MoveNext
        Loop
        .Close
      End With
  End Select

End Sub