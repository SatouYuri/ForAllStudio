package Classes;

import Interfaces.IDay;
import java.util.ArrayList;

public class Day implements IDay {
    Integer EnumVal;
    ArrayList<TrainingHour> THList = new ArrayList<TrainingHour>();

    Day(Integer EnumVal){
        //Definindo o nome/valor-enum do dia...
        this.EnumVal = EnumVal;

        //Criando as TrainingHours (aulas) do dia nos períodos de aula (provisórios)...
        if(EnumVal != 5){ //Se não for Sábado...
            for(int i = 8; i < 21; i++){
                if(i != 12) {
                    THList.add(new TrainingHour(i, 0));
                }
            }
        }else{ //Se for Sábado...
            for(int j = 8; j < 12; j++){
                THList.add(new TrainingHour(j, 0));
            }
        }
    }

    public void resetAllPresences() {
        for(int x = 0; x < THList.size(); x++){
            THList.get(x).PList.clear();
        }
    }

    public Integer getDay() {
        return this.EnumVal;
    }

    public String getDayName(Integer EnumVal) {
        if(EnumVal.equals(0)){
            return "Segunda-feira";
        }else if(EnumVal.equals(1)){
            return "Terça-feira";
        }else if(EnumVal.equals(2)){
            return "Quarta-feira";
        }else if(EnumVal.equals(3)){
            return "Quinta-feira";
        }else if(EnumVal.equals(4)){
            return "Sexta-feira";
        }else if(EnumVal.equals(5)){
            return "Sábado";
        }else{
            return "ErrorDay";
        }
    }

    public String printAllTrainingHours() {
        String fullPrint = "";
        for(int y = 0; y < THList.size(); y++){
            fullPrint = fullPrint + "[Aula " + (y+1) + "] " + getDayName(getDay()) + " - " + THList.get(y).getStartHour().printHour() + " - " + "(" + THList.get(y).PList.size() + "/7)" + ":\n";
            fullPrint = fullPrint + THList.get(y).printParticipantList();
        }
        return fullPrint;
    }

    public void setDayName(Integer EDayEnumValue) {
        this.EnumVal = EDayEnumValue;
    }
}
