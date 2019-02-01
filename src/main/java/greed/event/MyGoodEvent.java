package greed.event;

import com.megacrit.cardcrawl.events.AbstractImageEvent;

public class MyGoodEvent extends AbstractImageEvent {
    public static final String ID = "TestMod: MyGoodEvent";
    public static final String DESCRIPTION = "just for test";
    public static final String NAME = "Test Event";

    private enum State {
        INIT, CONTINUE, LEAVE
    }

    private State state;

    public MyGoodEvent() {
        super(NAME, DESCRIPTION, "button.png");
        this.imageEventText.setDialogOption("계속한다.");
        state = State.INIT;
    }

    @Override
    protected void buttonEffect(int buttonPressed) {
        switch(state) {
            case INIT:
                // 나중에 설명
                break;
            case CONTINUE:
                switch(buttonPressed) {
                    case 0:
                        // 나중에 설명
                        break;
                    case 1:
                        // 나중에 설명
                        break;
                    default:
                        // 나중에 설명
                        break;
                }
                break;
            case LEAVE:
                // 나중에 설명
                break;
            default:
                break;
        }
    }
}
