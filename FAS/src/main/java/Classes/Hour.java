package Classes;

public class Hour {
    private Integer hour;
    private Integer minutes;

    Hour(Integer hour, Integer minutes){
        if(hour > 23 || hour < 0){
            this.hour = 0;
        }else{
            this.hour = hour;
        }

        if(minutes > 59 || minutes < 0){
            this.minutes = 0;
        }else{
            this.minutes = minutes;
        }
    }

    public String printHour(){
        String _hour = this.hour.toString();
        if(hour >= 0 && hour <= 9) {
            _hour = "0" + _hour;
        }

        String _minutes = this.minutes.toString();
        if(minutes >= 0 && minutes <= 9) {
            _minutes = "0" + _minutes;
        }

        return _hour + ":" + _minutes;
    }

    public Integer getHour(){
        return this.hour;
    }

    public Integer getMinutes(){
        return this.minutes;
    }
}
