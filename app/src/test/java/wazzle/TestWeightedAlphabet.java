/**
 * 
 */
package wazzle;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import wazzle.model.common.Dictionary;
import wazzle.model.common.DictionaryImpl;
import wazzle.model.maingame.Frequency;
import wazzle.model.maingame.FrequencyImpl;
import wazzle.model.maingame.WeightedAlphabet;
import wazzle.model.maingame.WeightedAlphabetImpl;

/**
 * @author A. Barbanti
 *
 */
public class TestWeightedAlphabet {
	Map<Character, Double> expectedTestMap = new HashMap<Character, Double>();

	@Before
	public void buildExpectedMap() {
		expectedTestMap.put('A', 0.3125);
		expectedTestMap.put('B', 0.25);
		expectedTestMap.put('C', 0.1875);
		expectedTestMap.put('D', 0.125);
		expectedTestMap.put('E', 0.0625);
		expectedTestMap.put('(', 0.0625);
	};

	@Test
	public void test() throws IOException {

		Dictionary dict = new DictionaryImpl(".\\src\\test\\res\\testDictionary.txt");
		Frequency freq = new FrequencyImpl(dict.getListOfWords());
		WeightedAlphabet wa = new WeightedAlphabetImpl(freq.getFrequency(), freq.getTotalLetters());
		assertEquals(expectedTestMap, wa.getWeightedAlphabet());

	}

}
