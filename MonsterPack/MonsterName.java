package MonsterPack;

import java.util.Random;

/**
 * Classe permettant de récupérer des noms de mosntre aléatoire
 */
public class MonsterName {
    /**
     * Permet de retourner un adjectif de monstre aléatoire
     * @return  L'adjectif de monstre
     */
    public static String RandomMonsterAdjective(){
        String[] adjectives ={
            "Twin",
            "Venom",
            "Primeval",
            "Silver",
            "Quiet",
            "Rotten",
            "Evasive",
            "Nightmare",
            "Big",
            "Needy",
            "Raptor",
            "Bruised",
            "Young",
            "Rainbow",
            "Flamed",
            "Crying",
            "Icy",
            "Night",
            "Sunshine",
            "Cute",
            "Scared",
            "Cursed",
            "Furry",
            "Bright",
            "Baby",
            "Wild",
            "Howling",
            "Clockwork",
            "Disfigured",
            "Muted",
            "Scary",
            "Red-Eyed",
            "Blood",
            "Creepy",
            "Vengeful",
            "Horned",
            "Violent",
            "Noodle",
            "Rusty",
            "Stinky",
            "Loopy",
            "Picky",
            "Dirty",
            "Whooping",
            "Yummy",
            "Granny",
            "Lazy",
            "Sneaky",
            "Tiny",
            "Wondrous",
            "Aromatic",
            "Phantom",
            "Mindful",
            "Kind-Hearted",
            "Charming",
            "Friendly",
            "Glowing",
            "Sweet",
            "Eternal",
            "Lonely",
            "Good"
        };

        Random generator = new Random();
        int randomIndex = generator.nextInt(adjectives.length);
        return adjectives[randomIndex];
    }

