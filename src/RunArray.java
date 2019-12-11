import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class RunArray {
    List<Run> runs = new ArrayList<>();
    FontFactory fontFactory = FontFactory.getFontFactoryInstance();
    private Font defaultFont = fontFactory.getFont("TIMES NEW ROMAN",Font.PLAIN,10);

    public void addRun(int startIndex, int runLength, Font font) {
        Run newRun = new Run(startIndex, startIndex+ runLength, font);
        runs.add(newRun);
    }

    public void appendRun(int runLength, Font font) {
        int startIndex = runs.get(runs.size()-1).getEndIndex()+1;
        runs.add(new Run(startIndex, startIndex + runLength, font));
    }

    public Font getFont(int index) {
        for (Run run : runs) {
            if (index >= run.getStartIndex() && index <= run.getEndIndex()) {
                return run.getFont();
            }
        }
        return defaultFont;
    }
}