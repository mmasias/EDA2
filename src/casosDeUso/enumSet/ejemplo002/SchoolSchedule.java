package src.casosDeUso.enumSet.ejemplo002;

import java.util.EnumSet;

public class SchoolSchedule {
    public static void main(String[] args) {
        
        EnumSet<DayOfWeek> mathDays = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY);
        EnumSet<DayOfWeek> scienceDays = EnumSet.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY);
        EnumSet<DayOfWeek> historyDays = EnumSet.of(DayOfWeek.FRIDAY);

        System.out.println("Horario inicial:");
        System.out.println("Math: " + mathDays);
        System.out.println("Science: " + scienceDays);
        System.out.println("History: " + historyDays);

        
        mathDays.clear(); 
        mathDays.addAll(EnumSet.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY));

        System.out.println();
        System.out.println("Horario actualizado:");
        System.out.println("Math classes are now on: " + mathDays);
    }
}