    /**
     * Permet de retourner un nom de monstre aléatoire
     * @return  Le nom de monstre
     */
    public static String RandomMonsterNickname(){
        String[] names ={
            "Brinecat",
            "Abysstalon",
            "Brineling",
            "Vapormutant",
            "Emberword",
            "Grossmutant",
            "Grossbug",
            "Germeyes",
            "Brinebeast",
            "Soilface",
            "Brineface",
            "Emberbug",
            "Curseword",
            "Cursefigure",
            "Soilword",
            "Emberface",
            "Ghosteyes",
            "Vaporface",
            "Webmutant",
            "Germface",
            "Vaporman",
            "Webfigure",
            "Deadmutant",
            "Cursetalon",
            "Germword",
            "Brineeyes",
            "Webtalon",
            "Ghostfigure",
            "Deadling",
            "Brineword",
            "Germtalon",
            "Deadbeast",
            "Deadfigure",
            "Grosswing",
            "Decayman",
            "Abyssbug",
            "Cursecat",
            "Abyssman",
            "Ghostcat",
            "Grosscat",
            "Vaportalon",
            "Emberman",
            "Soilling",
            "Grossman",
            "Deadwing",
            "Ghostbug",
            "Soilfigure",
            "Deadeyes",
            "Soilbug",
            "Ghostling",
            "Curseman",
            "Brinetalon",
            "Germman",
            "Germbeast",
            "Decayface",
            "Deadcat",
            "Soilbeast",
            "Grossfigure",
            "Decayeyes",
            "Emberfigure",
            "Decaywing",
            "Ghostmutant",
            "Embertalon",
            "Decaycat",
            "Brinemutant",
            "Decaytalon",
            "Decaymutant",
            "Webman",
            "Webeyes",
            "Abyssling",
            "Vaporfigure",
            "Vaporcat",
            "Germbug",
            "Abyssfigure",
            "Brinefigure",
            "Emberling",
            "Cursewing",
            "Emberbeast",
            "Curseling",
            "Ghostbeast",
            "Brinewing",
            "Decayling",
            "Webword",
            "Embereyes",
            "Curseface",
            "Vaporwing",
            "Embercat",
            "Cursebeast",
            "Cursemutant",
            "Ghostwing",
            "Webbug",
            "Deadword",
            "Vaporeyes",
            "Vaporling",
            "Deadface",
            "Deadbug",
            "Germling",
            "Decayfigure",
            "Deadman",
            "Emberwing",
            "Grossbeast",
            "Vaporbeast",
            "Germcat",
            "Decaybeast",
            "Brineman",
            "Webface",
            "Webbeast",
            "Curseeyes",
            "Webling",
            "Vaporbug",
            "Grossling",
            "Ghostman",
            "Germmutant",
            "Grosseyes",
            "Soileyes",
            "Vaporword",
            "Goolops",
            "Youngly",
            "Gloomlops",
            "Doomboo",
            "Goopaw",
            "Acidgirl",
            "Muckga",
            "Smogfang",
            "Poogirl",
            "Mucktree",
            "Gooloo",
            "Moongirl",
            "Smogboy",
            "Ewwga",
            "Gooboo",
            "Ewwpaw",
            "Dreamgirl",
            "Gloomboy",
            "Moontree",
            "Mucklops",
            "Dreamlu",
            "Youngga",
            "Gloomtree",
            "Ashboo",
            "Moonlu",
            "Gloomfang",
            "Gooling",
            "Dreamlops",
            "Doomfang",
            "Ashfang",
            "Doomlops",
            "Dreamga",
            "Muckfang",
            "Pooly",
            "Muckboo",
            "Mucklu",
            "Moonlops",
            "Poolu",
            "Youngling",
            "Moonling",
            "Youngfang",
            "Doompaw",
            "Ewwlops",
            "Smogga",
            "Ewwloo",
            "Pooboo",
            "Moonboo",
            "Dreamling",
            "Gloomlu",
            "Ashpaw",
            "Gloomloo",
            "Dreampaw",
            "Dreamfang",
            "Gloomgirl",
            "Ewwgirl",
            "Moonfang",
            "Gootree",
            "Moonloo",
            "Smogpaw",
            "Ewwboo",
            "Youngboy",
            "Ashling",
            "Ashtree",
            "Ashga",
            "Youngpaw",
            "Dreamtree",
            "Acidly",
            "Gloomboo",
            "Smoggirl",
            "Dreamly",
            "Ashboy",
            "Ewwboy",
            "Smogling",
            "Poopaw",
            "Moonly",
            "Gloomling",
            "Moonpaw",
            "Gooboy",
            "Younglu",
            "Muckboy",
            "Acidfang",
            "Ewwly",
            "Ashgirl",
            "Acidboo",
            "Acidloo",
            "Smogly",
            "Acidlops",
            "Goofang",
            "Ewwtree",
            "Goolu",
            "Doomgirl",
            "Pootree",
            "Poolops",
            "Doomga",
            "Muckloo",
            "Smoglops",
            "Youngtree",
            "Googirl",
            "Ashlops",
            "Acidling",
            "Youngboo",
            "Muckly",
            "Moonboy",
            "Doomly",
            "Googa",
            "Gloomly",
            "Pooloo",
            "Ashly",
            "Pooling",
            "Ewwling",
            "Muckling",
            "Muckpaw",
            "Smoglu",
            "Younglops",
            "Pooboy",
            "Acidtree",
            "Abyssface",
            "Germfigure",
            "Soilwing",
            "Soilmutant",
            "Soilman",
            "Webwing",
            "Abysseyes",
            "Ghostface",
            "Brinebug",
            "Decaybug",
            "Grossword",
            "Abyssmutant",
            "Germwing",
            "Abysswing",
            "Abyssword",
            "Abysscat",
            "Webcat",
            "Razormera",
            "Nighttoe",
            "Wispflesh",
            "Pikeclaw",
            "Rottingbane",
            "Poisontoe",
            "Poisonbane",
            "Taintbody",
            "Cursebane",
            "Poisonflesh",
            "Curseflesh",
            "Razordra",
            "Curseclaw",
            "Rottingthroat",
            "Wispbody",
            "Gruethroat",
            "Razorling",
            "Blackeyes",
            "Bloodclaw",
            "Gruemoth",
            "Tainteyes",
            "Rottingbody",
            "Gutfreak",
            "Poisonbeast",
            "Nightclaw",
            "Razorthroat",
            "Taintling",
            "Bloodling",
            "Cursemera",
            "Cursemoth",
            "Piketaur",
            "Wispclaw",
            "Wispeyes",
            "Nightlisk",
            "Curselisk",
            "Gutwing",
            "Cursebody",
            "Nightdra",
            "Bloodeyes",
            "Poisonsome",
            "Razorlisk",
            "Bloodfreak",
            "Pikewing",
            "Bloodmoth",
            "Grueflesh",
            "Rottingling",
            "Blackbody",
            "Pikelisk",
            "Wispsome",
            "Gruelisk",
            "Razorsome",
            "Pikeflesh",
            "Poisonwing",
            "Poisonbody",
            "Poisondra",
            "Rottingfreak",
            "Wispmoth",
            "Wispmera",
            "Wisptaur",
            "Bloodflesh",
            "Gruebody",
            "Bloodlisk",
            "Piketoe",
            "Blackflesh",
            "Cursethroat",
            "Blackthroat",
            "Taintsome",
            "Grueclaw",
            "Rottingtoe",
            "Gutbane",
            "Gruebeast",
            "Taintdra",
            "Gruewing",
            "Blackfreak",
            "Razorbane",
            "Taintlisk",
            "Poisonthroat",
            "Blackling",
            "Cursetaur",
            "Rottingeyes",
            "Cursedra",
            "Tainttoe",
            "Taintflesh",
            "Bloodwing",
            "Poisonling",
            "Taintbane",
            "Wisplisk",
            "Rottinglisk",
            "Wispbeast",
            "Rotsores",
            "Hoopylily",
            "Fubsydoo",
            "Hoopyhog",
            "Mistbear",
            "Bigpickles",
            "Piefeet",
            "Bigsores",
            "Bigloop",
            "Rotbear",
            "Pieeyes",
            "Bigmaniac",
            "Goodoo",
            "Fubsylily",
            "Bumloop",
            "Goofeet",
            "Rotfeet",
            "Misteyes",
            "Diddlejeepers",
            "Bumpickles",
            "Pielily",
            "Piegoo",
            "Hoopycreep",
            "Fubsyfeet",
            "Macaronihog",
            "Fartbear",
            "Fubsygoo",
            "Poopaman",
            "Poopamaniac",
            "Fubsycreep",
            "Bumeyes",
            "Mistgoo",
            "Fartpickles",
            "Poopapickles",
            "Poopajeepers",
            "Fartcreep",
            "Piemaniac",
            "Rotdoo",
            "Biggoo",
            "Hoopyfeet",
            "Rotgoo",
            "Diddlesores",
            "Mistsores",
            "Fubsypickles",
            "Piebear",
            "Diddleeyes",
            "Rotcreep",
            "Piejeepers",
            "Macaronijeepers",
            "Fartgoo",
            "Fubsybear",
            "Fartlily",
            "Macaronidoo",
            "Piedoo",
            "Fartsores",
            "Macaroniman",
            "Bumsores",
            "Rothog",
            "Biglily",
            "Diddlefeet",
            "Farthog",
            "Fartdoo",
            "Poopasores",
            "Diddleman",
            "Goojeepers",
            "Roteyes",
            "Bumjeepers",
            "Bigjeepers",
            "Rotlily",
            "Farteyes",
            "Macaroniloop",
            "Rotmaniac",
            "Fubsyeyes",
            "Goohog",
            "Hoopypickles",
            "Poopabear",
            "Rotloop",
            "Poopacreep",
            "Bumcreep",
            "Gooman",
            "Fubsyman",
            "Macaronibear",
            "Mistman",
            "Mistpickles",
            "Bumdoo",
            "Googoo",
            "Macaronieyes",
            "Bumfeet",
            "Fubsyloop",
            "Macaronimaniac",
            "Bigdoo",
            "Goosores",
            "Fartmaniac",
            "Diddlegoo",
            "Goomaniac",
            "Pieman",
            "Diddlemaniac",
            "Hoopygoo",
            "Goocreep",
            "Macaronifeet",
            "Hoopydoo",
            "Pieloop",
            "Diddlepickles",
            "Gooloop",
            "Bumgoo",
            "Fubsyhog",
            "Fartfeet",
            "Piesores",
            "Poopaloop",
            "Bigcreep",
            "Poopagoo",
            "Poopalily",
            "Rotjeepers",
            "Hoopyjeepers",
            "Rotman",
            "Poopaeyes",
            "Hoopybear",
            "Piehog",
            "Mistdoo",
            "Bighog",
            "Bumman",
            "Hoopymaniac",
            "Fubsymaniac",
            "Poopadoo",
            "Mistloop",
            "Diddlecreep",
            "Diddledoo",
            "Dawnmask",
            "Sparkpaw",
            "Auramorph",
            "Vampbeast",
            "Spiritpaw",
            "Dawnmirage",
            "Spectralbeast",
            "Mistbeing",
            "Spiritling",
            "Mistchild",
            "Nightling",
            "Nightthing",
            "Whiteclaw",
            "Sparkbeast",
            "Emberfang",
            "Dawnbeast",
            "Spiritmorph",
            "Spiritsoul",
            "Glowmask",
            "Spectralfang",
            "Embersoul",
            "Whitewings",
            "Dawnbeing",
            "Spectralling",
            "Spiritfang",
            "Tanglesoul",
            "Aurachild",
            "Whitesoul",
            "Sparkclaw",
            "Vampmirage",
            "Glowmirage",
            "Mistwings",
            "Dawnjester",
            "Mistbeast",
            "Spectralthing",
            "Spiritchild",
            "Glowthing",
            "Dawnwings",
            "Vampsoul",
            "Sparkfang",
            "Aurajester",
            "Vampbeing",
            "Spectralclaw",
            "Spiritbeing",
            "Tanglefly",
            "Dawnfly",
            "Nightjester",
            "Sparkmask",
            "Spiritbeast",
            "Dawnfang",
            "Spiritmirage",
            "Whitechild",
            "Spiritjester",
            "Tanglemask",
            "Aurabeast",
            "Emberwings",
            "Sparkmorph",
            "Nightsoul",
            "Emberchild",
            "Auraclaw",
            "Embermask",
            "Spectralmirage",
            "Glowling",
            "Glowjester",
            "Mistjester",
            "Aurapaw",
            "Auramirage",
            "Sparkmirage",
            "Embermorph",
            "Spectraljester",
            "Whitefang",
            "Sparkchild",
            "Spiritwings",
            "Sparkwings",
            "Mistpaw",
            "Mistthing",
            "Sparkthing",
            "Auraling",
            "Spectralchild",
            "Spiritthing",
            "Tanglechild",
            "Nightchild",
            "Whitebeast",
            "Mistsoul",
            "Spectralmorph",
            "Aurawings",
            "Emberbeing",
            "Tanglemirage",
            "Glowbeing",
            "Dawnchild",
            "Whitemirage",
            "Vampling",
            "Glowsoul",
            "Vampfly",
            "Sparksoul",
            "Tanglepaw",
            "Nightfang",
            "Aurafang",
            "Vampchild",
            "Tangleclaw",
            "Nightmorph",
            "Tanglefang",
            "Whiteling",
            "Tanglething",
            "Glowclaw",
            "Emberfly",
            "Whitebeing",
            "Nightbeast",
            "Spiritfly",
            "Mistmorph",
            "Glowmorph",
            "Glowfly",
            "Auramask",
            "Nightmirage",
            "Spectralsoul",
            "Glowwings",
            "Dawnthing",
            "Aurabeing",
            "Tanglemorph"
        };

        Random generator = new Random();
        int randomIndex = generator.nextInt(names.length);
        return names[randomIndex];
    }
}
