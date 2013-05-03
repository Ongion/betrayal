package actions;

import itemCards.ItemCard;

import java.util.ResourceBundle;

import rooms.ActionAddingTile;
import rooms.Room;

import Game.Game;

import characters.Character;
import characters.Trait;

public class OpenVaultAction implements IAction {
	Room vaultRoom;

	public OpenVaultAction(Room vaultRoom) {
		this.vaultRoom = vaultRoom;
	}

	@Override
	public String getName() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("OpenVaultName");
	}

	@Override
	public String getDescription() {
		return ResourceBundle.getBundle("actions/ActionBundle", Game.getInstance().getLocale()).getString("OpenVaultDescription");
	}
	
	public Room getVaultRoom() {
		return this.vaultRoom;
	}

	@Override
	public boolean canPerform(Character characterAttemptingAction) {
		return true;
	}

	@Override
	public void perform(Character characterPerformingAction) {
		final int REQUIREDKNOWLEDGE = 6;
		int rollResult = characterPerformingAction.getTraitRoll(Trait.KNOWLEDGE);
		if (rollResult >= REQUIREDKNOWLEDGE) {
			final int ITEMSINVAULT = 2;
			for (int i = 0; i < ITEMSINVAULT; i++) {
				ItemCard item = Game.getInstance().drawItem();
				characterPerformingAction.addItemCard(item);
			}
			vaultRoom.removeRoomAction(this);
			vaultRoom.addActionAddingTile(ActionAddingTile.VAULT_EMPTY);
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof OpenVaultAction)) {
			return false;
		}
		OpenVaultAction otherVault = (OpenVaultAction) other;
		return this.vaultRoom == otherVault.getVaultRoom();
	}
	
	@Override
	public int hashCode() {
		final int prime = 83;
		int hash = 145387;
		hash = prime * hash + this.vaultRoom.hashCode();
		return hash;
	}
}
