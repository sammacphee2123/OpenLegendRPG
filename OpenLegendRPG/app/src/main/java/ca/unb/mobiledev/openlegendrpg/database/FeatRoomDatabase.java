package ca.unb.mobiledev.openlegendrpg.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ca.unb.mobiledev.openlegendrpg.dao.featDao;


/**
 * Database layer in top of the SQLite database
 */
@Database(entities = {Feat.class}, version = 1, exportSchema = false)
public abstract class FeatRoomDatabase extends RoomDatabase {

    public abstract featDao featDao();
    private static volatile FeatRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 15;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static FeatRoomDatabase getDatabase(final Context context) {
        if (null == INSTANCE) {
            synchronized (FeatRoomDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FeatRoomDatabase.class, "feat_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriterExecutor.execute(() -> {
                featDao dao = INSTANCE.featDao();
                dao.deleteAll();

                Feat feat = new Feat("Alternate Form (I - II)",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 2: None",
                        "Description:\n\t" +
                                "You have the ability to transform from one persona to another," +
                                " whether that be through bodily transformation like a werewolf " +
                                "or through exterior mechanisms, such as a cybernetically enhanced" +
                                " soldier who can call forth a symbiotic mech suit.",
                        "Effect:\n\t" +
                                "Upon taking this feat, you build a single alternate form using the" +
                                " normal character creation rules, though your attribute and feat " +
                                "points are determined by your tier in this feat:\n" +
                                "Tier 1 - Half of your primary form's attribute points (rounded up)," +
                                " and 3 feat points.\n" +
                                "Tier 2 - Same attribute points as your primary form, and 3 feat " +
                                "points less than your primary form.\n" +
                                "\n" +
                                "Whenever your primary form gains new attribute points or levels " +
                                "up, your alternate form also gains points according to the above" +
                                " formulas.\n" +
                                "As a focus action, you may change between any two forms " +
                                "(including your primary form or any alternate form). You maintain" +
                                " this capability in all of your forms.\n" +
                                "Each form is treated as a completely different character for " +
                                "mechanical purposes - possessing different attributes, feats, " +
                                "perks, flaws, and other defining characteristics. Your alternate" +
                                " form does, however, retain the ability to transform back into " +
                                "your primary form.\n" +
                                "In order to keep track of hit points, you should always record the" +
                                " total damage that your character has suffered. When transforming" +
                                ", your damage remains with you even if your maximum hit points " +
                                "change. For example, Dr. Jekyll has a max HP of 15 and Mr. Hyde " +
                                "has a max HP of 30. During combat, Mr. Hyde suffers 10 damage. " +
                                "When he later transforms back into Dr. Jekyll, the 10 damage " +
                                "remains and is subtracted from his new maximum, leaving the doctor" +
                                " with 5 out of 15 hit points. Additionally, when changing forms," +
                                " if your hit points would be reduced to less than 1, your hit point" +
                                " total becomes 1 instead.\n" +
                                "\n" +
                                "Special:\n\t" +
                                "When selecting feats for your alternate form, you may not select " +
                                "the Alternate Form feat.\n" +
                                "With GM approval, you may take this feat multiple times. " +
                                "If you do, you get access to an additional form. Multiple " +
                                "Alternate Forms can be a powerful way of accumulating new feat " +
                                "points and attributes. The GM should prevent players from " +
                                "exploiting the feat to create an overly powerful character.");
                dao.insert(feat);
                feat = new Feat("Area Manipulation (I - V)",
                        "Cost: 1 point",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 5: None",
                        "Description:\n\t" +
                                "Whether unloading your assault rifle on full-automatic or hurling" +
                                " a ball of flame, you are exceptionally precise at choosing" +
                                " targets for area attacks, allowing you to avoid allies who" +
                                " would otherwise be caught in the line of fire.",
                        "Effect:\n\t" +
                                "For each tier of this feat you possess, you can omit a single" +
                                " 5-foot square from being targeted as part of an area attack.");
                dao.insert(feat);
                feat = new Feat("Armor Mastery (I - II)",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 2: None",
                        "Description:\n\t" +
                                "Whether you are a heavily armored mechanized knight or a nimble" +
                                " rogue in studded leather, you and your armor are one. Your " +
                                "training and experience at wearing armor allows you to maximize " +
                                "its protection and minimize its drawbacks.",
                        "Effect:\n\t" +
                                "Your training allows you to sleep in armor without gaining one" +
                                " level of the fatigued bane. In addition, while wearing armor," +
                                " you gain the following benefits:\n" +
                                "Tier 1 - The Fortitude prerequisite for wearing armor is reduced" +
                                " by 1. When wearing armor, you get a +1 armor bonus to your Guard" +
                                " defense.\n" +
                                "Tier 2 - The Fortitude prerequisite for wearing armor is reduced" +
                                " by 2. When wearing armor, you get a +2 armor bonus to your Guard" +
                                " defense. Any movement penalty is reduced by 5'.");
                dao.insert(feat);
                feat = new Feat("Attack Redirection",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: Defensive Reflexes II feat",
                        "Description:\n\t" +
                                "You are adept at redirecting your enemy's attacks. Whether " +
                                "using fancy footwork, magical force, or tactical superiority, " +
                                "you know how to force your enemy to attack unintended targets.",
                        "Effect:\n\t" +
                                "When you make a defend action and your roll exceeds the attacker's" +
                                " action roll, you can choose to redirect the attack to a target" +
                                " that is neither you, nor the attacker. The original attack roll" +
                                " does not change, only the target. If the attack was a melee" +
                                " attack, you can redirect it to anyone within 5' of you" +
                                " (as opposed to within 5' of the attacker).");
                dao.insert(feat);
                feat = new Feat("Attack Specialization (I - IX) ",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 9: Agility 3, Might 3, or Any Extraordinary 3",
                        "Description:\n\t" +
                                "Like a samurai who masters the art of the katana or an" +
                                " elementalist who specializes in summoning flame, you are so" +
                                " well trained with a particular form of attack that you can" +
                                " devastate foes with much more skill than the average combatant.",
                        "Effect:\n\t" +
                                "When you take this feat, select one weapon or attack type." +
                                " You gain advantage 1 per tier of this feat for any damaging" +
                                " attack made with your chosen attack type. This bonus does not" +
                                " apply to bane attacks or boon invocations.\n" +
                                "Examples of attack types you can choose to specialize in include" +
                                " fire, cold, lightning, acid, poison, entropy, and force - though" +
                                " this list is not exhaustive.\n" +
                                "\n" +
                                "Special\n" +
                                "In addition to purchasing multiple tiers of this feat, you may" +
                                " take this feat multiple times and select a new weapon or attack" +
                                " type each time. Your total advantage to an attack is equal to" +
                                " your tier for that particular weapon or attack type. For example," +
                                " a character might have Attack Specialization II (Fire) for fire" +
                                " attacks and Attack Specialization IV (Longsword) for longsword" +
                                " attacks.");
                dao.insert(feat);
                feat = new Feat("Attribute Substitution (I - II)",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 2: None",
                        "Description:\n\t" +
                                "Your prowess in an extraordinary, mental, or social attribute" +
                                " is linked in a way that empowers another attribute of your" +
                                " character, allowing you to use that attribute for tasks normally" +
                                " reserved for another. Examples of Attribute Substitution in play" +
                                " include a martial artist who is physically weak but capable of" +
                                " using internal chi to throw and disable opponents, an anatomical" +
                                " genius who uses logic to make vital strikes rather than their" +
                                " agility, or a gunslinger whose deadshot aim is the result of" +
                                " a dark pact.",
                        "Effect:\n\t" +
                                "When you take this feat, you create a permanent link between two" +
                                " attributes: one stronger (the primary attribute) and one weaker" +
                                " (the dependent attribute). You may use your primary attribute" +
                                " in place of the dependent attribute for different purposes" +
                                " depending on which tier of the feat you have:\n" +
                                "Tier 1\n" +
                                "Making non-attack, non-defend, non-invocation action rolls\n" +
                                "Calculating hit points, defenses, and other secondary statistics\n" +
                                "Meeting feat prerequisites\n" +
                                "Other situations at the GM's discretion\n" +
                                "\n" +
                                "Tier 2\n" +
                                "Making attack and defend action rolls\n" +
                                "Invoking banes and boons\n" +
                                "\n" +
                                "\n" +
                                "The relationship formed by your two attributes is subject" +
                                " to case-by-case approval and must be approved by the GM first." +
                                " The link must be logical and consistent with the story you are" +
                                " trying to tell. For example, a brawler who substitutes their" +
                                " Logic for their Might to represent their ability to use leverage" +
                                " in grappling rather than strength would likely not get to use" +
                                " their Logic score for an attempt to bend the bars on a prison" +
                                " cell. Furthermore, the GM should prevent players from creating" +
                                " illogical substitutions that are purely aimed at making their" +
                                " characters unreasonably powerful. Two examples of proper uses" +
                                " of this feat include a calculating warrior who studies angles," +
                                " leverage, and physics to substitute Logic for Might, or a " +
                                "gunslinger who channels dark energy, giving her deadshot accuracy" +
                                " and substituting Entropy for Agility.");
                dao.insert(feat);
                feat = new Feat("Bane Focus",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: Ability to invoke the chosen bane",
                        "Description:\n\t" +
                                "You are specialized in the use of a particular bane that is" +
                                " iconic to your character. Perhaps you are a martial artist" +
                                " known for your stunning strikes, a sniper who knows how to" +
                                " slow a target's escape, or a fire mage who sets enemies ablaze" +
                                " with persistent burning damage.",
                        "Effect:\n\t" +
                                "Choose a bane that you can invoke. When your roll on a" +
                                " damaging attack exceeds the target's defense by 5 or more" +
                                " (as opposed to the usual 10), you can inflict this bane for" +
                                " free. Each attack is still only capable of inflicting a single" +
                                " bane. Furthermore, when making a bane attack to inflict your" +
                                " chosen bane, you gain advantage 2 on the bane attack roll.\n" +
                                "\n" +
                                "Special\n" +
                                "You may take this feat multiple times. Each time you do," +
                                " choose a different bane.");
                dao.insert(feat);
                feat = new Feat("Battle Trance",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: Fortitude 3, or Will 3",
                        "Description:\n\t" +
                                "You can enter a heightened mental state of combat readiness," +
                                " in which your body is strengthened and your mind transcends" +
                                " fear and pain. Examples include a raging barbarian or an" +
                                " unstoppable samurai with laser focus in the heat of battle.",
                        "Effect:\n\t" +
                                "As a free action on your turn, you may enter a battle trance." +
                                " While entranced, you have advantage 1 on all attacks." +
                                " Additionally, your Toughness and Resolve defenses are" +
                                " increased by 3. If your total armor bonus is less than 3," +
                                " it becomes 3. If you take three consecutive turns without" +
                                " making an attack roll against an enemy creature, the battle" +
                                " trance ends. When the battle trance ends, you automatically" +
                                " suffer 1 level of the fatigue bane.");
                dao.insert(feat);
                feat = new Feat("Battlefield Opportunist (I - V)",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 5: Agility 4, or Might 4",
                        "Description:\n\t" +
                                "Your battlefield prowess allows you to capitalize on windows of" +
                                " opportunity that others don't notice, making you far more deadly" +
                                " in melee combat. Whether you wield an axe, plasmablade, or" +
                                " your bare fists, foes struggle to maneuver around or away from you.",
                        "Effect:\n\t" +
                                "You may make an additional opportunity attack per round for each" +
                                " tier of this feat you possess. You can only make one opportunity" +
                                " attack per triggering action (e.g., you cannot make multiple" +
                                " attacks against the same foe when they leave your threatened" +
                                " space).");
                dao.insert(feat);
                feat = new Feat("Battlefield Punisher",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1:\n" +
                                "Agility 5, Might 5, or Any Extraordinary 5\n" +
                                "Battlefield Retribution feat",
                        "Description:\n\t" +
                                "Not only can you deal out retributive damage, you can devastate" +
                                " your opponents with a signature secondary effect. Examples of" +
                                " this feat in action include a stalwart paladin who knocks foes" +
                                " prone, a ninja who blinds enemies, or a telekinetic psychic who" +
                                " hurls attacks away.",
                        "Effect:\n\t" +
                                "Choose a bane you can inflict. Any time you use the defend" +
                                " action with an attribute that could inflict the chosen bane" +
                                " and deal 10 damage via the Battlefield Retribution feat," +
                                " you may choose to automatically afflict the attacker with" +
                                " the chosen bane.");
                dao.insert(feat);
                feat = new Feat("Battlefield Retribution",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: Agility 4, Might 4, or Any Extraordinary 4",
                        "Description:\n\t" +
                                "You are a master of the counter attack. This might take the" +
                                " form of deftly redirecting a strike back upon the attacker or" +
                                " even energetic feedback from an extraordinary barrier that" +
                                " damages the attacker. Your prowess on the battlefield allows" +
                                " you to not only intercept attacks but also decimate your foes" +
                                " with retributive damage.",
                        "Effect:\n\t" +
                                "When you use the defend interrupt action, you also deal damage" +
                                " to the attacker equal to the amount by which your action" +
                                " roll exceeds the attacker's roll.");
                dao.insert(feat);
                feat = new Feat("Boon Access",
                        "Cost: 1, 2, 3, 4, 5, 6, 7, 8, or 9 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: None",
                        "Description:\n\t" +
                                "You have a special gift: it might be the result of your heritage," +
                                " a close encounter with magical energy, or the result of years" +
                                " of training with a master. In any case, although you do not" +
                                " necessarily possess the aptitude to work extraordinary powers" +
                                " for yourself or create a desired effect with your physical" +
                                " capabilities alone, you are able to reliably replicate a" +
                                " single boon.",
                        "Effect:\n\t" +
                                "When you choose this feat, choose one boon that you do not have" +
                                " the requisite attribute to invoke. The cost of this feat is" +
                                " equal to the power level of the chosen boon. You can invoke" +
                                " the chosen boon despite lacking the necessary attribute. For" +
                                " invocation rolls, treat your attribute score as the power " +
                                "level of the boon. If the boon has multiple attribute prerequisite" +
                                " options, you choose one attribute when you take this feat. " +
                                "Additionally, you count as having access to the chosen boon " +
                                "for the purpose of meeting feat prerequisites, and your attribute" +
                                " for meeting such prerequisites is equal to the power level of" +
                                " the boon. The Boon Access feat bypasses the normal attribute " +
                                "score restrictions based on character level, so a first level " +
                                "character could spend all 6 of their feat points to begin play" +
                                " with access to a power level 6 boon.\n" +
                                "You may acquire this feat multiple times. Each time, select a new boon.\n" +
                                "\n" +
                                "Special\n" +
                                "You may take this feat multiple times. Each time you do, choose" +
                                " a new boon to gain access to.\n" +
                                "Note that this feat can give access to high-powered boons with " +
                                "a potential for very dramatic impact on the storyline of a game." +
                                " As such, using this feat to access a boon of power level 6 or " +
                                "higher should be approved by the GM before using it in a game.\n" +
                                "If you ever meet the attribute prerequisite for the chosen boon, " +
                                "you may choose at that time to lose this feat and regain the feat" +
                                " points spent. Re-allocate them as you choose.");
                dao.insert(feat);
                feat = new Feat("Boon Focus (I - III)",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 3: Ability to invoke the chosen boon",
                        "Description:\n\t" +
                                "You are specialized in the use a particular boon that is iconic" +
                                " to your character. Examples of this feat in action include a" +
                                " druid who can shapechange at-will, a combat medic who can tend " +
                                "the wounds of many with expert skill, and a mad scientist who " +
                                "can animate mechanical minions effortlessly.",
                        "Effect:\n\t" +
                                "Choose a single boon that you can invoke. You gain benefits with" +
                                " that boon according to your tier in this feat.\n" +
                                "Tier 1 - When you invoke the chosen boon on a single target, you" +
                                " succeed automatically and do not need to make an action roll. " +
                                "You can invoke the boon at any of the power levels you could " +
                                "access via your other means. If the invocation is not a single " +
                                "target, success is not automatic, but you get advantage 2 on " +
                                "the action roll to invoke the boon.\n" +
                                "Tier 2 - You gain advantage 3 on your action roll to invoke the" +
                                " boon if you are not single-targeting. Additionally, you may " +
                                "invoke the boon one time increment faster, as follows: If the " +
                                "invocation time is a major action or move action, it becomes a " +
                                "minor action. If the invocation time is 1 focus action, it " +
                                "becomes 1 major action. If the invocation time is 1 minute, it " +
                                "becomes 1 focus action. If the invocation time is 10 minutes, " +
                                "it becomes 1 minute. If the invocation time is 1 hour, it becomes" +
                                " 10 minutes. If the invocation time is 8 hours, it becomes 1 hour" +
                                ". If the invocation time for a boon is 1 minor action, it can be" +
                                " invoked only once as a minor action. Beyond that it can be " +
                                "invoked by expending a move or major action.\n" +
                                "Tier 3 - The effect at tier 3 varies based on the duration " +
                                "of the boon:\n" +
                                "\n" +
                                "\n" +
                                "If the chosen boon has a duration of \"sustain persists\", you " +
                                "gain advantage 4 on your action roll to invoke if you are not " +
                                "single-targeting. Additionally, one instance of the boon can be" +
                                " sustained each round as a free action, rather than a minor action." +
                                " If the boon is somehow temporarily canceled, in the absence of " +
                                "other rules, you can invoke it again as a free action. If targeted" +
                                " by the nullify bane, this effect can only be canceled by a power " +
                                "level 6 or greater invocation of that bane.\n" +
                                "\n" +
                                "\n" +
                                "If the boon has a different duration, you gain advantage 5 on your" +
                                " action roll to invoke if you are not single-targeting.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "In addition to purchasing multiple tiers of this feat, you may take" +
                                " this feat multiple times and select a new boon each time. Your " +
                                "tier of this feat is independent for each boon.");
                dao.insert(feat);
                feat = new Feat("Breakfall (I - II) ",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 2: Agility 4",
                        "Description:\n\t" +
                                "You are as graceful as a swan. Like the martial artists and" +
                                " swashbucklers of legendary tales, your agility enables you to" +
                                " fall from deadly heights unharmed.",
                        "Effect:\n\t" +
                                "Tier 1 - As long as you are conscious and able to act," +
                                " reduce all falling damage by half.\n" +
                                "Tier 2 - As long as you are conscious and able to act," +
                                " you do not suffer falling damage.");
                dao.insert(feat);
                feat = new Feat("Brutal Intimidation",
                        "Cost: 1 point",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: Might 2",
                        "Description:\n\t" +
                                "Your powers of persuasion stem from application of brute force " +
                                "rather than your social grace. When you smash a table, brandish" +
                                " your blade, or flex your muscles, people stop what they are " +
                                "doing and listen to you.",
                        "Effect:\n\t" +
                                "If you're able to make a show of physical force, you can" +
                                " use your Might attribute in place of Persuasion for the " +
                                "action roll.");
                dao.insert(feat);
                feat = new Feat("Climbing",
                        "Cost: 1 point",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: None",
                        "Description:\n\t" +
                                "You gain the ability to climb or parkour perfectly," +
                                " akin to certain vampires, aberrant creatures, ninjas," +
                                " and insects.",
                        "Effect:\n\t" +
                                "You gain a climb speed equal to your base speed and can scale" +
                                " horizontal and vertical surfaces, even climb upside-down, " +
                                "with no fear of falling.");
                dao.insert(feat);
                feat = new Feat("Combat Follow-through",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: None",
                        "Description:\n\t" +
                                "You are able to decimate many enemies in quick succession." +
                                " Like a legendary Samurai warrior or matchless elven archer," +
                                " your foes fall in waves before you.",
                        "Effect:\n\t" +
                                "Every time you bring an enemy to zero hit points with a Might" +
                                " or Agility attack, you can immediately make an extra attack" +
                                " as a free action.");
                dao.insert(feat);
                feat = new Feat("Combat Momentum",
                        "Cost: 1 point",
                        "Prerequisites:\n\n\t" +
                                "Tier 1: None",
                        "Description:\n\t" +
                                "Whether through brute strength or lightning reflexes," +
                                " you are able to use the momentum of combat to maneuver" +
                                " around the battlefield with ease.",
                        "Effect:\n\t" +
                                "Every time you bring an enemy to zero hit points with a Might" +
                                " or Agility attack, you can immediately move up to your normal" +
                                " speed as a free action.\n" +
                                "\n" +
                                "Special\n" +
                                "If you have access to the teleport boon, you may use it instead" +
                                " of a normal move.");
                dao.insert(feat);
                feat = new Feat("Companion (I - III)",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1-3: None",
                        "Description:\n\t" +
                                "Whether a hired bodyguard, a loyal animal sidekick, or a" +
                                " sibling that follows you everywhere, you have the constant" +
                                " and unflinching loyalty of one particular companion character.",
                        "Effect:\n\t" +
                                "You gain a companion character that acts independently from you." +
                                " During combat, your companion acts on its own initiative count" +
                                " and gains the usual assortment of actions, which you may choose." +
                                " You also get to assign your companion's attributes. Whenever you" +
                                " gain a level or purchase a new tier in this feat, you may" +
                                " reassign your companion's attributes and feats.\n" +
                                "Tier 1 - Your companion has a total of 20 attribute points plus" +
                                " 4 per level of your character.\n" +
                                "Tier 2 - Your companion receives 3 feat points.\n" +
                                "Tier 3 - Your companion has a total of 30 attribute points plus" +
                                " 6 per level of your character. In addition, you can optionally" +
                                " grant feats to your companion. In order to do so, you spend your" +
                                " own feat points and the companion receives the feat instead of" +
                                " you. The companion, not you, must meet all feat prerequisites." +
                                " Any math related to these feats are calculated based on the" +
                                " companion's attributes, feats, etc. If you have spent feat points" +
                                " this way and would gain feat points from any other effect, those" +
                                " feat points are reduced by the number of feat points you have" +
                                " granted to your companion.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "If you ever lose your companion, voluntarily or involuntarily," +
                                " you regain the feat points that you have spent on this feat" +
                                " and any of the companion's feats, and may spend them as usual.\n" +
                                "In addition to purchasing multiple tiers of this feat, you may" +
                                " take this feat multiple times and select a new companion each time.");
                dao.insert(feat);
                feat = new Feat("Craft Mundane Item (I - II) ",
                        "Cost: 2 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 2: Learning 3, or Logic 3, or Knowledge I feat",
                        "Description:\n\t" +
                                "You have mastered a particular craft, and given proper time and" +
                                " materials, you can create items related to that craft." +
                                " You might be an expert blacksmith, professional engineer," +
                                " master alchemist, or any similar manner of professional craftsman.",
                        "Effect:\n\t" +
                                "Choose a specific craft or profession. You can create items that" +
                                " are relevant to your chosen craft, and your GM will determine the" +
                                " speed at which you craft based on the nature of the item and" +
                                " the materials you have access to. Your tier in the Craft Mundane" +
                                " Item feat determines the maximum wealth level of the items you" +
                                " can craft. Unlike acquiring items by using your wealth " +
                                "(described in Chapter 5), crafting does not limit your ability" +
                                " to acquire additional goods.\n" +
                                "Tier 1 - You can craft items equal to your wealth level.\n" +
                                "Tier 2 - You can craft items equal to your wealth level + 1.\n" +
                                "\n" +
                                "Craft Examples (This list is not exhaustive, and you can work " +
                                "with your GM to come up with other suitable crafts):\n" +
                                "Alchemy - acid, chemicals, non-magical tinctures, incense, reagents.\n" +
                                "Arcane - magical ingredients, inks, scrolls, exotic components.\n" +
                                "Blacksmithing - metal, leather, weapons, armor, wheels, horseshoes.\n" +
                                "Chemistry - acid, explosives, narcotics.\n" +
                                "Engineering - machines, wheels, gears, guns, vehicles.\n" +
                                "Geography - maps, cartography, instruments of navigation.\n" +
                                "Herbalism - poultices, natural remedies, stimulants, brewing.\n" +
                                "Medicine - medical tools, tonics, tinctures, pain relievers, anti-toxins.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "In addition to taking multiple tiers of this feat, you may take " +
                                "this feat multiple times and select a new craft or profession " +
                                "each time.");
                dao.insert(feat);
                feat = new Feat("Craft Extraordinary Item (I - III)",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1 - 3: Any Extraordinary 5, Learning 5, or Logic 5",
                        "Description:\n\t" +
                                "You are studied in the ways of imbuing magical items, building" +
                                " futuristic technology, brewing potions, or crafting " +
                                "extraordinary devices. Their power is permanent but varies " +
                                "depending on your skill.",
                        "Effect:\n\t" +
                                "Provided you have the appropriate working space and materials " +
                                "(as determined by the GM), you can create extraordinary items" +
                                " (as detailed in Chapter 9: Special Equipment). You can only " +
                                "imbue an item with attributes, banes, and boons that you can " +
                                "access. For example, in order to create a sword with Energy 5, " +
                                "you must possess an Energy score of 5 or higher. The only " +
                                "exception to this is if you possess the Creation, Learning, or " +
                                "Logic attributes. These allow you to imbue items with any " +
                                "attribute, bane, or boon as long as their value is less than or " +
                                "equal to your attribute score. The GM may rule that certain " +
                                "uses of Creation, Learning, or Logic are unreasonable when it " +
                                "comes to crafting extraordinary items.\n" +
                                "Your tier in this feat determines the maximum wealth level of " +
                                "the items you can create, based on the attribute you are using " +
                                "to craft:\n" +
                                "Tier 1 - Maximum wealth level equals attribute minus 2\n" +
                                "Tier 2 - Maximum wealth level equals attribute minus 1\n" +
                                "Tier 3 - Maximum wealth level equals attribute\n" +
                                "\n" +
                                "For example, a character with Creation 5 and tier 1 in this feat" +
                                " could create items up to wealth level 3.\n" +
                                "You can determine the wealth level of the item you want to create" +
                                " by consulting the sample items in Chapter 9: Special Equipment" +
                                " or by developing a custom item using the rules for Building " +
                                "Your Own Extraordinary Items in that chapter.\n" +
                                "Creating an item with the consumable or expendable property " +
                                "requires one full 8-hour day of uninterrupted work. Other " +
                                "items require a duration of uninterrupted work based on their " +
                                "wealth level, as follows:\n" +
                                "Wealth Level 1 - 3: Two days per wealth level.\n" +
                                "Wealth Level 4 - 5: Four days per wealth level.\n" +
                                "Wealth Level 6 - 7: One week per wealth level.\n" +
                                "Wealth Level 8 - 9: One month per wealth level.\n" +
                                "\n" +
                                "At the end of this time, your item is created. Crafting an item " +
                                "still counts as an expenditure of wealth, so you must have a " +
                                "sufficient wealth score to purchase the item, following all " +
                                "the rules for spending wealth provided in Chapter 5: Wealth & " +
                                "Equipment. The GM may waive some or all of the costs associated" +
                                " with an item if you possess special materials for the crafting" +
                                " of your item. For example, if you have recently collected the " +
                                "hide of a slain red dragon and decide to make a suit of Armor of" +
                                " Fire Resistance, the GM may decide that the dragon’s hide is " +
                                "enough to make up most of the costs of the armor, so the armor’s" +
                                " wealth level is reduced by 3 for purposes of determining crafting" +
                                " costs.");
                dao.insert(feat);
                feat = new Feat("Crushing Blow",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1:\n" +
                                "Might 6\n" +
                                "Overpowering Strike feat",
                        "Description:\n\t" +
                                "Like a reckless ogre wading through combat, your relentless" +
                                " blows not only knock your opponents back, but also knock" +
                                " them off their feet completely.",
                        "Effect:\n\t" +
                                "Any time that you deal damage to an enemy, in addition to pushin" +
                                "g them 5 feet (if you choose) from the Overpowering Strike feat," +
                                " you can also knock them down in the space where the forced" +
                                " move ends; the target suffers the effects of the knockdown bane.");
                dao.insert(feat);
                feat = new Feat("Death Blow (I - II)",
                        "Cost: 3 points",
                        "Prerequisites:\n\n\t" +
                                "Tier 1:\n" +
                                "Agility 6\n" +
                                "Lethal Strike I feat\n" +
                                "Tier 2:\n" +
                                "Agility 7\n" +
                                "Lethal Strike III feat",
                        "Description:\n\t" +
                                "You are able to quickly finish off enemies that are near death" +
                                " and silence them before they cry out. This attack is one that" +
                                " is commonly seen used by rogues, assassins, and snipers" +
                                " who can silently eliminate weaker enemies without being detected.",
                        "Effect:\n\t" +
                                "Tier 1 - If you damage an enemy with a Lethal Strike and their" +
                                " total HP is 5 or less after the attack, then you can choose" +
                                " to reduce them to zero HP instead. In addition, you can choose" +
                                " to silence any enemy reduced to zero hit points by an attack " +
                                "from you.\n" +
                                "Tier 2 - Your death blow HP threshold increases from 5 to 10. " +
                                "In addition, on a successful Lethal Strike, the stunned bane " +
                                "is automatically inflicted without counting against your usual" +
                                " 1 bane per attack limit.");
                dao.insert(feat);
                feat = new Feat("Deathless Trance ",
                        "Cost: 3 points",
                        "Tier 1:\n" +
                                "Fortitude 7\n" +
                                "Battle Trance feat",
                        "Description:\n\t" +
                                "Whether you are a berserker of the icy north, a hulking superhero" +
                                " of unstoppable might, or a cybernetically enhanced soldier," +
                                " your battle fury is legendary. You possess the rare ability" +
                                " to fight on long after your body should have given up.",
                        "Effect:\n\t" +
                                "While in a battle trance you cannot be knocked unconscious." +
                                " All damage dealt to you should be recorded, possibly resulting" +
                                " in a negative hit point total. Despite any amount of damage," +
                                " you remain conscious for as long as you can sustain the battle" +
                                " trance. When the battle trance ends, if your hit points are below" +
                                " zero, you collapse unconscious. If you are not healed to zero" +
                                " or more hit points within 1 round of your battle trance ending," +
                                " you die.");
                dao.insert(feat);
                feat = new Feat("Defensive Mastery",
                        "Cost: 3 points",
                        "Tier 1: None",
                        "Description:\n\t" +
                                "You know how to turn a strong offense into an even stronger" +
                                " defense. Your special training or experience with defensive" +
                                " implements and shields allows you to capitalize on their" +
                                " defensive benefits far beyond the average wielder. Examples" +
                                " include a martial artist's defensive kata or a soldier" +
                                " equipped with a riot shield.",
                        "Effect:\n\t" +
                                "When wielding a weapon or implement with the defensive property," +
                                " you gain an additional +1 armor bonus. In addition, the" +
                                " defensive value of the item is increased by 1 when you" +
                                " wield it. So defensive 1 becomes defensive 2 and defensive" +
                                " 2 becomes defensive 3.");
                dao.insert(feat);
                feat = new Feat("Defensive Reflexes (I - IX)",
                        "Cost: 2 points",
                        "Tier 1 - 9: Agility 3",
                        "Description:\n\t" +
                                "You are a paragon of defensive fighting, able to masterfully" +
                                " thwart enemy attacks. By predicting your opponents' movements," +
                                " strikes, or shots, you can cut them off before they are a threat.",
                        "Effect:\n\t" +
                                "Any time you use the defend action, you gain advantage 1" +
                                " on the action roll per tier you possess of this feat.");
                dao.insert(feat);
                feat = new Feat("Destructive Trance",
                        "Cost: 3 points",
                        "Tier 1:\n" +
                                "Agility 7, Might 7, Energy 7, or Entropy 7\n" +
                                "Battle Trance feat",
                        "Description:\n\t" +
                                "In the heat of combat, you become a destructive force to be" +
                                " reckoned with. Whether a raging barbarian or a hyper-focused" +
                                " intergalactic knight, your attacks become particularly ferocious" +
                                " when you enter your battle trance.",
                        "Effect:\n\t" +
                                "When you make an attack roll in a battle trance, all of the" +
                                " dice in your dice pool explode on either maximum or the " +
                                "number 1 below maximum (though the total is still the number" +
                                " rolled). This means that d4s explode on a 3 or 4, d6s explode" +
                                " on a 5 or 6, d8s explode on a 7 or 8, and so on.");
                dao.insert(feat);
                feat = new Feat("Diehard",
                        "Cost: 2 points",
                        "Tier 1: Presence 3, or Fortitude 3",
                        "Description:\n\t" +
                                "Whether luck shines upon you or you're just really hard to kill," +
                                " you have a knack for staying in the fight when others would tap" +
                                " out. You might be a plucky rogue who always finds a safe nook" +
                                " to duck into or a veteran marine specially trained to grit your" +
                                " teeth and buck up when things look grim.",
                        "Effect:\n\t" +
                                "Once per day, an attack that would reduce you to less than 1 HP," +
                                " reduces you to 1 HP instead.");
                dao.insert(feat);
                feat = new Feat("Energy Resistance (I - IV)",
                        "Cost: 2 points",
                        "Tier 1 - 4: None",
                        "Description:\n\t" +
                                "Whether due to inherited racial traits, specialization in a" +
                                " particular type of energy, or inherent extraordinary protection," +
                                " you are resistant to a specific type of energy. A fiery sorceress" +
                                " immune to the hottest blaze or a biologically anomalous alien" +
                                " race that is immune to poison are both examples of this feat" +
                                " in play.",
                        "Effect:\n\t" +
                                "Choose from the following energy types: fire, cold, lightning," +
                                " acid, poison, or another at the GM's discretion. When you are" +
                                " attacked with that energy type, you gain resistance to the" +
                                " attack as follows:\n" +
                                "Tier 1 - Your defense scores are increased by 3 against the" +
                                " chosen energy type.\n" +
                                "Tier 2 - Your defense scores are increased by 6 against the" +
                                " chosen energy type.\n" +
                                "Tier 3 - Your defense scores are increased by 9 against the" +
                                " chosen energy type.\n" +
                                "Tier 4 - You are immune to damage and harmful effects from" +
                                " the chosen energy type.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "In addition to purchasing multiple tiers of this feat, you may" +
                                " take this feat multiple times and select a new energy" +
                                " type each time.");
                dao.insert(feat);
                feat = new Feat("Evasive Footwork",
                        "Cost: 2 points",
                        "Tier 1: Agility 4",
                        "Description:\n\t" +
                                "You are able to dodge and weave in combat, deftly sidestepping" +
                                " attacks that would threaten a clumsier combatant. An agile " +
                                "ninja who tumbles and flips around foes and an alien snake" +
                                " creature that slithers throughout the battlefield are both" +
                                " examples of this feat in play.",
                        "Effect:\n\t" +
                                "When you move from a space adjacent to an enemy to another" +
                                " space not adjacent to that enemy, the enemy does not get the" +
                                " usual opportunity attack.");
                dao.insert(feat);
                feat = new Feat("Extraordinary Defense (I - III) ",
                        "Cost: 3 points",
                        "Tier 1: Movement 2, Prescience 2, or Protection 2\n" +
                                "Tier 2: Movement 3, Prescience 3, or Protection 3\n" +
                                "Tier 3: Movement 4, Prescience 4, or Protection 4",
                        "Description:\n\t" +
                                "Whether by a magical barrier of force, foresight into the future," +
                                " or preternatural speed, you are gifted with extraordinary" +
                                " protection from harm. Attacks are less likely to strike you," +
                                " and when they do, they aren't as damaging as they would be to" +
                                " others.",
                        "Effect:\n\t" +
                                "You gain a +1 bonus to all defenses for each tier you have" +
                                " in this feat. This increases your Toughness, Guard, and " +
                                "Resolve defenses.");
                dao.insert(feat);
                feat = new Feat("Extraordinary Focus",
                        "Cost: 3 points",
                        "Tier 1: Any Extraordinary 1",
                        "Description:\n\t" +
                                "Your extraordinary power stems from your connection with a" +
                                " particular focus, such as a wand, digital psi amplifier, holy" +
                                " symbol, or spellbook. When this focus item is in your hands," +
                                " you are a force to be reckoned with compared to others with" +
                                " similar powers.",
                        "Effect:\n\t" +
                                "With the approval of your GM, choose a focus from which your" +
                                " power with a single extraordinary attribute stems. Some " +
                                "possibilities include a wand, a digital psi amplifier, a " +
                                "crystal ball, a spell book, a holy symbol, a weapon, your voice," +
                                " or an animal familiar. You cannot use the selected extraordinary" +
                                " attribute without your focus. The focus heightens your power and" +
                                " for the purposes of determining your attribute dice for action " +
                                "rolls, you treat the chosen attribute as if it was one greater. " +
                                "For all purposes outside of attribute dice, your ability score " +
                                "remains unchanged (feats, banes, boons, etc.).\n" +
                                "\n" +
                                "Special\n" +
                                "If you ever lose your extraordinary focus, voluntarily or" +
                                " involuntarily, you regain the feat points that you have spent" +
                                " on this feat and may spend them as usual.\n" +
                                "You may take this feat multiple times. If you do, select a new" +
                                " attribute not chosen previously. For each instance of this feat," +
                                " you may choose an existing focus or select a new one.");
                dao.insert(feat);
                feat = new Feat("Extraordinary Healing",
                        "Cost: 3 points",
                        "Tier 1: Creation 5",
                        "Description:\n\t" +
                                "Whether you summon priestly magics, utilize advanced technologies," +
                                " or apply alchemical concoctions, your mastery of extraordinary" +
                                " healing is such that you are able to cure mortal wounds that are" +
                                " beyond the power of the average healer.",
                        "Effect:\n\t" +
                                "When invoking the heal boon, you can choose to take one hour" +
                                " instead of the usual invocation time. If you do, you heal an" +
                                " amount of lethal damage equal to the total healing from the" +
                                " successful boon invocation. This lethal damage is healed in" +
                                " addition to the normal hit point damage that your boon heals.");
                dao.insert(feat);
                feat = new Feat("Fast Draw",
                        "Cost: 1 point",
                        "Tier 1: Agility 1",
                        "Description:\n\t" +
                                "Whether you're a samurai warrior, the fastest draw in the West," +
                                " or a flawlessly trained interstellar soldier, you can get to" +
                                " your weapon faster than your opponent can blink.",
                        "Effect:\n\t" +
                                "Once per round, you can draw one additional weapon and sheathe" +
                                " another as a free action. Alternately, you could do the same" +
                                " with any small sized object in your possession.");
                dao.insert(feat);
                feat = new Feat("Fast Tracker",
                        "Cost: 2 points",
                        "Tier 1: Agility 5, or Perception 5",
                        "Description:\n\t" +
                                "Following a trail is an everyday part of your life, and as" +
                                " such it is no more taxing than breathing or blinking. Whether" +
                                " you are an experienced woodsman, a bounty hunter for the Galactic" +
                                " Senate, or a humanoid cat creature with heightened senses," +
                                " your expertise at tracking allows you to get it done faster" +
                                " than the average hunter.",
                        "Effect:\n\t" +
                                "You move unhindered and at full speed when tracking your quarry.");
                dao.insert(feat);
                feat = new Feat("Ferocious Minions (I - III)",
                        "Cost: 2 points",
                        "Tier 1: Alteration 4, Creation 4, Entropy 4, Energy 4," +
                                " or Influence 4\n" +
                                "Tier 2: Alteration 5, Creation 5, Entropy 5, Energy 5," +
                                " or Influence 5\n" +
                                "Tier 3: Alteration 7, Creation 7, Entropy 7, Energy 7," +
                                " or Influence 7",
                        "Description:\n\t" +
                                "Whether you are a necromancer who summons hordes of undead, an" +
                                " inventor who crafts autonomous defense droids, or a psychic" +
                                " capable of bending others to your will, minions are exceptionally" +
                                " strong under your command.",
                        "Effect:\n\t" +
                                "Creatures under the effects of your charmed or dominated banes," +
                                " or those created by your invocation of the summon creature boon," +
                                " gain advantage 1 on all attack rolls to protect you or act in" +
                                " your favor for each tier of this feat you possess.");
                dao.insert(feat);
                feat = new Feat("Fleet of Foot (I - III)",
                        "Cost: 2 points",
                        "Tier 1: Agility 4, Fortitude 4, or Movement 2\n" +
                                "Tier 2: Agility 5, Fortitude 5, or Movement 4\n" +
                                "Tier 3: Agility 7, Fortitude 7, or Movement 6",
                        "Description:\n\t" +
                                "Whether through cybernetic implants, telekinetic propulsion," +
                                " or simply hardcore training, you are faster than most." +
                                " This feat is common to swashbucklers, martial artists," +
                                " super soldiers, and psychic warriors.",
                        "Effect:\n\t" +
                                "Your speed is permanently increased by 5' per tier of this feat.");
                dao.insert(feat);
                feat = new Feat("Flying",
                        "Cost: 3 points",
                        "Tier 1: None",
                        "Description:\n\t" +
                                "Whether through a pair of celestial or infernal wings, an inherent" +
                                " telekinetic force, or mutant super powers, you possess the" +
                                " ability to fly.",
                        "Effect:\n\t" +
                                "You gain a flight speed equal to your normal speed. At the" +
                                " GM's discretion, certain hostile actions may be capable of " +
                                "canceling your flight, sending you hurtling to your doom. If " +
                                "your flight is anatomical, the immobile bane might rende" +
                                "r your wings immovable. If telekinetic, an application of the " +
                                "nullify bane may cancel your flight.");
                dao.insert(feat);
                feat = new Feat("Great Leap (I - III)",
                        "Cost: 1 point",
                        "Tier 1: Movement 2, or Agility 2\n" +
                                "Tier 2: Movement 4, or Agility 4\n" +
                                "Tier 3: Movement 6, or Agility 6",
                        "Description:\n\t" +
                                "Through extraordinary power or exceptional agility, you can" +
                                " jump much farther than the average creature. A telekinetic" +
                                " superhero and an insectoid race of bipedal cricket-like beings" +
                                " are both examples of this feat in play.",
                        "Effect:\n\t" +
                                "You can use your Movement or Agility score instead of your Might" +
                                " score when determining how far you can jump. In addition, you" +
                                " gain advantage 1 per tier on action rolls to jump.");
                dao.insert(feat);
                feat = new Feat("Hallucination (I - II)",
                        "Cost: 3 points",
                        "Tier 1: Influence 5\n" +
                                "Tier 2: Influence 7",
                        "Description:\n\t" +
                                "You are able to use your powers of illusion to not only create" +
                                " phantasmal figments, but to completely dominate the sensory" +
                                " perceptions of individual targets. Such power is wielded by the" +
                                " likes of legendary enchanters, psychics, and shamans. Those who" +
                                " can master such powers are often capable of neutralizing angry" +
                                " mobs without shedding a drop of blood.",
                        "Effect:\n\t" +
                                "Tier 1 - When you invoke the phantasm bane, you may choose to " +
                                "create a hallucination within a single target's mind instead of" +
                                " an illusion that is perceptible to everyone. You gain complete " +
                                "control over the target's senses (as granted by the power level" +
                                " of your bane), and thus the hallucination is not restricted by" +
                                " size or area. Your hallucination may only target a single creature" +
                                " and is not eligible for multi-targeting attacks. In addition," +
                                " unless the target is damaged, they suffer disadvantage on resist" +
                                " rolls against the bane.\n" +
                                "Tier 2 - When you invoke the hallucination form of the phantasm" +
                                " bane, you may target additional creatures within range as" +
                                " determined by your Influence score. This does not count as" +
                                " a multi-target attack and thus does not incur disadvantage" +
                                " on your action roll.\n" +
                                "Influence 7 - 5 targets\n" +
                                "Influence 8 - 10 targets\n" +
                                "Influence 9 - 50 targets");
                dao.insert(feat);
                feat = new Feat("Heightened Invocation (I - III)",
                        "Cost: 2 points",
                        "Tier 1: Any Extraordinary 4\n" +
                                "Tier 2: Any Extraordinary 6\n" +
                                "Tier 3: Any Extraordinary 9",
                        "Description:\n\t" +
                                "By channeling your extraordinary powers through extended research" +
                                " or extensive rituals, such as meditation, fasting, blood letting," +
                                " or sacrifices, you are able to increase the strength of your" +
                                " invocations. This feat is common among wizards, inventors, mad" +
                                " scientists, and similar characters who use extraordinary" +
                                " abilities to achieve great deeds.",
                        "Effect:\n\t" +
                                "When invoking a bane or boon, you may choose to do so as a" +
                                " heightened invocation. The invocation time for a heightened" +
                                " invocation is one increment higher than usual as follows:\n" +
                                "1 action becomes 1 minute\n" +
                                "1 minute becomes 10 minutes\n" +
                                "10 minutes becomes 1 hour\n" +
                                "1 hour becomes 8 hours\n" +
                                "8 hours becomes 24 hours\n" +
                                "\n" +
                                "\n" +
                                "Tier 1 - When performing a heightened invocation, you may choose" +
                                " one of the following effects to empower your bane or boon:\n" +
                                "\n" +
                                "Increase the range of the effect as follows:\n" +
                                "Attribute 5 = 500ft\n" +
                                "\n" +
                                "Attribute 6 = 1/2 mile\n" +
                                "\n" +
                                "Attribute 7 = 1 mile\n" +
                                "\n" +
                                "Attribute 8 = 10 miles\n" +
                                "\n" +
                                "Attribute 9 = 100 miles\n" +
                                "Negate two levels of disadvantage caused by multi-targeting" +
                                " (e.g., target 2 creatures or a 10' square for free instead of" +
                                " disadvantage 2).\n" +
                                "For your action roll, treat your attribute score as if it was one" +
                                " greater for purposes of determining attribute dice. Note that" +
                                " this doesn't grant access to banes or boons you could not normally" +
                                " access. It only increases the dice used for the action roll.\n" +
                                "\n" +
                                "\n" +
                                "Tier 2 - You gain the following options when you perform a" +
                                " heightened invocation:\n" +
                                "You can lead others to join you in group invocation as long as" +
                                " they are also able to invoke the bane or boon at the same power" +
                                " level that you are invoking it at. At the conclusion of the group" +
                                " invocation, each contributor may choose one of the effects granted" +
                                " by Tier 1 of this feat.\n" +
                                "You gain the following additional options to choose from when" +
                                " empowering your invocations with heightened invocation:\n" +
                                "Cause a boon to persist for 1 minute automatically without needing" +
                                " to use a sustain action. Furthermore, enemies cannot end the" +
                                " boon through use of a disrupting attack (though the nullify " +
                                "bane still works).\n" +
                                "Targets may not make resist rolls against a bane for one minute" +
                                " after it is invoked.\n" +
                                "\n" +
                                "\n" +
                                "Tier 3 - You gain the ability to permanently bestow or dispel " +
                                "banes and boons. In order to bestow the bane or boon, you must" +
                                " rigorously attend to the invocation process for a number of " +
                                "days equal to the power level of the bane or boon to be invoked" +
                                " or nullified. During that time you can eat, sleep, and act " +
                                "normally with two exceptions: 1) You must work actively on the" +
                                " invocation and with minimal interruption for 8 hours out of " +
                                "each day. 2) You can leave the area and move about freely during" +
                                " the down time each day, but for the 8 hours of active heightened" +
                                " invocation you must be in the same physical or geographic " +
                                "location where the invocation was initiated. When the invocation" +
                                " time is completed, make an action roll as follows:\n" +
                                "Bestow Boon - Make an action roll to invoke the boon as usual." +
                                " If successful, you cause a non-instantaneous & non-permanent " +
                                "boon to permanently affect the target. The target can thereafter" +
                                " invoke the boon at will with a free action, without requiring" +
                                " an action roll to do so. The target does not need to use a sustain" +
                                " action to persist the effect, and the effect can only be" +
                                " nullified either temporarily with the nullify bane, or" +
                                " permanently with the Heightened Invocation feat" +
                                " (see the Dispel Boon entry that follows).\n" +
                                "Bestow Bane - Make an action roll to invoke the bane as usual." +
                                " If successful, you cause a non-instantaneous & non-permanent" +
                                " bane to permanently affect the target. The bane persists " +
                                "indefinitely and does not allow resist rolls to end its effects." +
                                " The effect can be canceled either temporarily with the nullify" +
                                " bane, or permanently with the Heightened Invocation feat " +
                                "(see the Dispel Bane entry that follows).\n" +
                                "Dispel Boon - Make an Entropy roll with a Challenge Rating " +
                                "equal to 10 + twice the power level of the boon you are " +
                                "attempting to dispel. If successful, you cause a permanent boon" +
                                " to be forever stripped from the target, causing them to lose" +
                                " the ability to invoke the boon automatically.\n" +
                                "Dispel Bane - Make a Protection roll with a Challenge Rating " +
                                "equal to 10 + twice the power level of the bane you are " +
                                "attempting to dispel. If successful, you break the curse of" +
                                " a permanent bane afflicting the target, though your target" +
                                " gains no special immunity to it.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "Permanently bestowing banes or boons via this feat can " +
                                "dramatically impact the mechanical balance of a story. " +
                                "Just as with other permanent effects like Extraordinary Item" +
                                " creation, the invocation of permanent banes or boons is " +
                                "subject to GM's discretion, and using this feat in a way that" +
                                " makes one particular character overly powerful should be prohibited.");
                dao.insert(feat);
                feat = new Feat("Hospitaler",
                        "Cost: 2 points",
                        "Tier 1: Creation 4, Presence 4, or Protection 4",
                        "Description:\n\t" +
                                "Through inspiring words, magical healing, or advanced medical" +
                                " technique, you are exceptionally skilled at helping others" +
                                " shake off baneful afflictions. Paladins, bards, and combat" +
                                " medics are all typical examples of characters who are masters" +
                                " of this feat.",
                        "Effect:\n\t" +
                                "You can use a major action to give an ally an immediate resist" +
                                " roll (a free action for the ally) with advantage 1. Additionally," +
                                " you gain advantage 1 any time you attempt to invoke the" +
                                " restoration boon.");
                dao.insert(feat);
                feat = new Feat("Impervious Trance",
                        "Cost: 3 points",
                        "Tier 1:\n" +
                                "Will 7\n" +
                                "Battle Trance feat",
                        "Description:\n\t" +
                                "In the heightened focus of battle, your will becomes indomitable." +
                                " Like a monk with unflinching mental focus or a berserker" +
                                " who is too bloodthirsty to be stopped, you cannot be thwarted" +
                                " by fear, charm, or similar attempts to overcome your willpower.",
                        "Effect:\n\t" +
                                "While you are in a battle trance, you are immune to banes that" +
                                " target your Resolve. If you were already under the effect of" +
                                " such a bane, it is negated for the duration of your battle" +
                                " trance and returns when your battle trance ends.");
                dao.insert(feat);
                feat = new Feat("Indomitable Endurance (I - V)",
                        "Cost: 2 points",
                        "Tier 1 - 5: Fortitude 5, or Will 5",
                        "Description:\n\t" +
                                "Your endurance and willpower are legendary, allowing you to push" +
                                " on when others would keel over from exhaustion. A barbarian able" +
                                " to recover their wind after a mighty frenzy, or a computer hacker" +
                                " capable of routinely going for days without sleep while focused" +
                                " on a singular objective are good examples of this feat in action.",
                        "Effect:\n\t" +
                                "You are able to shrug off the effects of the fatigued bane. For" +
                                " each tier you possess in this feat, treat your fatigue level" +
                                " as one lower than it actually is for the purposes of determining" +
                                " the bane's effects.");
                dao.insert(feat);
                feat = new Feat("Indomitable Resolve (I - III)",
                        "Cost: 1 point",
                        "Tier 1: Presence 3, or Will 3\n" +
                                "Tier 2: Presence 4, or Will 4\n" +
                                "Tier 3: Presence 5, or Will 5",
                        "Description:\n\t" +
                                "Your resolve is exceptional, making your more resilient to mental" +
                                " effects that would overwhelm those of lesser mettle." +
                                " A keen-minded space captain and a wizened mage are " +
                                "both exemplars of this feat in action.",
                        "Effect:\n\t" +
                                "For each tier you possess in this feat, your Resolve defense is" +
                                " increased by 1.");
                dao.insert(feat);
                feat = new Feat("Inspiring Champion (I - III) ",
                        "Cost: 2 points",
                        "Tier 1: Presence 4\n" +
                                "Tier 2: Presence 5\n" +
                                "Tier 3: Presence 6",
                        "Description:\n\t" +
                                "You fight with such bravery, heroism, or bravado that your" +
                                " allies are inspired to fight beyond their usual mettle. Common" +
                                " examples of characters who typify this feat include a shining" +
                                " knight, a fearless platoon leader, and a heroic bard.",
                        "Effect:\n\t" +
                                "Once per round, when your roll for a damaging attack exceeds" +
                                " an enemy's defense by 10 or more, you can grant healing to" +
                                " your allies as outlined below. In order to gain this healing," +
                                " allies must be within a range of 5' times your Presence score.\n" +
                                "Tier 1 - A single ally that can see the attack heals 1d4 HP.\n" +
                                "Tier 2 - A number of allies equal to your Presence score who" +
                                " can see the attack heal 1d4 HP.\n" +
                                "Tier 3 - All allies who can see the attack heal 2d4 HP.");
                dao.insert(feat);
            });
        }
    };
}
