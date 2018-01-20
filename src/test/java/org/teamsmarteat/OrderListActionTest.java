package org.teamsmarteat;

import com.opensymphony.xwork2.Action;
import org.junit.Test;
import org.teamsmarteat.controller.OrderListAction;

import static junit.framework.TestCase.assertEquals;

public class OrderListActionTest {

    @Test
    public void testOrderListAction() throws Exception {
        OrderListAction action = new OrderListAction();
        String result = action.execute();
        assertEquals("noParameter", result);
    }
}
