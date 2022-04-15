package wazzle.controller.common;

import java.io.IOException;


import java.util.List;

import wazzle.controller.maingame.GameHistoryController;
import wazzle.controller.maingame.GameHistoryControllerImpl;
import wazzle.controller.maingame.Settings;
import wazzle.controller.maingame.SettingsController;
import wazzle.controller.maingame.SettingsControllerImpl;
import wazzle.controller.maingame.SettingsImpl;
import wazzle.model.common.BonusManager;
import wazzle.model.common.BonusManagerImpl;
import wazzle.model.maingame.MainGame;
import wazzle.model.maingame.MainGameImpl;

public class WazzleControllerImpl implements WazzleController {

	private final FileController fileController;
//	private final Settings settings;
//	private final List<MainGameImpl> gameHistory;
	private final SettingsController settingsController;
	private final GameHistoryController gameHistoryController;
	private final BonusManager bonusManager;
	private final Facade facade;
		
	/**
	 * Construct a new WazzleController.
	 * 
	 * @throws IOException
	 */
	public WazzleControllerImpl() throws IOException {
		this.fileController = new FileControllerImpl();
		this.settingsController = new SettingsControllerImpl(new SettingsImpl());
		//this.gameHistoryController = new GameHistoryControllerImpl(this.fileController.getMainGameHistory("history.json"));
		//this.bonusManager = this.fileController.getBonuses("bonus.json");
		this.gameHistoryController = new GameHistoryControllerImpl(List.of());
		this.bonusManager = new BonusManagerImpl();
		this.facade = new Facade();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileController getFileController() {
		return this.fileController.getThis();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SettingsController getSettingsController() {
		return this.settingsController;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Settings getSettings() {
		return this.settingsController.getCurrentSettings();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameHistoryController getGameHistoryController() {
		return this.gameHistoryController;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MainGameImpl> getGameHistory() {
		return List.copyOf(this.gameHistoryController.getGameHistory());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BonusManager getBonusManager() {
		return this.bonusManager;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Facade getFacade() {
		return this.facade;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gainBonus() {
		this.bonusManager.extractBonus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addMainGametoHistory(final MainGame mainGame) {
		this.gameHistoryController.addNewGame((MainGameImpl) mainGame);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSettings(Settings settings) {
		this.settingsController.updateSettings(settings.getCurrentDifficulty(), settings.getCurrentGridShape());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WazzleController getThis() {
		return this;
	}
}