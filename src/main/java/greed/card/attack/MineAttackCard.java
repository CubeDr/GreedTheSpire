package greed.card.attack;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class MineAttackCard extends CustomCard {
    private final static String ID = "GreedTheSpire: MineAttackCard";
    private final static String NAME = "채광";
    private final static String IMAGE = "card/mine_attack_card.png";
    private final static int COST = 1;
    private final static String DESC = "1의 코스트를 써서 채광 공격을 합니다.";
    private final static CardType TYPE = CardType.ATTACK;
    private final static CardColor COLOR = CardColor.RED;
    private final static CardRarity RARITY = CardRarity.COMMON;
    private final static CardTarget TARGET = CardTarget.ENEMY;

    private static final int ATTACK_DMG = 5;
    private static final int UPGRADE_PLUS_DMG = 5;

    public MineAttackCard() {
        super(ID, NAME, IMAGE, COST, DESC, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = ATTACK_DMG;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPGRADE_PLUS_DMG);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m,
                new DamageInfo(p, this.damage, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public AbstractCard makeCopy() {
        return new MineAttackCard();
    }
}
