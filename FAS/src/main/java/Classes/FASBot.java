package Classes;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static java.lang.Integer.valueOf;

public class FASBot extends TelegramLongPollingBot {
    //Inicializando o Administrador de Aulas...
    TrainingAdmin STAdmin = new TrainingAdmin();

    public void onUpdateReceived(Update update) {
        //System.out.printf("GORDOX" + update.getMessage().getText() + "\n");
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        if(command.equalsIgnoreCase("/start")){
            message.setText("Bem-vindo ao chat online da For All Studio!\nDigite /ajuda para ver a lista de comandos!");

        }else if(command.equalsIgnoreCase("/horarios")){
            message.setText(STAdmin.printAllDays());

        }else if(command.equalsIgnoreCase("/segunda")){
            message.setText(STAdmin.printDay("Segunda-feira"));

        }else if(command.equalsIgnoreCase("/terça") || command.equalsIgnoreCase("/terca")){
            message.setText(STAdmin.printDay("Terça-feira"));

        }else if(command.equalsIgnoreCase("/quarta")){
            message.setText(STAdmin.printDay("Quarta-feira"));

        }else if(command.equalsIgnoreCase("/quinta")){
            message.setText(STAdmin.printDay("Quinta-feira"));

        }else if(command.equalsIgnoreCase("/sexta")){
            message.setText(STAdmin.printDay("Sexta-feira"));

        }else if(command.equalsIgnoreCase("/sabado") || command.equalsIgnoreCase("/sábado")){
            message.setText(STAdmin.printDay("Sábado"));

        }else if(command.startsWith("/ir")){
            String[] words = command.split(" ");
            int errorCheck = 0;
            if(words.length == 3){
                if(words[0].equalsIgnoreCase("/ir")){
                    if(words[1].equalsIgnoreCase("segunda")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Segunda-feira", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença na segunda foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else if(words[1].equalsIgnoreCase("terça") || words[1].equalsIgnoreCase("terca")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Terça-feira", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença na terça foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else if(words[1].equalsIgnoreCase("quarta")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Quarta-feira", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença na quarta foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else if(words[1].equalsIgnoreCase("quinta")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Quinta-feira", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença na quinta foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else if(words[1].equalsIgnoreCase("sexta")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Sexta-feira", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença na sexta foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else if(words[1].equalsIgnoreCase("sabado") || words[1].equalsIgnoreCase("sábado")){
                        try{
                            errorCheck = STAdmin.addParticipant(update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getId(), "Sábado", valueOf(words[2]));
                            if(errorCheck == 0) { //Sem erros. Presença marcada com sucesso (classe TrainingHour)
                                message.setText("Sua presença no sábado foi marcada! Verifique os horários com /horarios ou digitando /nome_do_dia");
                            }else if(errorCheck == -1){ //Erro desconhecido na classe TrainingAdmin.
                                message.setText("Não foi possível marcar a presença. Ocorreu um erro interno. (EXITCODE -1: BAD PARAMETERS)");
                            }else if(errorCheck == -2){ //Horário inserido não existe.
                                message.setText("Não foi possível marcar a presença. O horário inserido não está disponível.");
                            }else if(errorCheck == 1){ //Presença já marcada na aula inserida.
                                message.setText("Não foi possível marcar a presença. A sua presença já foi marcada no horário inserido.");
                            }else if(errorCheck == 2){ //Vagas esgotadas nessa aula.
                                message.setText("Não foi possível marcar a presença. As vagas desse horário já foram preenchidas.");
                            }
                        }catch(NumberFormatException e){
                            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                            e.printStackTrace();
                        }
                    }else{
                        message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                    }
                }else{
                    message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                }
            }else{
                message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
            }

        }else if(command.startsWith("/cancelar")){
            String[] words = command.split(" ");
            int errorCheck = 0;
            if(words.length == 2){
                if(words[0].equalsIgnoreCase("/cancelar")){
                    if(words[1].equalsIgnoreCase("segunda")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Segunda-feira");
                        message.setText("Todas as suas presenças na segunda foram desmarcadas.");
                    }else if(words[1].equalsIgnoreCase("terça") || words[1].equalsIgnoreCase("terca")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Terça-feira");
                        message.setText("Todas as suas presenças na terça foram desmarcadas.");
                    }else if(words[1].equalsIgnoreCase("quarta")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Quarta-feira");
                        message.setText("Todas as suas presenças na quarta foram desmarcadas.");
                    }else if(words[1].equalsIgnoreCase("quinta")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Quinta-feira");
                        message.setText("Todas as suas presenças na quinta foram desmarcadas.");
                    }else if(words[1].equalsIgnoreCase("Sexta")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Sexta-feira");
                        message.setText("Todas as suas presenças na sexta foram desmarcadas.");
                    }else if(words[1].equalsIgnoreCase("sábado") || words[1].equalsIgnoreCase("sabado")){
                        STAdmin.rmvParticipantFromDay(update.getMessage().getFrom().getId(), "Sábado");
                        message.setText("Todas as suas presenças no sábado foram desmarcadas.");
                    }else{
                        message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                    }
                }else{
                    message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
                }
            }else{
                message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
            }
        }else if(command.equalsIgnoreCase("/ajuda")){
            message.setText("/start - Apresenta uma mensagem de boas vindas.\n\n/horarios - Apresenta uma lista com todas as aulas dos dias da semana e alunos que marcaram presença em cada uma das aulas.\n\n/nome_do_dia - Apresenta uma lista com todas as aulas do dia especificado, e os respectivos alunos que marcaram presença em cada uma das aulas. (Ex: /quinta)\n\n/ir nome_do_dia hora - Marca a sua presença na aula especificada. (Ex: /ir segunda 14)\n\n/cancelar nome_do_dia - Cancela/desmarca a sua presença em todas as aulas do dia especificado. (Ex: /cancelar terça)\n\n/ajuda - Apresenta a lista de comandos e suas respectivas descrições.\n\n");
        }else{
            message.setText("Seu comando foi digitado incorretamente. Verifique a ortografia e tente novamente.");
        }


        //Enviando a mensagem de retorno ao usuário
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "ForAllStudioBot";
    }

    public String getBotToken() {
        return "1016993354:AAHzS_uMuGBm8pGAIl6QFnqSHUuh0Iqk7P0";
    }
}
