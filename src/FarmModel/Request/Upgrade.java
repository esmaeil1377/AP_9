package FarmModel.Request;

public class Upgrade extends Request {
    private String command;

    public Upgrade(String requestLine) {
        AnalyzeRequestlIne(requestLine);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void AnalyzeRequestlIne(String requestLine){}
}
