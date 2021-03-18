package ca.unb.mobiledev.openlegendrpg.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ca.unb.mobiledev.openlegendrpg.Items.Bane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ca.unb.mobiledev.openlegendrpg.dao.baneDao;


/**
 * Database layer in top of the SQLite database
 */
@Database(entities = {Bane.class}, version = 1, exportSchema = false)
public abstract class BaneRoomDatabase extends RoomDatabase {

    public abstract baneDao baneDao();
    private static volatile BaneRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 15;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BaneRoomDatabase getDatabase(final Context context) {
        if (null == INSTANCE) {
            synchronized (BaneRoomDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BaneRoomDatabase.class, "bane_database")
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
                baneDao dao = INSTANCE.baneDao();
                dao.deleteAll();

                Bane bane = new Bane("Blinded ",
                        "Power Level: 5",
                        "Description:\n\tYou blind your foe with anything from a massive explosion, to " +
                                "a handful of sand, to an arctic blast, to a dazzling flash of " +
                                "light. Pirates, snipers, rogues, and necromancers often make " +
                                "use of this bane in combat.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Creation, Energy, Entropy",
                        "Attack:\n" +
                                "\n" +
                                "Agility vs. Guard\n" +
                                "Creation vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\tThe target cannot see as long as the effect persists. The target" +
                                " automatically fails any Perception rolls based solely on normal" +
                                " sight. Attack rolls and Perception rolls based partially on sight" +
                                " that can be supplemented by another sense suffer disadvantage 5. " +
                                "The target's Guard defense is reduced by 3.");
                dao.insert(bane);
                bane = new Bane("Charmed",
                        "Power Level: 3/ 4/ 6",
                        "Description:\n\tCharms are one of the great banes of legend, wielded by powerful" +
                                " enchantresses like Circe (of Homer's The Odyssey), nymphs, " +
                                "psychics, and other characters who control the will of others, " +
                                "not through total domination, but through a magical spell of love" +
                                " or friendship.",
                        "Duration: Resist ends (special) (Fail x 3 = 24 hours)",
                        "Attack Attributes: Influence",
                        "Attack:\n" +
                                "\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\tThe charmed bane can only be inflicted via a bane " +
                                "attack. Damaging attacks that trigger banes cannot trigger this " +
                                "bane. The charmed bane manifests at two levels: minor and major.\n" +
                                "Minor Charm - The target is mentally compelled to become more " +
                                "friendly, only changing their attitude toward you moderately. If " +
                                "they are about to strike you, they will restrain themselves - " +
                                "still angry and hostile, but no longer violent. If they want to " +
                                "help you and are leaning toward trusting you, but have some " +
                                "hesitation because you've just met, then that hesitation goes away.\n" +
                                "Major Charm - The attacker chooses whether the major charm is " +
                                "platonic or romantic. If platonic, the bane causes the target to" +
                                " consider the attacker their best friend and one of the most " +
                                "trustworthy and noble people they have met in all their lives. " +
                                "Alternatively, the attacker can choose for this trust and " +
                                "admiration to manifest as romantic love. The target is unable to " +
                                "do anything to plot against the one who afflicted them, and will" +
                                " (at the earliest possible opportunity) tell their charmer of any" +
                                " rumored harm or danger coming their way. The afflicted character" +
                                " becomes immediately suspicious of anyone who speaks ill of their" +
                                " attacker.\n" +
                                "The target is mentally compelled to like and trust you more, " +
                                "depending on the power level of the bane when invoked.\n" +
                                "\n" +
                                "Power Level 3 - You can Minor Charm creatures of animal level " +
                                "intelligence or lower.\n" +
                                "\n" +
                                "Power Level 4 - You can Minor Charm creatures of humanoid " +
                                "intelligence. You can Major Charm creatures of animal level " +
                                "intelligence or lower.\n" +
                                "\n" +
                                "Power Level 6 - You can Major Charm creatures of humanoid " +
                                "intelligence.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to " +
                                "resist it, this bane prevents the target from being aware of " +
                                "their affliction and thus prevents them from actively attempting" +
                                " to break free. However, the target's true mind is magically " +
                                "suppressed but fights to regain control. As such, at the end of " +
                                "each of its turns, the target receives a resist roll as a free " +
                                "action to break free from the effect. When your target succeeds " +
                                "at a resist roll against this bane, they become immune to all " +
                                "subsequent attempts by you to inflict the bane for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Deafened",
                        "Power Level: 4",
                        "Description:\n\tYou deafen your foe with a crash of thunder, a deft strike to " +
                                "their ears, or a dark energy that disables their hearing. This" +
                                " bane is common to storm mages, mad scientists, and assassins.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy",
                        "Attack:\n" +
                                "\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Toughness\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\tThe target cannot hear as long as the effect persists." +
                                " The target automatically fails any Perception rolls based solely" +
                                " on hearing. Perception rolls based partially on hearing that can" +
                                " be supplemented by another sense suffer disadvantage 3.");
                dao.insert(bane);
                bane = new Bane("Death",
                        "Power Level: 9",
                        "Description:\n\tUtilizing either incredible precision or the power of entropy," +
                                " you snuff out the target's life force completely. The deadliest" +
                                " assassins and most powerful necromancers are known for such " +
                                "legendary skill at ending life.",
                        "Duration: Resist ends (special) (Fail x 3 = Permanent)",
                        "Attack Attributes: Agility, Entropy",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\tUpon a successful invocation, the target is immediately rendered immobile, unconscious, and unable to take actions. They have disadvantage 5 on all Perception rolls, and any damaging attacks against them count as finishing blows.\n" +
                                "If the target fails three resist rolls to shake off this bane, they die. The death is permanent and can only be reversed if the GM allows a special mission, use of a rare technology, or long-forgotten magic to restore the target to life.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to resist" +
                                " it, this bane renders the target incapable of taking actions and" +
                                " thus prevents them from actively attempting to break free. " +
                                "However, the target's body fights to regain consciousness and " +
                                "resist the impending death. As such, at the end of each of its " +
                                "turns, the target receives a resist roll as a free action to break" +
                                " free from the effect. When the target succeeds at a resist roll " +
                                "against this bane, they become immune to all subsequent attempts " +
                                "by you to inflict the bane for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Demoralized",
                        "Power Level: 3/ 6/ 8",
                        "Description:\n\tUsing your quick wit, intimidating presence, or even a strong" +
                                " display of magical power, you cause your enemies to doubt " +
                                "themselves. A berserker might achieve this effect by foaming at" +
                                " the mouth while a swashbuckling space captain might dishearten" +
                                " his foes simply with intimidating words.",
                        "Duration: Resist (minor) ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy, Influence, Might," +
                                " Persuasion, Presence",
                        "Attack:\n\n" +
                                "Agility vs. Resolve\n" +
                                "Energy vs. Resolve\n" +
                                "Entropy vs. Resolve\n" +
                                "Influence vs. Resolve\n" +
                                "Might vs. Resolve\n" +
                                "Persuasion vs. Resolve\n" +
                                "Presence vs. Resolve",
                        "Effect:\n\tThe affected target has disadvantage on all action rolls.\n" +
                                "\n" +
                                "Power Level 3 - Disadvantage 1.\n" +
                                "\n" +
                                "Power Level 6 - Disadvantage 2.\n" +
                                "\n" +
                                "Power Level 8 - Disadvantage 3.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Resisting this bane is a minor action.\n" +
                                "When inflicting this bane using Agility or Might, you may " +
                                "determine range using the Non-Physical Attack Range table " +
                                "(see Chapter 7: Combat).");
                dao.insert(bane);
                bane = new Bane("Disarmed",
                        "Power Level: 3/ 6",
                        "Description:\n\tUsing your quick wit, intimidating presence, or even a strong" +
                                " display of magical power, you cause your enemies to doubt " +
                                "themselves. A berserker might achieve this effect by foaming at" +
                                " the mouth while a swashbuckling space captain might dishearten" +
                                " his foes simply with intimidating words.",
                        "Duration: Instantaneous",
                        "Attack Attributes: Agility, Energy, Entropy, Influence, Might," +
                                " Persuasion, Presence",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Alteration vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Entropy vs. Toughness\n" +
                                "Influence vs. Resolve\n" +
                                "Might vs. Guard\n" +
                                "Movement vs. Guard",
                        "Effect:\n\tThe affected target has disadvantage on all action rolls.\n" +
                                "\n" +
                                "Power Level 3 - Disadvantage 1.\n" +
                                "\n" +
                                "Power Level 6 - Disadvantage 2.\n" +
                                "\n" +
                                "Power Level 8 - Disadvantage 3.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Resisting this bane is a minor action.\n" +
                                "When inflicting this bane using Agility or Might, you may " +
                                "determine range using the Non-Physical Attack Range table " +
                                "(see Chapter 7: Combat).");
                dao.insert(bane);
                bane = new Bane("Dominated",
                        "Power Level: 3/ 5/ 9",
                        "Description:\n\tThough rare, domination is seen from time to time in legendary" +
                                " tales, often wielded by vampires, and sometimes by the most" +
                                " powerful of sorcerers or mad scientists who command legions of" +
                                " mindless zombies, completely enslaved to their will.",
                        "Duration: Special",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\tThe dominated bane manifests at two levels: lesser and" +
                                " greater.\n" +
                                "Lesser Domination - The target obeys a one word command until the" +
                                " end of their next turn, at which time the bane immediately ends.\n" +
                                "Greater Domination - The target's every action and move is under" +
                                " your control. Unlike the charmed bane, characters under the " +
                                "effect of domination lose control of their actions. Their minds," +
                                " however, struggle to regain control of their own body. They" +
                                " cannot take actions of any kind (except thought) unless it is " +
                                "ordered by you. Every action which the attacker orders the " +
                                "afflicted character to perform which is in extreme violation of" +
                                " their nature gives the target a resist roll as a free action to" +
                                " end the effect. The attacker does not gain special access to the" +
                                " target's mind and so can only order the character to perform " +
                                "actions that they think the character is capable of. Lastly, each" +
                                " mental order that the attacker gives to the target is a major " +
                                "action. However, the order can be a series of verbal commands," +
                                " such “Attack enemy X unless someone comes through the door, in" +
                                " which case flee”. The dominated creature will continue to obey" +
                                " the last mental command they were given until you give a new " +
                                "command. Only one such command can be active at a given time." +
                                " Greater Domination has a duration of Resist ends" +
                                " (Fail x 3 = 1 hour).\n" +
                                "\n" +
                                "Power Level 3 - You can target creatures of subhuman intelligence" +
                                " (animals, some elementals, certain undead, etc.) with Lesser Domination.\n" +
                                "\n" +
                                "Power Level 5 - You can target creatures of human intelligence" +
                                " or better with Lesser Domination. You can target creatures of" +
                                " subhuman intelligence (animals, some elementals, etc.)" +
                                " with Greater Domination.\n" +
                                "\n" +
                                "Power Level 9 - You can target creatures of human intelligence" +
                                " or greater with Greater Domination.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to resist" +
                                " it, this bane prevents the target from being aware of their " +
                                "affliction and thus prevents them from actively attempting to " +
                                "break free. However, the target's true mind is suppressed but " +
                                "fights to regain control. As such, at the end of each of its" +
                                " turns, the target receives a resist roll as a free action to " +
                                "break free from the effect. When your target succeeds at a " +
                                "resist roll against this bane, they become immune to all " +
                                "subsequent attempts by you to inflict the bane for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Fatigued",
                        "Power Level: 5",
                        "Description:\n\tYou cause the target's body to wither and weaken, " +
                                "gradually losing its ability to function until the victim" +
                                " finally succumbs to death. Fatigue may be the result of a" +
                                " necromancer's curse, an assassin's poison, a radiation ray," +
                                " or similar life sapping effects.",
                        "Duration: Special",
                        "Attack Attributes: Entropy",
                        "Attack:\n\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\tThis bane has multiple tiers which are applied in " +
                                "succession. Each time this bane is inflicted, if it is already " +
                                "in effect on the target, the severity escalates by one level.\n" +
                                "\n" +
                                "\n" +
                                "Level 1 - The target has disadvantage 1 on all non-attack action" +
                                " rolls.\n" +
                                "\n" +
                                "Level 2 - The target is affected by the slowed bane, reducing " +
                                "its speed by half. This instance of the slowed bane cannot be " +
                                "resisted as normal. It persists until the fatigue is removed.\n" +
                                "\n" +
                                "Level 3 - The target has disadvantage 1 on all attack rolls.\n" +
                                "\n" +
                                "Level 4 - The target loses their attribute bonuses to their " +
                                "defense scores (Agility and Might for Guard, Fortitude and Will" +
                                " for Toughness, Will and Presence for Resolve). They retain any" +
                                " armor, extraordinary, or feat bonuses.\n" +
                                "\n" +
                                "Level 5 - The target loses consciousness and is helpless. Being" +
                                " forced into a state of rest, one level of fatigue will be removed" +
                                " automatically after 24 hours, unless circumstances prevent the" +
                                " target from resting peacefully.\n" +
                                "\n" +
                                "Level 6 - The target dies.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Unlike other banes, canceling this bane takes time and rest. Each" +
                                " 24 hour period of rest with little or no exertion removes one" +
                                " level of fatigue. If the *restoration* boon is successfully " +
                                "invoked to dispel this bane, only one level of fatigue is removed" +
                                " (in addition to that removed by natural rest). If the " +
                                "*restoration* boon's invoker has an attribute score of 7 or " +
                                "greater, all levels of fatigue are removed instead of just one." +
                                " A target may only benefit from one invocation of the *restoration*" +
                                " boon to remove fatigue within a 24 hour period.");
                dao.insert(bane);
                bane = new Bane("Fear",
                        "Power Level: 5",
                        "Description:\n\tThrough an overwhelming force of physical might or extraordinary" +
                                " power, you strike terror into the hearts of enemies, causing them" +
                                " to flee from your presence. A warrior might invoke this bane by" +
                                " hurling a boulder while a cyber hacker might achieve the same " +
                                "effect by uploading a hallucinatory virus into an opponent's neuro" +
                                " jack.",
                        "Duration: Special",
                        "Attack Attributes: Creation, Entropy, Influence, Might",
                        "Attack:\n\n" +
                                "Creation vs. Resolve\n" +
                                "Entropy vs. Resolve\n" +
                                "Influence vs. Resolve\n" +
                                "Might vs. Resolve",
                        "Effect:\n\tOn its turn, the afflicted target must use its entire" +
                                " turn to get as far away as possible from you. It cannot use its" +
                                " actions to do anything other than retreat, and it cannot" +
                                "willingly move closer to you while the bane persists.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to resist" +
                                " them, this bane prevents the target from thinking clearly. " +
                                "However, the target's logical mind fights to regain control. As " +
                                "such, at the end of each of its turns, the target receives a " +
                                "resist roll as a free action to break free from this effect. When" +
                                " your target succeeds at a resist roll against this bane, they" +
                                " become immune to all subsequent attempts by you to inflict the " +
                                "bane for the next hour.\n" +
                                "When inflicting this bane using Might, you may determine range " +
                                "using the Non-Physical Attack Range table (see Chapter 7: Combat)..");
                dao.insert(bane);
                bane = new Bane("Forced Move",
                        "Power Level: 2/ 4/ 6/ 8",
                        "Description:\n\tWith a forceful blow, magical gust of wind, or telekinetic push," +
                                " you move your target against its will. This bane is favored" +
                                " among ogres, telekinetisists, wind mages, super soldiers, and " +
                                "other characters built to reshape the battlefield to their " +
                                "advantage..",
                        "Duration: Instantaneous",
                        "Attack Attributes: Agility, Energy, Might, Movement",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Might vs. Guard\n" +
                                "Movement vs. Guard",
                        "Effect:\n\tThe target is moved a distance against their will," +
                                " as determined by the bane's power level. The ending location is" +
                                " chosen by the attacker.\n" +
                                "\n" +
                                "Power Level 2 - The target is moved 5'.\n" +
                                "\n" +
                                "Power Level 4 - The target is moved 10'.\n" +
                                "\n" +
                                "Power Level 6 - The target is moved 15'.\n" +
                                "\n" +
                                "Power Level 8 - The target is moved 20'.");
                dao.insert(bane);
                bane = new Bane("Immobile",
                        "Power Level: 1",
                        "Description:\n\tWhether through grappling, a precise nerve strike, entangling" +
                                " vines, mental compulsion, or a bone-numbing blast of cold, you" +
                                " render your foe incapable of movement. This bane is typical " +
                                "among martial artists, special ops agents, enchanters," +
                                " and wrestlers.",
                        "Duration: Resist ends (special) (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Alteration, Creation, Energy" +
                                " Entropy, Influence, Might, Movement",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Alteration vs. Guard\n" +
                                "Creation vs. Toughness\n" +
                                "Energy vs. Toughness\n" +
                                "Entropy vs. Toughness\n" +
                                "Influence vs. Resolve\n" +
                                "Might vs. Guard\n" +
                                "Movement vs. Guard",
                        "Effect:\n\tYour target cannot move from its current space. If you" +
                                " invoked the bane with a Might roll and are within 5' of the " +
                                "target, then both you and the target are immobile in your current" +
                                " space for the duration of the bane (locked in a grapple). " +
                                "While grappling in this manner, you can attempt to inflict this" +
                                " bane again upon the target. If successful, you can move your " +
                                "speed and take the target with you. If this attack fails, you can" +
                                " only move by first releasing the target and ending the bane.\n" +
                                "If you invoked the bane with any attribute other than Might, you " +
                                "can move freely while the target remains affected.\n" +
                                "You can choose to release the target as a free action, immediately" +
                                " ending the bane.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When an affected target succeeds at a resist roll to end this" +
                                " effect, they can move 15' as a free action.");
                dao.insert(bane);
                bane = new Bane("Incapacitated",
                        "Power Level: 5/ 7/ 9",
                        "Description:\n\tIncapacitation is a catch-all bane for a variety of effects," +
                                " including total paralysis, sleep, petrification, poison, being" +
                                " knocked out, fainting, or similar conditions that render a " +
                                "character completely helpless. Examples of possible causes of this" +
                                " bane include a martial artist's paralyzing strike, an enchanter's" +
                                " magical song of sleep, paralysis by poison, fainting from extreme" +
                                " heat, suffocation, and the gaze of a medusa.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Entropy, Influence",
                        "Attack:\n\n" +
                                "Agility vs. Toughness\n" +
                                "Entropy vs. Toughness\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\tThe target is immobile (can't move from their current " +
                                "space) and unconscious. They have disadvantage 5 on all perception" +
                                " rolls and are incapable of moving. As a result of being completely" +
                                " incapable of movement, an incapacitated character can be the " +
                                "victim of a finishing blow.\n" +
                                "Power Level 5 - The effect can be broken by a moderate disruption," +
                                " such as a firm shove, a kick, glass of water, loud bang, etc.\n" +
                                "Power Level 7 - The effect can only be broken if the target takes" +
                                " 1 point of damage or more.\n" +
                                "Power Level 9 - The effect cannot be disrupted by external forces." +
                                " Only the afflicted character's successful resist roll can end" +
                                " the effect.\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to resist" +
                                " it, this bane prevents the target from being aware of their " +
                                "affliction and thus prevents them from actively attempting to " +
                                "break free. However, the target's body fights to regain " +
                                "consciousness. As such, at the end of each of its turns, the" +
                                " target receives a resist roll as a free action to break free " +
                                "from the effect. When your target succeeds at a resist roll " +
                                "against this bane, they become immune to all subsequent attempts" +
                                " by you to inflict the bane for the next hour.");
                dao.insert(bane);
                bane = new Bane("Knockdown",
                        "Power Level: 1",
                        "Description:\n\tWhether via a thunderous blow from a great axe, an earth" +
                                " shattering bolt of supernatural energy, or a well aimed shove" +
                                " in a direction where the enemy's balance is weak, you knock the" +
                                " target off their feet. Knockdown is a favorite of hulking brutes," +
                                " telekinetisists, martial artists, and earth elementalists.\n" +
                                "\n",
                        "Duration: Instantaneous",
                        "Attack Attributes: Agility, Energy, Might, Movement",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Might vs. Guard\n" +
                                "Movement vs. Guard",
                        "Effect:\n\tThe target falls prone. Prone targets have disadvantage" +
                                " 1 on all attacks they make. Characters that are prone due to" +
                                " the *knockdown* bane (or any other reason) get +2 to Guard versus" +
                                " Ranged attacks and -2 Guard versus Melee attacks. Standing up" +
                                " from prone requires a move action and costs a character half" +
                                " (round down) of their speed for the round.");
                dao.insert(bane);
                bane = new Bane("Memory Alteration",
                        "Power Level: 5/ 6/ 8",
                        "Description:\n\tWarping or controlling the mind is one of the" +
                                " most dreaded powers of enchanters, causing powerful heroes to" +
                                " forget their homes, families, and quests. Memory alteration" +
                                " is often inflicted by mad scientists, necromancers, enchanters," +
                                " and chronomancers.",
                        "Duration: Instantaneous",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\tYou alter the target's memories to an extent based on" +
                                " the power level of the bane.\n" +
                                "\n" +
                                "Power Level 5 - You temporarily modify a minor aspect of the" +
                                " target's memory. The target automatically regains the lost memory" +
                                " and realizes their confusion 1 hour later.\n" +
                                "\n" +
                                "Power Level 6 - You permanently erase or alter the last 5 minutes" +
                                " of the target's memory. The target does not know what happened" +
                                " during this time outside of the memories you feed them (including" +
                                " having seen you, if they did). Multiple uses of this bane " +
                                "progressively erase consecutive 5 minute increments.\n" +
                                "\n" +
                                "Power Level 8 - Instead of the immediate past, you can erase or" +
                                " alter memories from any time.\n" +
                                "\n" +
                                "\n" +
                                "The memory alteration bane can only be inflicted via a bane attack." +
                                " Damaging attacks that trigger banes cannot trigger this bane.\n" +
                                "This bane confers no special ability to know about a target's " +
                                "memory. The invoker must be aware of the memory either from rumor," +
                                " personal knowledge, prescience, or other means.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When you target an enemy with this bane and your action roll fails" +
                                " to beat the target's Resolve defense, the target is immune to" +
                                " further invocations of this bane from you for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Memory Alteration",
                        "Power Level: 5/ 6/ 8",
                        "Description:\n\tWarping or controlling the mind is one of the" +
                                " most dreaded powers of enchanters, causing powerful heroes to" +
                                " forget their homes, families, and quests. Memory alteration" +
                                " is often inflicted by mad scientists, necromancers, enchanters," +
                                " and chronomancers.",
                        "Duration: Instantaneous",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\tYou alter the target's memories to an extent based on" +
                                " the power level of the bane.\n" +
                                "\n" +
                                "Power Level 5 - You temporarily modify a minor aspect of the" +
                                " target's memory. The target automatically regains the lost memory" +
                                " and realizes their confusion 1 hour later.\n" +
                                "\n" +
                                "Power Level 6 - You permanently erase or alter the last 5 minutes" +
                                " of the target's memory. The target does not know what happened" +
                                " during this time outside of the memories you feed them (including" +
                                " having seen you, if they did). Multiple uses of this bane " +
                                "progressively erase consecutive 5 minute increments.\n" +
                                "\n" +
                                "Power Level 8 - Instead of the immediate past, you can erase or" +
                                " alter memories from any time.\n" +
                                "\n" +
                                "\n" +
                                "The memory alteration bane can only be inflicted via a bane attack." +
                                " Damaging attacks that trigger banes cannot trigger this bane.\n" +
                                "This bane confers no special ability to know about a target's " +
                                "memory. The invoker must be aware of the memory either from rumor," +
                                " personal knowledge, prescience, or other means.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When you target an enemy with this bane and your action roll fails" +
                                " to beat the target's Resolve defense, the target is immune to" +
                                " further invocations of this bane from you for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Mind Dredge",
                        "Power Level: 2/ 4/ 6/ 8/ 9",
                        "Description:\n\tYou gaze into the mind of another creature and" +
                                " read their thoughts. The most powerful wielders of this bane can" +
                                " even pry into the distant memories of their subjects. Fortune " +
                                "tellers, psychics, and mentalists all use mind dredge to learn" +
                                " the deepest dreams and darkest secrets of others.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Prescience",
                        "Attack:\n\n" +
                                "Prescience vs. Resolve",
                        "Effect:\n\t\n" +
                                "Power Level 2 - This power may only target creatures of animal" +
                                " intelligence or lower. You gain access to the target's current thoughts.\n" +
                                "\n" +
                                "Power Level 4 - This power may target creatures of any" +
                                " intelligence. You gain access to the target's current thoughts.\n" +
                                "\n" +
                                "Power Level 6 - This power may target creatures of any" +
                                " intelligence. You gain access to the target's current thoughts" +
                                " as well as its recent memories. Initially, you may probe 1 day" +
                                " into the past. For every round that the bane persists, you gain" +
                                " access to an additional day's worth of memories.\n" +
                                "\n" +
                                "Power Level 8 - This power may target creatures of any" +
                                " intelligence. You gain access to the target's current thoughts" +
                                " as well as its distant memories. Initially, you may probe 1 year" +
                                " into the past. For every round that the bane persists, you gain" +
                                " access to an additional year's worth of memories. Alternatively," +
                                " you may choose to access the memories associated with a particular" +
                                " place, object, or event.\n" +
                                "\n" +
                                "Power Level 9 - This power may target creatures of any" +
                                " intelligence. You gain access to the target's current thoughts" +
                                " as well as all of its memories, without limitation by time. " +
                                "Alternatively, you may choose to access the memories associated" +
                                " with a particular place, object, or event.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When your target succeeds at a resist roll against this bane," +
                                " they become immune to all subsequent attempts by you to inflict" +
                                " the bane for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Nullify",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tThrough magical power, technological hacking," +
                                " or similar means, you are able to nullify your enemy's boons." +
                                " The nullify bane is often used by abjurers, engineers, bards," +
                                " and similar characters built to neutralize the powers of their" +
                                " enemy.",
                        "Duration: Instantaneous",
                        "Attack Attributes: Protection",
                        "Attack:\n\n" +
                                "Protection vs. Resolve",
                        "Effect:\n\t\n" +
                                "You cancel a single boon currently in effect if it is of this" +
                                " bane's power level or lower. The invoking power level further" +
                                " impacts the effect as follows:\n" +
                                "\n" +
                                "Power Level 1 - Cancel a boon of Power Level 1. You can cancel" +
                                " a boon that must be actively invoked. In addition, the target" +
                                " cannot benefit from or have the target boon invoked upon them" +
                                " for 1 minute.\n" +
                                "\n" +
                                "Power Level 2 - Cancel a boon of Power Level 2.\n" +
                                "\n" +
                                "Power Level 3 - Cancel a boon of Power Level 3.\n" +
                                "\n" +
                                "Power Level 4 - Cancel a boon of Power Level 4.\n" +
                                "\n" +
                                "Power Level 5 - Cancel a boon of Power Level 5.\n" +
                                "\n" +
                                "Power Level 6 - Cancel a boon of Power Level 6. You can cancel" +
                                " a boon that is permanent, passive, or inherent to the target" +
                                " (e.g. the invisibility of a Will o' Wisp). Effects that would " +
                                "prevent Nullify from being invoked in this way have no effect. " +
                                "In addition, the target cannot benefit from or have the target" +
                                " boon invoked upon them for 1 minute.\n" +
                                "\n" +
                                "Power Level 7 - Cancel a boon of Power Level 7.\n" +
                                "\n" +
                                "Power Level 8 - Cancel a boon of Power Level 8.\n" +
                                "\n" +
                                "Power Level 9 - Cancel a boon of Power Level 9.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "If the targeted boon covers a large area, you can cancel all of it" +
                                " by targeting any portion of the effect you can see, or " +
                                "multi-targeting a number of 5' cubes you believe it to be in." +
                                " If the targeted boon is affecting an area rather than a creature," +
                                " you roll against the CR of the boon instead of a Resolve defense." +
                                " The CR is 10 + 2 x the boon's invoked power level.");
                dao.insert(bane);
                bane = new Bane("Persistent Damage",
                        "Power Level: 2/ 4/ 6/ 8/ 9",
                        "Description:\n\tWhether by setting the target ablaze, covering" +
                                " them in acid, slicing an artery, or cursing them with a wasting " +
                                "disease, you inflict your foe with a lasting and recurring source" +
                                " of damage. Persistent damage is a favorite among assassins, mad" +
                                " scientists, and elementalists." +
                                " enemy.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\t\n" +
                                "At the beginning of the target's turn, before they take any " +
                                "actions, they suffer damage determined by the power level of " +
                                "the bane. This damage automatically bypasses the afflicted " +
                                "character's defenses but it can be reduced by any resistance to" +
                                " damage of a certain type (see the resistance boon). Like all " +
                                "dice rolls, these dice explode.\n" +
                                "\n" +
                                "Power Level 2 - 1d4 damage per round.\n" +
                                "\n" +
                                "Power Level 4 - 1d6 damage per round.\n" +
                                "\n" +
                                "Power Level 6 - 1d8 damage per round.\n" +
                                "\n" +
                                "Power Level 8 - 1d10 damage per round.\n" +
                                "\n" +
                                "Power Level 9 - 2d6 damage per round.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Persistent damage comes in a number of different variations: " +
                                "physical damage (bleeding from a vital strike), energy damage " +
                                "(lightning, fire, cold, acid, etc.) and entropic damage " +
                                "(necromantic energy), among others. Each variation has its own " +
                                "cure. When that cure is applied with a major action (either by" +
                                " the afflicted character or another), the target receives a resist" +
                                " roll (as a free action) with advantage 1 to end the effect. " +
                                "The GM has the final word on whether a proposed cure can help a" +
                                " given type of persistent damage, but the following examples can" +
                                " help with arbitration:\n" +
                                "\n" +
                                "Bleeding damage is cured with a successful roll using Learning," +
                                " Logic, or Creation.\n" +
                                "\n" +
                                "Lightning damage is cured by a discharge or grounding of the " +
                                "current.\n" +
                                "\n" +
                                "Cold damage is countered with warmth, heat, or fire.\n" +
                                "\n" +
                                "Acid damage is neutralized with alkalizing agents (powder, milk," +
                                " etc.).\n" +
                                "\n" +
                                "Fire damage is neutralized with water or smothering.\n" +
                                "\n" +
                                "Entropic damage is neutralized with extraordinary or magical " +
                                "healing.\n" +
                                "\n" +
                                "\n" +
                                "This bane may still be resisted in the usual way of using the " +
                                "resist banes action.");
                dao.insert(bane);
                bane = new Bane("Persistent Damage",
                        "Power Level: 2/ 4/ 6/ 8/ 9",
                        "Description:\n\tWhether by setting the target ablaze, covering" +
                                " them in acid, slicing an artery, or cursing them with a wasting " +
                                "disease, you inflict your foe with a lasting and recurring source" +
                                " of damage. Persistent damage is a favorite among assassins, mad" +
                                " scientists, and elementalists." +
                                " enemy.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\t\n" +
                                "At the beginning of the target's turn, before they take any " +
                                "actions, they suffer damage determined by the power level of " +
                                "the bane. This damage automatically bypasses the afflicted " +
                                "character's defenses but it can be reduced by any resistance to" +
                                " damage of a certain type (see the resistance boon). Like all " +
                                "dice rolls, these dice explode.\n" +
                                "\n" +
                                "Power Level 2 - 1d4 damage per round.\n" +
                                "\n" +
                                "Power Level 4 - 1d6 damage per round.\n" +
                                "\n" +
                                "Power Level 6 - 1d8 damage per round.\n" +
                                "\n" +
                                "Power Level 8 - 1d10 damage per round.\n" +
                                "\n" +
                                "Power Level 9 - 2d6 damage per round.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Persistent damage comes in a number of different variations: " +
                                "physical damage (bleeding from a vital strike), energy damage " +
                                "(lightning, fire, cold, acid, etc.) and entropic damage " +
                                "(necromantic energy), among others. Each variation has its own " +
                                "cure. When that cure is applied with a major action (either by" +
                                " the afflicted character or another), the target receives a resist" +
                                " roll (as a free action) with advantage 1 to end the effect. " +
                                "The GM has the final word on whether a proposed cure can help a" +
                                " given type of persistent damage, but the following examples can" +
                                " help with arbitration:\n" +
                                "\n" +
                                "Bleeding damage is cured with a successful roll using Learning," +
                                " Logic, or Creation.\n" +
                                "\n" +
                                "Lightning damage is cured by a discharge or grounding of the " +
                                "current.\n" +
                                "\n" +
                                "Cold damage is countered with warmth, heat, or fire.\n" +
                                "\n" +
                                "Acid damage is neutralized with alkalizing agents (powder, milk," +
                                " etc.).\n" +
                                "\n" +
                                "Fire damage is neutralized with water or smothering.\n" +
                                "\n" +
                                "Entropic damage is neutralized with extraordinary or magical " +
                                "healing.\n" +
                                "\n" +
                                "\n" +
                                "This bane may still be resisted in the usual way of using the " +
                                "resist banes action.");
                dao.insert(bane);
                bane = new Bane("Phantasm",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tYou create an illusory manifestation to " +
                                "deceive the senses. Some examples include making a meal taste " +
                                "rotten, altering the data on a screen where a user is logging in," +
                                " creating the sound of a stampede of horses, hiding allies behind" +
                                " a false wall, or creating an illusion of an intergalactic emperor" +
                                " who can converse intelligibly." +
                                " enemy.",
                        "Duration: Special",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\t\n" +
                                "You create a phantasm of your choosing. The power level at which" +
                                " you invoke the bane determines which senses you can deceive as" +
                                " well as the maximum size of your illusion, as follows:\n" +
                                "\n" +
                                "Power Level 1 - Affect Taste. Manifest a 5' x 5' x 5' area phantasm.\n" +
                                "\n" +
                                "Power Level 2 - Affect Smell, Sound, or Touch.\n" +
                                "\n" +
                                "Power Level 3 - Affect Sight.\n" +
                                "\n" +
                                "Power Level 4 - Manifest a 10' x 10' x 10' area phantasm.\n" +
                                "\n" +
                                "Power Level 5 - Manifest a 15' x 15' x 15' area phantasm.\n" +
                                "\n" +
                                "Power Level 6 - Affect All Senses.\n" +
                                "\n" +
                                "Power Level 7 - Manifest a 20' x 20' x 20' area phantasm.\n" +
                                "\n" +
                                "Power Level 8 - Manifest a 30' x 30' x 30' area phantasm.\n" +
                                "\n" +
                                "Power Level 9 - Manifest a 50' x 50' x 50' area phantasm.\n" +
                                "\n" +
                                "\n" +
                                "Until reaching power level 6, you can combine sensory illusions by" +
                                " adding the required power levels together (e.g., mimicking both" +
                                " sight and sound requires power level 5). While the phantasm " +
                                "persists, you can make logical changes to it freely. For example," +
                                " an illusory person can speak naturally as you direct it and could" +
                                " be made to fall in response to an attack. However, substantial " +
                                "changes to the illusion (such as transforming a human into a " +
                                "goblin) require a new invocation of the illusion.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Unlike other banes, this bane does not work by targeting specific" +
                                " enemies. Instead, your Influence roll for invoking it is compared" +
                                " with the Resolve defense of each character that would perceive " +
                                "the created effect if it were real. If the roll is lower than " +
                                "their Resolve, they perceive none of the phantasm's effects. If " +
                                "the roll is greater than or equal to their Resolve, they perceive" +
                                " the illusory effect you create and react as if it were real.\n" +
                                "When mimicking a very specific person, place, or thing that the " +
                                "target is very familiar with, the GM should consider increasing" +
                                " the target's Resolve defense for the purpose of that particular" +
                                " phantasm invocation.\n" +
                                "Characters convinced by the phantasm can roll Resist as normal in" +
                                " order to attempt to shake off the bane. If successful, they are" +
                                " no longer deceived by the effect. In addition, you must spend a" +
                                " minor action to sustain the bane during each of your turns. " +
                                "Failing to do so in a given round causes the bane's effects to " +
                                "cease at the end of your turn.\n" +
                                "When an affected character succeeds at a resist roll against this" +
                                " bane, they become immune to all subsequent phantasms invoked " +
                                "by you for the next hour.");
                dao.insert(bane);
                bane = new Bane("Polymorph",
                        "Power Level: 5/ 6/ 8/ 9",
                        "Description:\n\tYou alter the size, shape, and composition" +
                                " of the target by causing them to grow, shrink, or assume a" +
                                " completely new form, like that of a sheep or a newt. Polymorph" +
                                " might be accomplished by a druid's curse, a mad scientist's" +
                                " transmogrification ray, or exposure to alien radiation.",
                        "Duration: Resist ends (Fail x 3 = 1 hour)",
                        "Attack Attributes: Alteration",
                        "Attack:\n\n" +
                                "Alteration vs. Toughness",
                        "Effect:\n\t\n" +
                                "Your power level determines the extent to which you can transform" +
                                " your target, as follows. If the target is transformed into a " +
                                "different creature, it uses the Might, Agility, Fortitude, and" +
                                " Perception attribute scores of the new creature.\n" +
                                "\n" +
                                "Power Level 5 - Polymorph a creature into another creature of " +
                                "the same size. This new form can reduce the target's attribute" +
                                " scores by up to 2. If the new form would have higher attributes," +
                                " the target becomes an exceptional version of that creature. For" +
                                " example, transforming a deadly sniper with Agility 5 into a " +
                                "clumsy ogre with Agility 0, would leave the target with an Agility" +
                                " of 3 instead of the 0 typical for the new form.\n" +
                                "\n" +
                                "Power Level 6 - Polymorph a creature into another creature" +
                                " between double and half the size. The new form can reduce the " +
                                "target's attribute scores by up to 3.\n" +
                                "\n" +
                                "Power Level 8 - Polymorph a creature into another creature between" +
                                " quadruple and one-quarter its original size. Alternatively," +
                                " transform the target into an object of its original size. The" +
                                " new form can reduce the target's attribute scores by up to 5.\n" +
                                "\n" +
                                "Power Level 9 - Polymorph a creature into another creature of " +
                                "any size. Alternatively, transform the target into an object of" +
                                " its original size. The new form can reduce the target's attribute" +
                                " scores by up to 7.\n" +
                                "\n" +
                                "\n" +
                                "In order to keep track of hit points, the target should record the" +
                                " total damage they have suffered. When transforming, damage " +
                                "remains with the character even if their maximum hit points " +
                                "change. For example, Agent Walker has a max HP of 20 but is" +
                                " turned into a sheep and has her Fortitude reduced by 2, leaving" +
                                " her at 16 hit points. During combat, she suffers 10 damage." +
                                " When she later transforms back into Agent Walker, the 10 damage" +
                                " remains and is subtracted from her new maximum, leaving her with" +
                                " 10 out of 20 hit points. Additionally, if the shift would reduce" +
                                " the target's hit points to less than 1, the target's hit point " +
                                "total becomes 1 instead.");
                dao.insert(bane);
                bane = new Bane("Provoked",
                        "Power Level: 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tThrough a display of awe-inspiring force, intimidation, or " +
                                "leadership, you command attention as the greatest threat, causing" +
                                " others to fear attacking your allies. Examples include a brute" +
                                " smashing the skull of a lesser foe, a gunslinger hurling insults," +
                                " or a space captain diving into the middle of a swirling melee" +
                                " with plasma blades flashing.",
                        "Duration: Resist (minor) ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Creation, Deception, Energy," +
                                " Influence, Might, Persuasion, Presence",
                        "Attack:\n\n" +
                                "Agility vs. Resolve\n" +
                                "Creation vs. Resolve\n" +
                                "Deception vs. Resolve\n" +
                                "Energy vs. Resolve\n" +
                                "Influence vs. Resolve\n" +
                                "Might vs. Resolve\n" +
                                "Persuasion vs. Resolve\n" +
                                "Presence vs. Resolve",
                        "Effect:\n\t\n" +
                                "Any attacks made by the target that do not include you as a target" +
                                " suffer disadvantage. If the same target is affected by this bane" +
                                " from multiple sources, as long as their attack includes one of" +
                                " those who targeted them, they are not affected by the penalty." +
                                " Unlike other banes, your damaging attack against one target can" +
                                " trigger this bane in a different target, provided your roll is" +
                                " greater than or equal to their Resolve defense (that is, by " +
                                "striking one foe, you can provoke another).\n" +
                                "\n" +
                                "Power Level 4 - The target suffers disadvantage 1 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "Power Level 5 - The target suffers disadvantage 2 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "Power Level 6 - The target suffers disadvantage 3 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "Power Level 7 - The target suffers disadvantage 4 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "Power Level 8 - The target suffers disadvantage 5 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "Power Level 9 - The target suffers disadvantage 6 on attacks that" +
                                " do not include you.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Resisting this bane is a minor action.\n" +
                                "When inflicting this bane using Agility or Might, you may" +
                                " determine range using the Non-Physical Attack Range table" +
                                " (see Chapter 7: Combat).");
                dao.insert(bane);
                bane = new Bane("Spying",
                        "Power Level: 5/ 6/ 7/ 9",
                        "Description:\n\tEither through innate extrasensory perception or a special" +
                                " conduit such as a computer terminal, bubbling cauldron, or a " +
                                "crystal ball, you can view the target from a distance.",
                        "Duration: 10 minutes (special)",
                        "Attack Attributes: Prescience",
                        "Attack:\n\n" +
                                "Prescience vs. Resolve (special)",
                        "Effect:\n\t\n" +
                                "You can spy on a person or area that you are familiar with." +
                                " The power level of this bane determines the maximum distance" +
                                " between you and the target. If successfully invoked, you can" +
                                " see and hear everything that goes on within a 60' radius of" +
                                " your target. Anyone within the targeted area who has a Resolve" +
                                " defense score higher than your Prescience action roll to invoke" +
                                " this bane becomes aware of an unseen presence in the area" +
                                " (regardless of whether or not you succeed at the roll)." +
                                " Certain creatures may be able to identify your spying if " +
                                "they are familiar with such powers.\n" +
                                "\n" +
                                "Power Level 5 - 1 mile or less\n" +
                                "\n" +
                                "Power Level 6 - 100 miles or less\n" +
                                "\n" +
                                "Power Level 7 - More than 100 miles, but on the same dimension" +
                                " or plane of reality\n" +
                                "\n" +
                                "Power Level 9 - Any dimension or plane of reality." +
                                " (Peering into certain dimensions may expose you to other" +
                                " dangers at the GM's discretion).\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When you successfully invoke this bane, at the end of its" +
                                " duration, you can make a Prescience roll to attempt to" +
                                " persist the bane. If successful, the bane persists without" +
                                " requiring the invocation time to be repeated. However," +
                                " you must retest your new roll against the Resolve scores" +
                                " of those in the targeted area to determine whether or not" +
                                " they can sense your presence.\n" +
                                "You can attempt to spy the same target any number of times," +
                                " but if your action roll fails, that target becomes immune" +
                                " to your spying for 24 hours.");
                dao.insert(bane);
                bane = new Bane("Sickened",
                        "Power Level: 5",
                        "Description:\n\tEntropic energy overcomes the target, bombarding their system" +
                                " and inducing nausea that makes self-defense and any kind of" +
                                " action difficult. This bane might stem from a witch's curse," +
                                " chemical warfare, a powerful poison, or exposure to alien toxins.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Entropy",
                        "Attack:\n\n" +
                                "Entropy vs. Toughness",
                        "Effect:\n\t\n" +
                                "The target has disadvantage 1 on all action rolls and -1" +
                                " to all defenses.");
                dao.insert(bane);
                bane = new Bane("Silenced",
                        "Power Level: 2",
                        "Description:\n\tSilence overcomes the target, whether from" +
                                " the warping of sound" +
                                " around the target, or from a physical effect like strangulation" +
                                " or suffocation. The silence bane is a favorite among assassins," +
                                " sorcerers, engineers, and mad scientists.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Alteration, Entropy, Might",
                        "Attack:\n\n" +
                                "Agility vs. Toughness\n" +
                                "Alteration vs. Toughness\n" +
                                "Entropy vs. Toughness\n" +
                                "Might vs. Toughness",
                        "Effect:\n\t\n" +
                                "If Might, Agility, or Entropy is used to inflict this bane, then" +
                                " the character is suffering strangulation and unable to speak." +
                                " If the bane is inflicted using Alteration, then all sound " +
                                "within 5' of the target is suppressed through extraordinary means," +
                                " making their footsteps and the usual clank of belongings they" +
                                " are carrying inaudible.");
                dao.insert(bane);
                bane = new Bane("Slowed",
                        "Power Level: 1",
                        "Description:\n\tThe target's movement is impaired, either" +
                                " by extreme cold, prolonged heat, poison, or injury to one or" +
                                " both legs. This bane is a favored attack among rogues, ice" +
                                " mages, telekinetisists, and gunslingers.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy, Might, Movement",
                        "Attack:\n\n" +
                                "Agility vs. Guard\n" +
                                "Energy vs. Guard\n" +
                                "Entropy vs. Toughness\n" +
                                "Might vs. Guard\n" +
                                "Movement vs. Guard",
                        "Effect:\n\t\n" +
                                "The afflicted target's speed is reduced to half its current " +
                                "speed, rounded down to the nearest 5' increment. This applies" +
                                " to all movement that is physical (flight, walking, climbing, " +
                                "etc.). If the target is currently under a magical effect that" +
                                " increases speed, the two effects are canceled for the duration" +
                                " that both affect the target.");
                dao.insert(bane);
                bane = new Bane("Stunned",
                        "Power Level: 4",
                        "Description:\n\tYou disorient the target's senses, causing " +
                                "them to act much less efficiently. Stunning an enemy can be caused" +
                                " by attacks such as a pistol whip to the back of the head, a kick" +
                                " in the groin, and a deafening thunderclap.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Agility, Energy, Entropy, Might",
                        "Attack:\n\n" +
                                "Agility vs. Toughness\n" +
                                "Energy vs. Toughness\n" +
                                "Entropy vs. Toughness\n" +
                                "Might vs. Toughness",
                        "Effect:\n\t\n" +
                                "During the target's turn, they are limited to either a single" +
                                " major action, a single move action, or a single minor action." +
                                " Effects that grant additional actions do not circumvent this " +
                                "unless they grant a free action. Note that a target expending its" +
                                " move action to resist this bane will receive the remainder of " +
                                "their usual actions if the resist roll succeeds.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "This bane has special rules for boss NPCs (See Chapter 8: Running" +
                                " the Game). A boss is only affected by the stunned bane during " +
                                "its normal initiative turn. It may still take all of its boss " +
                                "actions as usual.");
                dao.insert(bane);
                bane = new Bane("Stupefied",
                        "Power Level: 7",
                        "Description:\n\tThe stupefied bane has examples in many stories" +
                                " and legends: a vampire's eyes, a siren's song, and a nymph's" +
                                " beauty are all known to cast a stupor upon weak-willed mortals." +
                                " Being stupefied causes the target to be lulled into a false " +
                                "sense of security, tranquility, and pacifism.",
                        "Duration: Resist ends (Fail x 3 = 1 minute)",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\t\n" +
                                "The target is in a state of mental fog, lowering their mental" +
                                " defenses. While stupefied, the target's Resolve defense is " +
                                "reduced to 10. In addition, the target has the approximate " +
                                "intelligence of a child. If attacked, it will defend itself " +
                                "until the attack ceases using its natural weapons, but the " +
                                "target will never employ any kind of complex tactic or ability," +
                                " such as spellcasting. If the target sees fire, it will run away." +
                                " If it feels pain, it will flee.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "While most banes last until the target actively attempts to resist" +
                                " it, this bane prevents the target from actively attempting to" +
                                " break free. However, the target's true mind is suppressed but" +
                                " fights to regain control. As such, at the end of each of its " +
                                "turns, the target receives a resist roll as a free action to " +
                                "break free from the effect. Any attack that causes the target " +
                                "mental or physical pain gives the target an additional resist " +
                                "roll to break free from the bane. Also any action that would " +
                                "startle a wild animal (being hit with a rock, slapped on the " +
                                "face, etc.) will also trigger a free resist roll for the target." +
                                " Unlike other resist rolls, those triggered by damage, fear, " +
                                "and trauma do not count against the target's typically allowed " +
                                "failures of 3, beyond which the duration of the bane would extend." +
                                " When your target succeeds at a resist roll against this bane, " +
                                "they become immune to all subsequent attempts by you to inflict " +
                                "the bane for the next 24 hours.");
                dao.insert(bane);
                bane = new Bane("Truthfulness",
                        "Power Level: 5",
                        "Description:\n\tBy controlling the target's mind through " +
                                "compulsion magic, chemical injection, neural probes, or " +
                                "similar means, you render them incapable of lying deliberately." +
                                " This is a favored bane among enchanters, mad scientists, " +
                                "psychics, and thought police.",
                        "Duration: 10 minutes (special)",
                        "Attack Attributes: Influence",
                        "Attack:\n\n" +
                                "Influence vs. Resolve",
                        "Effect:\n\t\n" +
                                "The target answers any question asked with honesty, to the best" +
                                " of their knowledge. When compelled to reveal something they " +
                                "would not reveal outside of duress, the target makes a Will " +
                                "roll and you make an Influence roll. If the target's roll is " +
                                "higher than yours, then they resist the bane and the effect ends.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "When you successfully invoke this bane, at the end of its " +
                                "duration, you can make another Influence roll to attempt to " +
                                "persist the bane. If successful, the bane persists without " +
                                "requiring the invocation time to be repeated.\n" +
                                "When a target wins the contested Will vs. Influence roll, " +
                                "you cannot target them with this bane again for 24 hours.");
                dao.insert(bane);
            });
        }
    };
}
