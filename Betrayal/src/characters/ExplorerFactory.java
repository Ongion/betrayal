package characters;
import characters.Character.Character_Name;

public class ExplorerFactory {

	public ExplorerFactory() {
	}
	
	public Character getExplorer(Character_Name name) {
		switch(name) {
		case FatherRhinehardt:
			return new Character(Character_Name.FatherRhinehardt, new ExplorerType(), new HumanStats(69, 62, 185, new int[]{1,3,3,4,5,6,6,8}, new int[]{3,4,5,5,6,7,7,8}, new int[]{1,2,2,4,4,5,5,7}, new int[]{2,3,3,4,5,6,7,7}, 3, 4, 2, 2));
		case ProfessorLongfellow:
			return new Character(Character_Name.ProfessorLongfellow, new ExplorerType(), new HumanStats(71, 57, 153,new int[]{4,5,5,5,5,6,7,8}, new int[]{1,3,3,4,5,5,6,7}, new int[]{1,2,3,4,5,5,6,6}, new int[]{2,2,4,4,5,5,6,6}, 4, 2, 2, 3));
		case BrandonJaspers:
			return new Character(Character_Name.BrandonJaspers, new ExplorerType(), new HumanStats(61, 12, 109, new int[]{1,3,3,5,5,6,6,7}, new int[]{3,3,3,4,5,6,7,8}, new int[]{2,3,3,4,5,6,6,7}, new int[]{3,4,4,4,5,6,7}, 2, 3, 3, 2));
		case DarrinWilliams:
			return new Character(Character_Name.DarrinWilliams, new ExplorerType(), new HumanStats(71, 20, 188, new int[]{2,3,3,4,5,5,5,7}, new int[]{1,2,3,4,5,5,5,7}, new int[]{2,3,3,4,5,6,6,7}, new int[]{4,4,4,5,6,7,7,8}, 2, 2, 2, 4));
		case HeatherGranville:
			return new Character(Character_Name.HeatherGranville, new ExplorerType(), new HumanStats(62, 18, 120, new int[]{2,3,3,4,5,6,7,8}, new int[]{3,3,3,4,5,6,6,6}, new int[]{3,3,3,4,5,6,7,8}, new int[]{3,3,4,5,6,6,7,8}, 4, 2, 2, 2));
		case JennyLeClerc:
			return new Character(Character_Name.JennyLeClerc, new ExplorerType(), new HumanStats(67, 21, 142, new int[]{2,3,3,4,4,5,6,8}, new int[]{1,1,2,4,4,4,5,6}, new int[]{3,4,4,4,4,5,6,8}, new int[]{2,3,4,4,4,5,6,8}, 2, 4, 2, 3));
		case MadameZostra:
			return new Character(Character_Name.MadameZostra, new ExplorerType(), new HumanStats(60, 37, 150, new int[]{1,3,4,4,4,5,6,6}, new int[]{4,4,4,5,6,7,8,8}, new int[]{2,3,3,4,5,5,5,6}, new int[]{2,3,3,5,5,6,6,7}, 3,2,3,2));
		case MissyDubourde:
			return new Character(Character_Name.MissyDubourde, new ExplorerType(), new HumanStats(50, 9, 62, new int[]{2,3,4,4,5,6,6,6}, new int[]{1,2,3,4,5,5,6,7}, new int[]{2,3,3,3,4,5,6,7}, new int[]{3,4,5,6,6,6,7,7}, 3, 2, 3, 2));
		case OxBellows:
			return new Character(Character_Name.OxBellows, new ExplorerType(), new HumanStats(76, 23, 288, new int[]{2,2,3,3,5,5,6,6}, new int[]{2,2,3,4,5,5,6,7}, new int[]{4,5,5,6,6,7,8,8}, new int[]{2,2,2,3,4,5,5,6}, 2, 2, 2, 4));
		case PeterAkimoto:
			return new Character(Character_Name.PeterAkimoto, new ExplorerType(), new HumanStats(59, 13, 98, new int[]{3,4,4,5,6,7,7,8}, new int[]{3,4,4,4,5,6,6,7}, new int[]{2,3,3,4,5,5,6,8}, new int[]{3,3,3,4,6,6,7,7}, 2, 3, 2, 3));
		case VivianLopez:
			return new Character(Character_Name.VivianLopez, new ExplorerType(), new HumanStats(65, 42, 142, new int[]{4,5,5,5,5,6,6,7}, new int[]{4,4,4,5,6,7,8,8}, new int[]{2,2,2,4,4,5,6,6}, new int[]{3,4,4,4,4,6,7,8}, 3, 2, 2, 3));
		case ZoeIngstrom:
			return new Character(Character_Name.ZoeIngstrom, new ExplorerType(), new HumanStats(45, 8, 49, new int[]{1,2,3,4,4,5,5,5}, new int[]{3,4,5,5,6,6,7,8}, new int[]{2,2,3,3,4,4,6,7}, new int[]{4,4,4,4,5,6,8,8}, 2, 2, 4, 3));
		default:
			throw new IllegalArgumentException();
		}
				
	}

}
