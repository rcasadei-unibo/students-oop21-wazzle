package wazzle.controller.maingame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import wazzle.model.maingame.MainGame;
import wazzle.model.maingame.MainGameImpl;

public class GameHistoryControllerImpl implements GameHistoryController {
	
	List<MainGameImpl> gameHistory;
	
	public GameHistoryControllerImpl(WazzleController wazzleController) {
		this.gameHistory = wazzleController.getGameHistory();
	}

	@Override
	public List<MainGameImpl> getGameHistory() {
		return this.gameHistory;
	}

	@Override
	public MainGame getBestGame() {
		return this.gameHistory.stream().filter(mg -> mg.getCurrentScore() == this.gameHistory
																				  .stream()
																				  .map(g -> g.getCurrentScore())
																				  .max(Comparator.comparing(Double::valueOf))
																				  .orElse(Double.NaN))
								 		.findFirst()
								 		.get();
	}

	@Override
	public List<MainGameImpl> getSortedByDataGameHistory() {
		List<MainGameImpl> sortedGameHistory = this.gameHistory;
		Collections.sort(sortedGameHistory, (v1, v2) -> v1.getDateTime().compareTo(v2.getDateTime()));
		return sortedGameHistory;
	}

	@Override
	public List<MainGameImpl> getSortedByScoreGameHistory() {
		return this.gameHistory.stream().sorted(Comparator.comparingDouble(MainGame::getCurrentScore)).collect(Collectors.toList());
	}

}
