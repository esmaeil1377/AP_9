package FarmModel.Request;

public class Upgrade extends Request {
    private String command;

    public Upgrade(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
