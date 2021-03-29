package ca.unb.mobiledev.openlegendrpg.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ca.unb.mobiledev.openlegendrpg.Items.Boon;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ca.unb.mobiledev.openlegendrpg.dao.boonDao;


/**
 * Database layer in top of the SQLite database
 */
@Database(entities = {Boon.class}, version = 1, exportSchema = false)
public abstract class BoonRoomDatabase extends RoomDatabase {

    public abstract boonDao boonDao();
    private static volatile BoonRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 15;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BoonRoomDatabase getDatabase(final Context context) {
        if (null == INSTANCE) {
            synchronized (BoonRoomDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BoonRoomDatabase.class, "boon_database")
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
                boonDao dao = INSTANCE.boonDao();
                dao.deleteAll();

                Boon boon = new Boon("Absorb Object",
                        "Power Level: 4",
                        "Description:\n\tBy restructuring your bodily composition, creating an " +
                                "extradimensional space, utilizing a cybernetic storage implant," +
                                " or similar means, you absorb an object into your body, leaving it" +
                                " completely hidden from others and ready for access at a moment's " +
                                "notice.",
                        "Invocation time: 1 Major Action",
                        "Duration: permanent",
                        "Attributes: alteration, movement",
                        "Effect:\n\tthe object remains in place, completely hidden from the" +
                                " perception of others, until the target summons or recalls it" +
                                " (automatically) as a minor action. If anything happens to cancel" +
                                " this boon (such as the nullify bane), the object is immediately" +
                                " shunted out of the target's body as if the object had been " +
                                "withdrawn.");
                dao.insert(boon);
                boon = new Boon("Animation",
                        "Power Level: 4",
                        "Description:\n\tYou create a being of subhuman intelligence that persists " +
                                "indefinitely and autonomously. It might be a living creature, an " +
                                "undead fiend, a sentient construct, or any similar creation " +
                                "possessing lifelike properties. Examples of this boon in play " +
                                "include a necromancer creating an undead bodyguard, a mad scientist" +
                                " forging a subhuman being from body parts collected from a variety " +
                                "of corpses, and an engineer creating a cyborg from parts collected " +
                                "at a scrap yard.",
                        "Invocation Time: 8 Hours",
                        "Duration: Permanent",
                        "Attributes: Creation, Entropy, Logic",
                        "Effect:\n\tYou are able to create an autonomous being from inanimate" +
                                " material components, such as dirt, bones, water, vines, scrap " +
                                "metal, or sand (the materials used are subject to the GM's " +
                                "discretion). To do so, you must first spend 8 hours completing a " +
                                "ritual, experiment, or similar manufacturing process. After this " +
                                "process is complete, make an action roll to invoke this boon. If " +
                                "successful, the inanimate form is permanently imbued with " +
                                "sentience.\n" +
                                "Your ability to animate a creature does not grant you the permanent" +
                                " ability to control it. However, newly animated beings are affected" +
                                " by the charmed bane (see below), and thus treat you more favorably" +
                                " immediately following their creation.\n" +
                                "The GM, not the player, is responsible for deciding the attributes " +
                                "and abilities of this animated creature and should follow the " +
                                "guidelines established by the \"Simple Build\" section for creating" +
                                " NPCs in Chapter 8: Running the Game. Creatures created using this " +
                                "boon are typically limited to those of subhuman intelligence, such " +
                                "as zombies, combat droids, and golems.\n" +
                                "\n" +
                                "Power Level 6 - You can animate a single creature. Your invoking " +
                                "attribute score must be equal to or greater than the highest " +
                                "attribute score of the creature you're animating. With a successful" +
                                " invocation, the creature comes into existence with the charmed " +
                                "(Minor Charm) bane already in effect (no roll is required).\n" +
                                "\n" +
                                "Power Level 8 - You may choose to animate a group of creatures: " +
                                "Either 10 creatures with a max attribute of 2, 5 creatures with a " +
                                "max attribute of 3, or 2 creatures with a max attribute of 5. In " +
                                "addition, the automatically invoked charmed bane is a Major Charm " +
                                "instead of Minor Charm.");
                dao.insert(boon);
                boon = new Boon("Aura",
                        "Power Level: 4/ 6/ 8",
                        "Description:\n\tYou surround a willing target in an aura that hurts their foes " +
                                "or helps their allies. A shield of gamma radiation that burns " +
                                "attackers, a circle of healing, and an aura of elemental protection" +
                                " are all examples of this boon in action.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Creation, Energy, Entropy, Influence," +
                                " Movement, Presence, Prescience, Protection",
                        "Effect:\n\tAn aura extends from a willing target to a distance " +
                                "determined by the power level of this boon:\n" +
                                "\n" +
                                "Power Level 4 - 5' radius\n" +
                                "\n" +
                                "Power Level 6 - 10' radius\n" +
                                "\n" +
                                "Power Level 8 - 15' radius\n" +
                                "\n" +
                                "\n" +
                                "Choose a single bane or boon which uses the same attribute that " +
                                "you used to invoke Aura. The maximum power level for the chosen " +
                                "bane or boon is one-half the power level of your aura. Your aura " +
                                "radiates the chosen bane or boon as follows:\n" +
                                "\n" +
                                "If the aura radiates a bane, then the target of the aura is not " +
                                "affected by it. All other creatures (friend or foe) who willingly " +
                                "enter the area of the aura or end their turn within it suffer a " +
                                "bane attack to inflict the chosen bane. No creature may be subject" +
                                " to a bane attack from the same creature's aura more than once per " +
                                "round.\n" +
                                "\n" +
                                "If the aura radiates a boon, then the target of the aura is also " +
                                "affected by it. The target and all allies who end their turn within" +
                                " the area of the aura automatically gain the chosen boon. Upon " +
                                "leaving the area of the aura, the boon is immediately removed. No " +
                                "creature may gain a boon from the same creature's aura more than " +
                                "once per round.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "This boon may require special attention and adjudication from the " +
                                "GM, as not all banes and boons may be an appropriate fit for an " +
                                "aura. Telekinesis, for example, is not a boon that can be granted " +
                                "to allies and thus does not work well as an aura.");
                dao.insert(boon);
                boon = new Boon("Aura",
                        "Power Level: 4/ 6/ 8",
                        "Description:\n\tYou surround a willing target in an aura that hurts their foes " +
                                "or helps their allies. A shield of gamma radiation that burns " +
                                "attackers, a circle of healing, and an aura of elemental protection" +
                                " are all examples of this boon in action.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Creation, Energy, Entropy, Influence," +
                                " Movement, Presence, Prescience, Protection",
                        "Effect:\n\tAn aura extends from a willing target to a distance " +
                                "determined by the power level of this boon:\n" +
                                "\n" +
                                "Power Level 4 - 5' radius\n" +
                                "\n" +
                                "Power Level 6 - 10' radius\n" +
                                "\n" +
                                "Power Level 8 - 15' radius\n" +
                                "\n" +
                                "\n" +
                                "Choose a single bane or boon which uses the same attribute that " +
                                "you used to invoke Aura. The maximum power level for the chosen " +
                                "bane or boon is one-half the power level of your aura. Your aura " +
                                "radiates the chosen bane or boon as follows:\n" +
                                "\n" +
                                "If the aura radiates a bane, then the target of the aura is not " +
                                "affected by it. All other creatures (friend or foe) who willingly " +
                                "enter the area of the aura or end their turn within it suffer a " +
                                "bane attack to inflict the chosen bane. No creature may be subject" +
                                " to a bane attack from the same creature's aura more than once per " +
                                "round.\n" +
                                "\n" +
                                "If the aura radiates a boon, then the target of the aura is also " +
                                "affected by it. The target and all allies who end their turn within" +
                                " the area of the aura automatically gain the chosen boon. Upon " +
                                "leaving the area of the aura, the boon is immediately removed. No " +
                                "creature may gain a boon from the same creature's aura more than " +
                                "once per round.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "This boon may require special attention and adjudication from the " +
                                "GM, as not all banes and boons may be an appropriate fit for an " +
                                "aura. Telekinesis, for example, is not a boon that can be granted " +
                                "to allies and thus does not work well as an aura.");
                dao.insert(boon);
                boon = new Boon("Barrier",
                        "Power Level: 3/ 5/ 7/ 9",
                        "Description:\n\tYou summon forth a wall of thorns, ring of fire, swarm of " +
                                "robotic pests, cloud of entropic fog, or similar barrier to hurt " +
                                "or hinder your foes.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Creation, Energy, Entropy, Protection",
                        "Effect:\n\tWhen you invoke this boon, you must use multi-targeting to create a " +
                                "specific area of effect to define the space of your barrier. Upon " +
                                "successful invocation, choose a number of available properties for " +
                                "your wall based on your power level:\n" +
                                "\n" +
                                "Power Level 3 - Choose 1 property: Damaging (1d4), Obscuring, " +
                                "Hindering\n\n" +
                                "Power Level 5 - Choose 2 properties: Damaging (1d8), Obscuring, " +
                                "Hindering, Baneful, Mobile\n\n" +
                                "Power Level 7 - Choose 3 properties: Damaging (1d10), Obscuring, " +
                                "Hindering, Baneful, Mobile, Impassable\n\n" +
                                "Power Level 9 - Choose 4 properties: Damaging (2d6), Obscuring, " +
                                "Hindering, Baneful, Mobile, Impassable\n" +
                                "\n" +
                                "\n" +
                                "Damaging: A creature who ends its turn within the barrier or " +
                                "willingly enters it, automatically suffers the indicated damage. " +
                                "A creature may only suffer this damage once per round.\n" +
                                "\n" +
                                "\n" +
                                "Obscuring: Creatures cannot see through any part of the barrier or " +
                                "anything within it.\n" +
                                "\n" +
                                "\n" +
                                "Hindering: Creatures move at half speed when travelling within the " +
                                "barrier.\n" +
                                "\n" +
                                "\n" +
                                "Impassable: Creatures and objects cannot move through the barrier. " +
                                "If you place an impassable barrier in a space occupied by a" +
                                " creature, move that creature to the closest position of their " +
                                "choice that is not inside of the barrier. This movement does not " +
                                "provoke opportunity attacks.\n" +
                                "\n" +
                                "\n" +
                                "Baneful: Choose a bane which you can inflict that has a power " +
                                "level less than or equal to the power level of your barrier. When " +
                                "a creature ends its turn within the barrier or willingly enters it," +
                                " you may immediately make a bane attack against it to inflict the " +
                                "chosen bane. A creature can only be subject to one such bane attack" +
                                " from this barrier per round.\n" +
                                "\n" +
                                "\n" +
                                "Mobile: You may spend a major action to move the barrier up to 30 " +
                                "feet.");
                dao.insert(boon);
                boon = new Boon("Blindsight",
                        "Power Level: 5",
                        "Description:\n\tEven in the absence of light you are able to distinguish your " +
                                "surroundings. Some examples of blindsight include tremorsense," +
                                " echolocation, heat vision, divine insight, or extraordinarily " +
                                "heightened senses.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Entropy, Perception, Prescience",
                        "Effect:\n\tThe target is immune to the blinded bane and they are able to see " +
                                "normally even in conditions of little or no light. Blindsight can " +
                                "also potentially counter invisiblity, though the GM will have to " +
                                "decide if the source creating the blindsight is appropriate to " +
                                "counter the source creating the invisible boon.");
                dao.insert(boon);
                boon = new Boon("Bolster",
                        "Power Level: 3/ 6/ 8",
                        "Description:\n\tYou bolster your target's chances of success via inspiration, " +
                                "augmentation, divine blessing, or supernatural insight. Your target" +
                                " becomes more competent than they normally are. You might grant the" +
                                " sight of an eagle, the problem solving skills of an elite computer" +
                                " hacker, or the social grace of a trained courtier.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Creation, Prescience, Presence",
                        "Effect:\n\tChoose a single attribute. The target gains advantage on their" +
                                " action rolls with that attribute according to the power level of " +
                                "the boon.\n" +
                                "\n" +
                                "Power Level 3 - Advantage 1.\n" +
                                "\n" +
                                "Power Level 6 - Advantage 2.\n" +
                                "\n" +
                                "Power Level 8 - Advantage 3.");
                dao.insert(boon);
                boon = new Boon("Darkness",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tYou create an area of illusory darkness or entropic energy that " +
                                "snuffs out all light. This boon is a favorite among illusionists, " +
                                "shadow casters, psions, and mad scientists..",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Entropy, Influence",
                        "Effect:\n\tChoose a space or object within range. Darkness emanates from the " +
                                "target to a radius equal to five feet per power level of the boon." +
                                " The effect cancels the effect of all natural light within its " +
                                "radius of effect and creatures that depend on light for vision " +
                                "suffer as though they have the blinded bane while in the area of " +
                                "effect. Creatures that do not depend on light for their vision " +
                                "(if they have tremorsense, blindsight, etc.) are unaffected. If " +
                                "the darkness area overlaps an area affected by the light boon, " +
                                "then the one of greater power level supersedes the other. If the" +
                                " power level of both is equal, then they cancel each other out.");
                dao.insert(boon);
                boon = new Boon("Detection",
                        "Power Level: 1",
                        "Description:\n\tYou gain extraordinary vision that allows you to see colored " +
                                "auras which correlate to magical, spiritual, or other extraordinary" +
                                " forces. Common examples of this boon include a paladin detecting " +
                                "a suspect's true intentions, a psychic reading the aura of a " +
                                "location, and a cyborg scanning the terrain for signs of life.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Prescience",
                        "Effect:\n\tWhen calling on this boon, you must choose the type of aura you are " +
                                "detecting: holy, unholy, life, death, or magic. You can perceive " +
                                "invisible auras pertaining to the chosen type of force and have an " +
                                "approximate sense of their strength (from weak to overwhelming). " +
                                "These auras are usually based on an action that is deliberate, so " +
                                "an otherwise kind shopkeeper would radiate an aura of death for a " +
                                "time after poisoning or killing someone. Even a paladin slaying an " +
                                "evil archmage will give off a radius of death for a time after the " +
                                "killing blow.\n" +
                                "\n" +
                                "Holy - Holy energy surrounds extraplanar beings from the heavens " +
                                "or similar good-aligned dimensions where pure goodness is embodied.\n" +
                                "\n" +
                                "Unholy - Unholy energy surrounds extraplanar beings from the hells " +
                                "or similar evil-aligned dimensions where pure evil is embodied.\n" +
                                "\n" +
                                "Life - Beings from heavenly dimensions, far-future regenerative " +
                                "nanotech, and clerics wielding the power of healing or protection " +
                                "radiate an aura of life for a time after wielding such capabilities.\n" +
                                "\n" +
                                "Death - Necromancers, undead, and murderers all radiate an aura of " +
                                "death. For undead, the aura is constant, since the power of death " +
                                "and magic is what animates them.\n" +
                                "\n" +
                                "Magic - Extraordinary auras surround objects or places imbued with " +
                                "such effects. Extraordinary creatures who are innately magical, " +
                                "such as a nymph, constantly radiate magic. Natural creatures who " +
                                "wield magic, such as a human wizard, give off an aura only " +
                                "following use of their power.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Unlike other boons, this boon cannot target another character. " +
                                "Only the character invoking the boon can see the auras. " +
                                "Additionally, the GM may allow other types of suitable auras " +
                                "to be detected as appropriate to the campaign setting.");
                dao.insert(boon);
                boon = new Boon("Flight",
                        "Power Level: 5/ 6/ 8",
                        "Description:\n\tBy sprouting wings, activating an anti-gravity device, focusing" +
                                " telekinetic power, or similar means, the target takes to the skies.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Movement",
                        "Effect:\n\t\n" +
                                "Power Level 5 - The target gains a flight speed of 10'.\n" +
                                "\n" +
                                "Power Level 6 - The target gains a flight speed of 30'.\n" +
                                "\n" +
                                "Power Level 8 - The target gains a flight speed of 60'.\n" +
                                "\n" +
                                "\n" +
                                "If the boon is dispelled while the target is still in flight, they " +
                                "plummet to the ground immediately.");
                dao.insert(boon);
                boon = new Boon("Genesis",
                        "Power Level: 1/ 3/ 5/ 7/ 9",
                        "Description:\n\tYou create something from nothing. Depending on the power of " +
                                "your invocation, you are able to manifest a wide array of materials" +
                                ", from temporary vegetable matter to permanent crafted goods of " +
                                "remarkable complexity. This boon is commonly invoked by druids to " +
                                "create food or grow plants, and by engineers to jury rig equipment" +
                                " or invent ingenious solutions to complex problems.",
                        "Invocation Time: Special",
                        "Duration: Instantaneous",
                        "Attributes: Creation",
                        "Effect:\n\t\n" +
                                "Power Level 1 - You can create temporary non-sentient matter " +
                                "(plants, dirt, water, vines, etc.), anything created in this way " +
                                "deteriorates or decomposes to become useless after 1 hour. Using " +
                                "this boon you can create 1 cubic foot of nonliving matter per " +
                                "attribute point of the invoking attribute. The invocation time for " +
                                "this application is 10 minutes.\n" +
                                "\n" +
                                "Power Level 3 - You can create permanent non-sentient matter " +
                                "(plants, dirt, water, vines, etc.). Using this boon you can either " +
                                "create enough food for 1 person or 1 cubic foot of nonliving matter" +
                                " per attribute point of the invoking attribute. The invocation time" +
                                " for this application is 1 hour.\n" +
                                "\n" +
                                "Power Level 5 - The quantity of permanent non-sentient matter" +
                                " (plants, dirt, water, vines, etc.). you can create expands, " +
                                "you can now produce 5 cubic feet per attribute point of the " +
                                "invoking attribute.\n" +
                                "\n" +
                                "Power Level 7 - You can create permanent mundane and organically " +
                                "complex or dense non-sentient matter, such as gems, iron, or " +
                                "marble. The resulting object's value can't be greater than a " +
                                "Wealth Level 2 item. You produce 1 cubic foot of such matter per " +
                                "attribute point of the invoking attribute. The invocation time for" +
                                " this application is 8 hours.\n" +
                                "\n" +
                                "Power Level 9 - You can create not just raw materials, but " +
                                "permanent crafted items - though a craftsman is still required" +
                                " to work anything into an exceptional quality. The invocation " +
                                "time for this application is 8 hours.");
                dao.insert(boon);
                boon = new Boon("Haste",
                        "Power Level: 2/ 4/ 6/ 8",
                        "Description:\n\tThe target moves with extraordinary speed, dodging attacks more" +
                                " deftly and accomplishing actions at an uncanny rate. This may be " +
                                "the result of a chemical injection, psychic enhancement, " +
                                "time-altering magic, or similar means.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Movement",
                        "Effect:\n\t\n" +
                                "Power Level 2 - The target's speed is increased by 10'.\n" +
                                "\n" +
                                "Power Level 4 - The target's speed is increased by 15', and it " +
                                "gains +1 to Guard.\n" +
                                "\n" +
                                "Power Level 6 - The target's speed is increased by 20', and it " +
                                "gains +2 to Guard. Additionally, the target can make one extra " +
                                "major action on each of its turns. This action cannot be used to " +
                                "perform an interrupt action. If the action requires a roll, it " +
                                "suffers disadvantage 3.\n" +
                                "\n" +
                                "Power Level 8 - The target's speed is increased by 30', and it" +
                                " gains +3 to Guard. Additionally, the target can make up to two " +
                                "extra major actions on each of its turns. These actions cannot be " +
                                "used to perform an interrupt action. If the target takes 1 extra " +
                                "action that action has disadvantage 3, if they take a 2nd extra " +
                                "action, that action has disadvantage 6..");
                dao.insert(boon);
                boon = new Boon("Heal",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tHealing can be one of two things: the actual mending of wounds " +
                                "and broken bones through sources like medicine, surgery, or " +
                                "supernatural creative life force, or the inspiration of your " +
                                "target to carry on fighting, even in the face of death. This boon " +
                                "is common among clerics, medics, bards, and combat leaders.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Instantaneous",
                        "Attributes: Creation, Learning, Logic, Presence",
                        "Effect:\n\tRoll dice according to the boon power level below. These dice " +
                                "explode as normal. The target is healed a number of hit points " +
                                "equal to the total roll.\n" +
                                "\n" +
                                "Power Level 1 - Heal 1d4.\n" +
                                "\n" +
                                "Power Level 2 - Heal 1d6.\n" +
                                "\n" +
                                "Power Level 3 - Heal 1d8.\n" +
                                "\n" +
                                "Power Level 4 - Heal 1d10.\n" +
                                "\n" +
                                "Power Level 5 - Heal 2d6.\n" +
                                "\n" +
                                "Power Level 6 - Heal 2d8.\n" +
                                "\n" +
                                "Power Level 7 - Heal 2d10.\n" +
                                "\n" +
                                "Power Level 8 - Heal 3d8.\n" +
                                "\n" +
                                "Power Level 9 - Heal 3d10.");
                dao.insert(boon);
                boon = new Boon("Invisible",
                        "Power Level: 5/ 6",
                        "Description:\n\tThe target vanishes from the visible spectrum, either by bending" +
                                " light, creating an illusion, or stepping into an extradimensional" +
                                " space between the fabric of the planes. This boon is a favorite of" +
                                " special ops agents, illusionists, shadow dancers, inventors, and " +
                                "similar characters.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Influence",
                        "Effect:\n\tLight passes through the target, making them translucent, however " +
                                "their physical form distorts and refracts light in a way that only" +
                                " the keenest sight can perceive. The target gains advantage " +
                                "according to the boon's Power Level on Agility rolls to hide. " +
                                "If completely still, this bonus is doubled. The target's Guard " +
                                "defense is increased against melee and ranged attacks, though it " +
                                "is unchanged against area attacks. When making an attack against " +
                                "target's that can't see you, their Guard defense is reduced. You " +
                                "cannot be the target of opportunity attacks unless the enemy can " +
                                "see you through non-visual means.\n" +
                                "\n" +
                                "Power Level 5 - Advantage 3 to hide, +3 to Guard against ranged " +
                                "and melee attacks, and -2 to Guard for targets that can't see you.\n" +
                                "\n" +
                                "Power Level 6 - Advantage 5 to hide, +5 to Guard against ranged " +
                                "and melee attacks, and -4 to Guard for targets that can't see you.");
                dao.insert(boon);
                boon = new Boon("Life Drain",
                        "Power Level: 5",
                        "Description:\n\tLike the bite of a vampire, the soul draining touch of a black " +
                                "mage, or the life sucking ray gun of a mad supervillain, this " +
                                "boon allows the target to steal the very lifeforce of their foes.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Entropy",
                        "Effect:\n\tWhile this boon persists, the target heals half (round up) of the " +
                                "damage they inflict with each attack. If an attack damages multiple" +
                                " foes, the target of this boon heals based on the total damage " +
                                "inflicted against all foes.");
                dao.insert(boon);
                boon = new Boon("Light",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tWhether through magical summoning, energy manipulation, or some " +
                                "other means, you illuminate an area with a bright light. An android" +
                                " activating its head lamp, a fire mage creating a dancing torch " +
                                "flame, and an alchemist cracking a glow globe are all examples of " +
                                "this boon in play.",
                        "Invocation Time: 1 Minor Action",
                        "Duration: Sustain Persists",
                        "Attributes: Creation, Energy",
                        "Effect:\n\tChoose a space or object within range. Extraordinary light emanates" +
                                " from the target to a radius equal five feet per power level of the" +
                                " boon. If the light area overlaps an area affected by the darkness " +
                                "boon, then the one of greater power level supersedes the other. If " +
                                "the power level of both is equal, then they cancel each other out.");
                dao.insert(boon);
                boon = new Boon("Precognition",
                        "Power Level: 1/ 3/ 5/ 7",
                        "Description:\n\tYou peer into the future to gain insight into a course of action" +
                                ", an event, a person, or a place. Examples of this boon include a " +
                                "fortune teller throwing the bones, a superhuman detective analyzing" +
                                " evidence, a priest consulting a higher power for direction, and an" +
                                " advanced artificial intelligence calculating every possible " +
                                "outcome of a complex assortment of variables.",
                        "Invocation Time: 1 Minute",
                        "Duration: 1 round",
                        "Attributes: Prescience",
                        "Effect:\n\t\n" +
                                "Power Level 1 - The target asks a question about a course of " +
                                "action they plan to take within the next five minutes. The GM " +
                                "communicates the insight through vague symbols, impressions, or a " +
                                "single word such as “favorable” or “unfavorable”.\n" +
                                "\n" +
                                "Power Level 3 - The target asks a question about a course of action" +
                                " they plan to take within the next hour. The GM communicates the " +
                                "insight through vague symbols, impressions, or a single word such " +
                                "as “favorable” or “unfavorable”.\n" +
                                "\n" +
                                "Power Level 5 - The target asks a single question about a " +
                                "particular event, decision, person, place, etc. The GM provides " +
                                "a meaningful (not vague, but still brief) explanation in one or " +
                                "two sentences that is a direct response to the knowledge the target" +
                                " seeks. Only one question can be asked about a given subject each " +
                                "week.\n" +
                                "\n" +
                                "Power Level 7 - The target can choose a particular event, decision," +
                                " person, place, etc. After invoking this boon, the target begins to" +
                                " have extraordinary encounters (visions, trances, dreams, " +
                                "out-of-body experiences, etc.) through which the GM will provide " +
                                "the target with detailed information about the subject of your " +
                                "prescience. You can only maintain one such subject at a given time," +
                                " however concentration is not required to maintain this state, it " +
                                "is perpetuated until you either choose to end it, or you choose to " +
                                "shift your focus.");
                dao.insert(boon);
                boon = new Boon("Reading",
                        "Power Level: 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tThrough supernatural magic or extrasensory perception, you reach" +
                                " out and connect with an object or place, gaining the ability to " +
                                "read residual information from it and divine what has occurred in " +
                                "its vicinity in the past. This boon is common among psychics, " +
                                "detectives, and specialized hunters.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Prescience",
                        "Effect:\n\tWhen you successfully invoke this boon, you gain information from an object or place within range as follows:\n" +
                                "\n" +
                                "Power Level 5 - The target can read vague ideas and impressions to" +
                                " learn what took place near the object or place within the past " +
                                "hour.\n" +
                                "\n" +
                                "Power Level 6 - The target can see a vivid vision, similar to a " +
                                "recording, of what took place near the object or place within the " +
                                "last hour.\n" +
                                "\n" +
                                "Power Level 7 - The target can ascertain the most recent owner of " +
                                "the object or the people who have most recently been in a place. " +
                                "This knowledge grants enough information for your target to use the" +
                                " spying bane to locate or view those identified.\n" +
                                "\n" +
                                "Power Level 8 - Choose one: The target sees a vision of the most " +
                                "recent significant event that took place in close proximity to the" +
                                " object or place - OR - the target asks whether or not a specific " +
                                "event is impressed upon the object or place.\n" +
                                "\n" +
                                "Power Level 9 - The target is able, given sufficient time, to " +
                                "access all memories impressed upon the object or place. You must " +
                                "maintain concentration, with each 10 minutes yielding a new vision " +
                                "from the object's or place's past. The GM determines the order in " +
                                "which the information is revealed. At the GM's discretion, " +
                                "concealed or particularly distant memories may require a much " +
                                "longer time to discover.");
                dao.insert(boon);
                boon = new Boon("Regeneration",
                        "Power Level: 1/ 3/ 5/ 7/ 9",
                        "Description:\n\tThe target gains an extraordinary ability to heal their wounds." +
                                " Examples of this include the supernatural regeneration of a troll," +
                                " a super soldier's adrenal biomod, or the ability to channel energy" +
                                " that results in continous healing. Regardless of the source, " +
                                "wounds close before the very eyes of an onlooker.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Creation",
                        "Effect:\n\tWhile the regeneration boon is sustained, the target heals hit " +
                                "points at the beginning of each of the boon invoker's turns. The " +
                                "amount of healing is determined by the power level of the boon.\n" +
                                "\n" +
                                "Power Level 1 - 1d4\n" +
                                "\n" +
                                "Power Level 3 - 1d6\n" +
                                "\n" +
                                "Power Level 5 - 1d8\n" +
                                "\n" +
                                "Power Level 7 - 1d10\n" +
                                "\n" +
                                "Power Level 9 - 2d6\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "This boon does not heal lethal damage.");
                dao.insert(boon);
                boon = new Boon("Resistance",
                        "Power Level: 3/ 5/ 7/ 9",
                        "Description:\n\tWhether through a magical force field, an elemental wall, " +
                                "self-attaching body armor, or a temporary mutation, the target" +
                                " becomes resistant to the effects of damage from a certain type " +
                                "of attack. This boon is common among abjurers, engineers, " +
                                "telekinetisists, and elemental mages.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Energy, Movement, Protection",
                        "Effect:\n\tWhen the boon is invoked, the invoker chooses one type of attack " +
                                "and the target gains resistance to that type. The types include " +
                                "precise, forceful, fire, cold, lightning, acid, influence, and " +
                                "entropy (other types may be approved by the GM). The effect of the " +
                                "resistance is determined by the power level of the boon " +
                                "(the following are not cumulative):\n" +
                                "\n" +
                                "Power Level 3 - The target's defense scores are increased by 3 " +
                                "against the chosen attack type.\n" +
                                "\n" +
                                "Power Level 5 - The target's defense scores are increased by 6 " +
                                "against the chosen attack type.\n" +
                                "\n" +
                                "Power Level 7 - The target's defense scores are increased by 9 " +
                                "against the chosen attack type.\n" +
                                "\n" +
                                "Power Level 9 - The target is immune to damage and harmful " +
                                "effects from the chosen attack type.");
                dao.insert(boon);
                boon = new Boon("Restoration",
                        "Power Level: 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tBy invoking protective magic, creative force, or similar powers," +
                                " you cancel all harmful afflictions that are affecting your target." +
                                " Examples of this boon in action include a cleric breaking " +
                                "enchantments, an engineer deploying a team of rescue bots, or a " +
                                "combat medic applying advanced medical techniques.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Instantaneous",
                        "Attributes: Creation, Protection",
                        "Effect:\n\tYou can dispel all banes affecting your target of a power level " +
                                "less than or equal to the level at which you invoke this boon.\n" +
                                "\n" +
                                "\n" +
                                "Power Level 1 - Cancel banes of Power Level 1 or less.\n" +
                                "\n" +
                                "Power Level 2 - Cancel banes of Power Level 2 or less.\n" +
                                "\n" +
                                "Power Level 3 - Cancel banes of Power Level 3 or less.\n" +
                                "\n" +
                                "Power Level 4 - Cancel banes of Power Level 4 or less.\n" +
                                "\n" +
                                "Power Level 5 - Cancel banes of Power Level 5 or less.\n" +
                                "\n" +
                                "Power Level 6 - Cancel banes of Power Level 6 or less.\n" +
                                "\n" +
                                "Power Level 7 - Cancel banes of Power Level 7 or less.\n" +
                                "\n" +
                                "Power Level 8 - Cancel banes of Power Level 8 or less.\n" +
                                "\n" +
                                "Power Level 9 - Cancel banes of Power Level 9 or less.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "You can dispel banes of a power level beyond your power level of " +
                                "this boon. In order to do so, you must invoke this boon using an " +
                                "action roll (i.e., it is not compatible with the automatic success" +
                                " granted by the boon focus feat). The Challenge Rating to dispel a" +
                                " bane in this manner is equal to 20 + twice the bane's power level" +
                                ". So, for example, a power level 9 bane can be dispelled on a roll" +
                                " of 38 even if the invoker does not have an attribute score of 9.");
                dao.insert(boon);
                boon = new Boon("Seeing",
                        "Power Level: 4/ 5/ 6",
                        "Description:\n\tYou are able to see through the eyes of a willing ally. " +
                                "This power might stem from a psychic link, cybernetic implant, " +
                                "or magical enchantment.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Prescience",
                        "Effect:\n\tFor as long as you concentrate, you can see through the eyes of the " +
                                "target, a willing ally. The target can be any friendly creature, " +
                                "including animals, beasts, and humanoids. The distance of the " +
                                "connection depends on the power level of this boon.\n" +
                                "\n" +
                                "Power Level 4 - The ally must be within 100'.\n" +
                                "\n" +
                                "Power Level 5 - The ally must be within 1 mile.\n" +
                                "\n" +
                                "Power Level 6 - The ally must be anywhere on the same plane of " +
                                "existence.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "If your action roll to invoke this boon fails, that ally cannot be " +
                                "targeted for 1 hour.");
                dao.insert(boon);
                boon = new Boon("Shapeshift",
                        "Power Level: 2/ 3/ 4/ 5/ 6/ 7/ 8",
                        "Description:\n\tA target's physical structure is temporarily altered, allowing" +
                                " it to assume the form of potentially any creature no matter how " +
                                "fantastic or exotic. Common examples of shapeshifting include " +
                                "lyncanthropes (such as werewolves), amorphous alien lifeforms, " +
                                "dopplegangers, and certain types of druids.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration",
                        "Effect:\n\tThe target transforms into a creature whose highest attribute is " +
                                "less than or equal to your Alteration score. With the exception " +
                                "of Alteration, all of the target's extraordinary attribute scores " +
                                "drop to zero, and they acquire the Agility, Fortitude, Might, and " +
                                "Perception attributes of the new form.\n" +
                                "The GM, not the player, is responsible for deciding the attributes" +
                                " and abilities of creature. It is recommended that this creature " +
                                "follow the guidelines established by the \"Simple Build\" section" +
                                " for creating NPCs in Chapter 8: Running the Game.\n" +
                                "In order to keep track of hit points, the target should record the" +
                                " total damage they have suffered. When transforming, damage " +
                                "remains with the character even if their maximum hit points change." +
                                " For example, Vera has a max HP of 20 but is turned into a dragon" +
                                " and her Fortitude increases from 5 to 9, increasing her hit points" +
                                " to 28. During combat, she suffers 10 damage. When she later " +
                                "transforms back into her human form, the 10 damage remains and is" +
                                " subtracted from her new maximum, leaving her with 10 out of 20" +
                                " hit points. Additionally, if the shift would reduce the target's" +
                                " hit points to less than 1, the target's hit point total becomes 1" +
                                " instead.\n" +
                                "Limitations are applied starting at power level 2 and are gradually" +
                                " removed at higher power levels:\n" +
                                "\n" +
                                "Power Level 2 - The new form cannot be a different size than that" +
                                " of the target. It must possess similar physiology to the target." +
                                " Examples of different physiology classifications include animals," +
                                " plants, elementals, and oozes. This list is not exhaustive, and " +
                                "the GM has final say as to what forms are allowed. The target does" +
                                " not gain alternate forms of movement (flight, swimming, climbing," +
                                " burrowing, etc.). The target does not gain extraordinary " +
                                "attributes of the new form (hence, they cannot inflict banes that" +
                                " rely on the creature's extraordinary attributes).\n" +
                                "\n" +
                                "Power Level 3 - Shapeshift into a creature between half and double" +
                                " the target's original size. Gain any non-flight movement modes of" +
                                " the new form.\n" +
                                "\n" +
                                "Power Level 4 - Shapeshift into a creature between one quarter and" +
                                " quadruple the target's original size.\n" +
                                "\n" +
                                "Power Level 5 - Gain the flying movement mode of the new form, if" +
                                " applicable.\n" +
                                "\n" +
                                "Power Level 6 - Shapeshift into a living creature of a different " +
                                "physiology, such as an elemental, ooze, or a plant.\n" +
                                "\n" +
                                "Power Level 7 - Gain all extraordinary attributes possessed by the" +
                                " new form. If both forms have an Alteration attribute, the target " +
                                "chooses between the two scores.\n" +
                                "\n" +
                                "Power Level 8 - Shapeshift into a creature of any size.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Shapeshifting into a specific creature (attempting to impersonate " +
                                "them) requires a Deception action roll which is opposed by " +
                                "Perception attribute of anyone who sees the shapeshifted creature." +
                                " In addition, at power levels 4 and lower, the target does not gain" +
                                " mastery over any special movement modes granted by the new form. " +
                                "As such, the movement speed is cut in half for movement modes not " +
                                "native to the original form, and the GM may rule that certain " +
                                "actions, such as swimming in combat, suffer disadvantage on " +
                                "relevant action rolls.");
                dao.insert(boon);
                boon = new Boon("Summon Creature",
                        "Power Level: 4/ 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tYou summon forth a creature to assist your cause, whether " +
                                "they are animals called from the wild, undead minions built from" +
                                " the remains of your foes, or worker bots constructed of spare " +
                                "parts from a salvage yard. This boon is favored by druids, " +
                                "conjurers, engineers, necromancers, and mad scientists.",
                        "Invocation Time: 1 Focus Action",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration, Creation, Entropy, Energy",
                        "Effect:\n\tYou create or summon a temporary NPC companion that is under your " +
                                "control, though of limited intelligence. Your minion's statistics" +
                                " are determined by the power level of this boon. You may assign " +
                                "the attributes as you see fit among the following: Agility, " +
                                "Fortitude, Might, Perception, Energy, and Entropy. Your minion's" +
                                " attributes do not affect their hit points or defenses.\n\n" +
                                "Power Level  Hit Points  Defenses  Attributes\n" +
                                "    4            4          11      2, 1, 1\n" +
                                "    5            5          12      3, 2, 2\n" +
                                "    6            6          13      4, 3, 3\n" +
                                "    7            7          14      5, 4, 4\n" +
                                "    8            8          15      6, 5, 5\n" +
                                "    9            9          16      7, 6, 6\n\n" +
                                "Your minion cannot act on the turn that it is summoned. On each " +
                                "of your following turns, your minion acts on your initiative count" +
                                " according to your direction, receiving the usual assortment of " +
                                "actions. You are limited to a maximum number of summoned creatures" +
                                " equal to your invoking attribute score. Feats and other abilities" +
                                " cannot increase this limit.\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "Creatures summoned by this boon cannot be healed if they reach " +
                                "zero hit points. They are permanently dead. Additionally, creatures" +
                                " summoned by this boon cannot invoke it.\n" +
                                "Multi-targeting for this boon does not work as it does for other" +
                                " boons. You may use a single invocation to summon multiple " +
                                "creatures. For each additional creature summoned beyond the first," +
                                " you suffer an additional disadvantage 2 on your action roll to " +
                                "invoke. Any effect that modifies multi-targeting penalties will " +
                                "work as normal in offsetting this disadvantage.");
                dao.insert(boon);
                boon = new Boon("Sustenance",
                        "Power Level: 3/ 4/ 5/ 7/ 9",
                        "Description:\n\tYou protect the target from environmental dangers or suspend " +
                                "their usual biological needs. Examples include sprouting gills " +
                                "to allow for underwater breathing, calling on a divine power to " +
                                "be sustained without food, and using far-future biomodifications " +
                                "to endure extreme cold.",
                        "Invocation Time: 1 Major Action",
                        "Duration: 24 hours",
                        "Attributes: Alteration, Creation, Protection",
                        "Effect:\n\tYou protect the target from one environmental danger, biological " +
                                "need, or similar condition. The power level of this boon determines" +
                                " the type of conditions you may protect against.\n" +
                                "\n" +
                                "Power Level 3 - Target is unaffected by a chosen type of hostile " +
                                "climate. Examples include heat, cold, and radiation.\n" +
                                "\n" +
                                "Power Level 4 - Target can sustain a single biological need from " +
                                "an alternate source, such as by breathing the oxygen found in " +
                                "water, drinking from an irradiated stream, or eating food not " +
                                "normally edible\n" +
                                "\n" +
                                "Power Level 5 - Target can subsist without the essential " +
                                "nourishment periodically required for sustenance, such as food " +
                                "or water.\n" +
                                "\n" +
                                "Power Level 7 - Target can subsist without the most critical " +
                                "nourishment, that which is typically consumed on a " +
                                "moment-to-moment basis, such as air.\n" +
                                "\n" +
                                "Power Level 9 - Target is unaffected even when cut off from " +
                                "all biological necessities, including warmth, water, air, food, " +
                                "and any other biological need.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Special\n" +
                                "\n" +
                                "You may only have one instance of this boon in effect at any " +
                                "given time. As soon as you invoke it, any previous invocations " +
                                "are immediately canceled.");
                dao.insert(boon);
                boon = new Boon("Telekinesis",
                        "Power Level: 3/ 5/ 7/ 9",
                        "Description:\n\tYou reach out and extraordinarily control an unattended " +
                                "inanimate object. This may stem from latent psychic ability," +
                                " magical manipulation of the element of air, anti-gravity " +
                                "technology, or similar sources.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Movement",
                        "Effect:\n\tImmediately upon invoking the boon, and again each round when you " +
                                "sustain the boon, you may move the target object up to 5' times " +
                                "your invoking attribute score. As part of moving an object, you " +
                                "may also manipulate it (for example, turning a door knob or " +
                                "opening a coin purse). A new invocation of this boon must be " +
                                "attempted whenever you wish to target a different object. The " +
                                "power level of the boon determines the size and weight of the " +
                                "objects you may target:\n" +
                                "\n" +
                                "Power Level 3 - The object must be smaller than a 1' cube or " +
                                "lighter than 10 pounds.\n" +
                                "\n" +
                                "Power Level 5 - The object must be smaller than a 5' cube or " +
                                "lighter than 100 pounds.\n" +
                                "\n" +
                                "Power Level 7 - The object must be smaller than a 10' cube or " +
                                "lighter than 1,000 pounds.\n" +
                                "\n" +
                                "Power Level 9 - The object must be smaller than a 20' cube or " +
                                "lighter than 10,000 pounds.");
                dao.insert(boon);
                boon = new Boon("Telepathy",
                        "Power Level: 3/ 5/ 6/ 7",
                        "Description:\n\tYou reach out mentally to a willing target and speak wordlessly" +
                                " with thought-to-thought communication. Examples of this boon in" +
                                " action include a psychic who can connect with the minds of others" +
                                " and a far future artificial intelligence capable of passing " +
                                "information to other beings through the vibration of quantum strings.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Influence, Prescience",
                        "Effect:\n\tYou and the target can communicate with each other simply through" +
                                " thought. Note that this telepathy does not bestow intelligence " +
                                "upon creatures, so you could not use it to communicate with a " +
                                "squirrel unless you already possessed other means of doing so. " +
                                "Additionally, telepathy does not bypass language barriers, so you" +
                                " would need to already speak the language of your target.\n" +
                                "\n" +
                                "Power Level 3 - You can communicate telepathically with a single " +
                                "creature of animal-level intelligence or lower. Keep in mind that" +
                                " it can only communicate concepts with you that it can understand.\n" +
                                "\n" +
                                "Power Level 5 - You can communicate telepathically with a single " +
                                "creature of humanoid intelligence.\n" +
                                "\n" +
                                "Power Level 6 - You can create a mental relay between yourself " +
                                "and up to five other creatures allowing each of them to communicate" +
                                " with the rest of the group simultaneously.\n" +
                                "\n" +
                                "Power Level 7 - You can communicate telepathically with any number" +
                                " of creatures that you can see.");
                dao.insert(boon);
                boon = new Boon("Teleport",
                        "Power Level: 3/ 5/ 7/ 9",
                        "Description:\n\tYou are able to instantly move yourself or an ally from one " +
                                "place to another, either by stepping into an intermediate realm," +
                                " deconstructing and reforming a physical body, transporting " +
                                "magically, or similar means.",
                        "Invocation Time: 1 Move Action",
                        "Duration: Instantaneous",
                        "Attributes: Movement",
                        "Effect:\n\t\n" +
                                "Power Level 3 - You can teleport the target to any unoccupied " +
                                "space within 5 feet per Movement attribute score as long as you " +
                                "can naturally see your destination.\n" +
                                "\n" +
                                "Power Level 5 - Your teleportation range is unchanged, but you " +
                                "can now teleport your target to spaces that you can't see. If you" +
                                " choose an occupied space, your target lands in the nearest " +
                                "adjacent space (roll randomly to decide if there are multiple " +
                                "options) and your target is stunned for 1 round (a resist roll " +
                                "is not needed to end the effect).\n" +
                                "\n" +
                                "Power Level 7 - You can opt to take longer in invoking the boon. " +
                                "If you choose to do so, for each minute of invocation (delay " +
                                "before making your action roll) you can teleport the target 1 mile," +
                                " up to a maximum number of miles equal to your Movement attribute " +
                                "score. While the distance is greater, this mode is also dangerous," +
                                " as a misunderstanding of direction or geography can put your " +
                                "target many miles in an unfavorable direction. You simply choose a" +
                                " direction (relative to your starting location) and teleport your " +
                                "target a number of miles equal to your Movement score. During " +
                                "invocation, you must spend a focus action each turn until the " +
                                "invocation time passes.\n" +
                                "\n" +
                                "Power Level 9 - Using the same longer invocation time for power " +
                                "level 7, you can now teleport your target to any location without" +
                                " range limit, provided you have personally seen (through magical" +
                                " or normal means) the destination.");
                dao.insert(boon);
                boon = new Boon("Tongues",
                        "Power Level: 5/ 6",
                        "Description:\n\tYou or an ally temporarily gains the ability to read, write, " +
                                "and speak languages that they are otherwise unfamiliar with. " +
                                "This ability may come by channeling interplanar spirits, " +
                                "tapping the power of a super intelligence, making deductions" +
                                " based on an extraordinary understanding of the science of " +
                                "communication, or similar means.",
                        "Invocation Time: 10 Minutes",
                        "Duration: Sustain Persists",
                        "Attributes: Prescience",
                        "Effect:\n\t\n" +
                                "Power Level 5 - Your target can understand and speak a " +
                                "language of your choice.\n" +
                                "\n" +
                                "Power Level 6 - Your target can read a language of your choice.");
                dao.insert(boon);
                boon = new Boon("Transmutation",
                        "Power Level: 3/ 5/ 7/ 8/ 9",
                        "Description:\n\tYou are able to change the size, shape, and composition of " +
                                "physical matter that you touch. Transmute rocks to gold, a wall " +
                                "into a door, or a lump of metal into a loaded gun. This boon is " +
                                "favored among druids, transmuters, engineers, and mad scientists.",
                        "Invocation Time: 1 Minute",
                        "Duration: Sustain Persists",
                        "Attributes: Alteration",
                        "Effect:\n\tYour power level determines the types of matter you can transmute " +
                                "as well as the duration of the effect. The duration is either " +
                                "temporary or permanent. A temporary transmutation must be sustained" +
                                " every round. A permanent transmutation does not have to be " +
                                "sustained and persists until some other effect would cancel it. " +
                                "The maximum volume of matter you can transmute is on 5 cubic feet " +
                                "multiplied by your attribute score.\n" +
                                "\n" +
                                "Power Level 3 - Temporarily transmute an object into another " +
                                "object of the same size and weight.\n" +
                                "\n" +
                                "Power Level 5 - Temporarily transmute an object into another " +
                                "object of the same size and 50% greater or lesser weight. " +
                                "Temporarily transmute an object into another object of the same " +
                                "weight and 50% greater or lesser size.\n" +
                                "\n" +
                                "Power Level 7 - Permanently transmute an object into another " +
                                "object of the same size and weight. Temporarily transmute an " +
                                "object into another object of the same size and 200% greater " +
                                "or lesser weight. Temporarily transmute an object into another " +
                                "object of the same weight and 200% greater or lesser size.\n" +
                                "\n" +
                                "Power Level 8 - Permanently transmute an object into another " +
                                "object of up to 200% difference in size and/or weight. Temporarily " +
                                "transmute a simple object into a mundane object of notable " +
                                "complexity. The resulting object must be of Wealth Level 2 or less.\n" +
                                "\n" +
                                "Power Level 9 - Permanently transmute a simple object into a " +
                                "mundane and complex one. The resulting object must be of Wealth " +
                                "Level 2 or less.");
                dao.insert(boon);
                boon = new Boon("Truesight",
                        "Power Level: 5/ 6/ 7/ 8/ 9",
                        "Description:\n\tYou grant yourself or an ally the ability to perceive that " +
                                "which cannot be detected with mundane senses, piercing impediments" +
                                " that would block or deceive normal sight, including darkness, " +
                                "solid objects, illusions, and even the barrier between alternate " +
                                "planes of reality. This power may stem from extrasensory " +
                                "perception, divine blessing, cybernetically enhanced senses, or " +
                                "similar means.",
                        "Invocation Time: 1 Major Action",
                        "Duration: Sustain Persists",
                        "Attributes: Prescience",
                        "Effect:\n\t\n" +
                                "Power Level 5 - The target sees the presence of extraordinary " +
                                "effects such as magic, cloaking technology, and other effects " +
                                "that could be seen through extra-visual perception. In addition," +
                                " this boon grants advantage 1 on rolls used to detect mundane " +
                                "concealment such as hidden passages, furniture with hidden storage" +
                                " and concealed traps or other hazards.\n" +
                                "\n" +
                                "Power Level 7 - The target's extraordinary sight pierces through " +
                                "all illusory effects, allowing them to see a *phantasm* for what " +
                                "it is.\n" +
                                "\n" +
                                "Power Level 8 - The target can see through solid objects and " +
                                "their natural visual range is unhindered by them.\n" +
                                "\n" +
                                "Power Level 9 - The extraordinary sight enables the target to peer " +
                                "into alternate planes or dimensions. They can see into dimensional" +
                                " pockets and other planes that overlap with the one they are " +
                                "currently on. In addition, the target's visual range becomes " +
                                "supercharged.");
                dao.insert(boon);
            });
        }
    };
}