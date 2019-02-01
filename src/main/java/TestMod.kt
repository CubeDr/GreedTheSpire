import basemod.BaseMod
import basemod.interfaces.PostInitializeSubscriber
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer

@SpireInitializer
class TestMod: PostInitializeSubscriber {
    init {
        BaseMod.subscribe(this)
    }

    companion object {
        fun initialize() = TestMod()
    }

    override fun receivePostInitialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}