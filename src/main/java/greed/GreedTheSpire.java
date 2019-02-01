package greed;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostCreateStartingRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.TheCity;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import greed.card.attack.MineAttackCard;
import greed.event.MyGoodEvent;

import java.util.ArrayList;

@SpireInitializer
public class GreedTheSpire
        implements PostInitializeSubscriber
        , PostCreateStartingRelicsSubscriber
        , EditCardsSubscriber {

    public GreedTheSpire() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new GreedTheSpire();
    }

    @Override
    public void receivePostInitialize() {
        BaseMod.addEvent(MyGoodEvent.ID, MyGoodEvent.class, TheCity.ID);
    }

    @Override
    public void receivePostCreateStartingRelics(AbstractPlayer.PlayerClass playerClass, ArrayList<String> relics) {
        if(playerClass == AbstractPlayer.PlayerClass.IRONCLAD) {
            relics.add("Black Blood");
            relics.remove("Burning Blood");
            UnlockTracker.markRelicAsSeen("Black Blood");
        }
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new MineAttackCard());
    }
}
