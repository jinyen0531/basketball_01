package com.yenyu.basketball_01;

import org.junit.Test;

import static com.yenyu.basketball_01.RecordAction.Action_2point_in;
import static com.yenyu.basketball_01.RecordAction.Action_player1;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        recordDAO dao = new recordDAO();
        dao.add(new RecordAction(101,1));
        assertEquals(Action_2point_in, dao.get_record().get(0).actionButton);
    }
    @Test
    public void addition_isCorrect2() throws Exception {
        recordDAO dao = new recordDAO();
        dao.add(new RecordAction(101,1));
        assertEquals(Action_player1, dao.get_record().get(0).player);
    }
}