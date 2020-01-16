package Classes;

import Interfaces.ITrainingHour;
import java.util.ArrayList;

public class TrainingHour implements ITrainingHour {
    ArrayList<Participant> PList = new ArrayList<Participant>();
    Hour startHour;

    TrainingHour(Integer hour, Integer minutes){
        this.startHour = new Hour(hour, minutes);
    }

    public Hour getStartHour() {
        return this.startHour;
    }

    public void setStartHour(Hour startHour) {
        this.startHour = startHour;
    }

    public Participant getParticipantByName(String firstName) {
        for(int x = 0; x < PList.size(); x++){
            if(PList.get(x).getFirstName().equalsIgnoreCase(firstName)){
                return PList.get(x);
            }
        }
        return null; //Não há participantes com esse nome na lista.
    }

    public Participant getParticipantById(Integer id) {
        for(int x = 0; x < PList.size(); x++){
            if(PList.get(x).getId().equals(id)){
                return PList.get(x);
            }
        }
        return null; //Não há participantes com esse id na lista.
    }

    public String printParticipantList() {
        StringBuilder listPrint = new StringBuilder();
        for(int x = 0; x < PList.size(); x++){
            listPrint.append("PARTICIPANTE ").append(x + 1).append(": ").append(PList.get(x).getFirstName()).append(", ID").append(PList.get(x).getId()).append("\n");
        }
        return listPrint.toString();
    }

    public int addParticipant(Participant addTarget) {
        if(PList.size() < 7) {
            int addFlag = 0;
            for (int p = 0; p < PList.size(); p++) {
                if (PList.get(p).getId().compareTo(addTarget.getId()) == 0) {
                    addFlag = 1;
                }
            }
            if (addFlag == 0) {
                PList.add(addTarget);
                return 0; //Presença marcada com sucesso.
            }else{
                return 1; //Presença já marcada nessa aula.
            }
        }
        return 2; //As vagas dessa aula esgotaram.
    }

    public int removeParticipant(Participant rmvTarget) {
        if(PList.size() != 0){
            for(int q = 0; q < PList.size(); q++){
                if(PList.get(q).getId().compareTo(rmvTarget.getId()) == 0) {
                    PList.remove(q);
                    return 0; //Participante removido com sucesso.
                }
            }
        }
        return 1; //O participante não está com presença marcada nessa aula.
    }
}
