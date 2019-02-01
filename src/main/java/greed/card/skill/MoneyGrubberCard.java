package greed.card.skill;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class MoneyGrubberCard extends CustomCard {
    private final static String ID = "GreedTheSpire: MoneyGrubberCard";
    private final static String NAME = "돈독";
    private final static String IMAGE = "card/money_grubber_card.png";
    private final static int COST = 3;
    private final static String DESC = "3의 코스트를 써서 돈독에 오르게 합니다.";
    private final static CardType TYPE = CardType.SKILL;
    private final static CardColor COLOR = CardColor.RED;
    private final static CardRarity RARITY = CardRarity.COMMON;
    private final static CardTarget TARGET = CardTarget.ENEMY;

    public MoneyGrubberCard() {
        super(ID, NAME, IMAGE, COST, DESC, TYPE, COLOR, RARITY, TARGET);
        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(abstractMonster, abstractPlayer,
                        new PoisonPower(abstractMonster, abstractPlayer, AbstractDungeon.player.gold))
        );
    }
}
