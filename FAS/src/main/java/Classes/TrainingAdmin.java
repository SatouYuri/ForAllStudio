package Classes;

import Interfaces.ITrainingAdmin;

import java.util.ArrayList;

public class TrainingAdmin implements ITrainingAdmin {
    ArrayList<Day> DayList = new ArrayList<Day>();

    TrainingAdmin(){
        //Construindo os dias na DayList...
        for(int x = 0; x < 6; x++){
            DayList.add(new Day(x));
        }
    }

    public int addParticipant(String firstName, Integer id, String dayName, Integer start_Hour) {
        int returnSign = -1;
        for(int k = 0; k < DayList.size(); k++){
            if(DayList.get(k).getDayName(DayList.get(k).getDay()).equalsIgnoreCase(dayName)){
                for(int j = 0; j < DayList.get(k).THList.size(); j++){
                    if(DayList.get(k).THList.get(j).getStartHour().getHour().equals(start_Hour)){
                        return DayList.get(k).THList.get(j).addParticipant(new Participant(firstName, id));
                    }
                }
                returnSign = -2; //Horário inserido não existe.
            }
        }
        return returnSign; //Se for -1: ERRO "BAD PARAMETERS"

    }

    /*public void rmvParticipantFromTH(String dayName, Integer start_Hour) {
        Ideia para depois...
    }*/

    public void rmvParticipantFromDay(Integer id, String dayName) {
        for(int l = 0; l < DayList.size(); l++){
            if(DayList.get(l).getDayName(DayList.get(l).getDay()).equalsIgnoreCase(dayName)){
                for(int m = 0; m < DayList.get(l).THList.size(); m++){
                    if(DayList.get(l).THList.get(m).getParticipantById(id) != null){
                        DayList.get(l).THList.get(m).removeParticipant(DayList.get(l).THList.get(m).getParticipantById(id));
                    }
                }
            }
        }
    }

    public void resetAllDays() {
        for(int t = 0; t < DayList.size(); t++){
            DayList.get(t).resetAllPresences();
        }
    }

    public String printAllDays() {
        String allDaysPrint = "";
        for(int r = 0; r < DayList.size(); r++){
            allDaysPrint = allDaysPrint + DayList.get(r).printAllTrainingHours();
        }
        return allDaysPrint;
    }

    public String printDay(String dayName){
        String dayPrint = "";
        for(int e = 0; e < DayList.size(); e++){
            if(DayList.get(e).getDayName(DayList.get(e).getDay()).equalsIgnoreCase(dayName)) {
                dayPrint = DayList.get(e).printAllTrainingHours();
                break;
            }
        }
        return dayPrint;
    }
}
