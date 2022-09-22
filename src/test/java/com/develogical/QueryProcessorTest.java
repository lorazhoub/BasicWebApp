package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutPotatoes() throws Exception {
	assertThat(queryProcessor.process("potato"), containsString("greatest"));
    }

    @Test
    public void knowsAboutName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("Potato"));
    }
    //which%20of%20the%20following%20numbers%20is%20the%20largest:%20249,%2085

    @Test
    public void knowsAboutLargest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 249, 85"), containsString("249"));
        assertThat(queryProcessor.process("which of the following numbers is the largest: 31, 509"), containsString("509"));
        //which%20of%20the%20following%20numbers%20is%20the%20largest:%20717,%2037
        assertThat(queryProcessor.process("which of the following numbers is the largest: 717, 37"), containsString("717"));
    }

    //what%20is%206%20plus%206
    @Test
    public void knowsAboutPlus() throws Exception {
        assertThat(queryProcessor.process("what is 6 plus 6"), containsString("12"));
        assertThat(queryProcessor.process("what is 12 plus 6"), containsString("18"));
    }
}
