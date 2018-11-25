package FarmModel.Request;

public class Print extends Request {
    private String commandName;

    public Print(String requestLine) {
        AnalyzeRequestLine(requestLine);
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void AnalyzeRequestLine(String requestLine){}
}
