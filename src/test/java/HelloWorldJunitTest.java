
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.munit.runner.functional.FunctionalMunitSuite;

    public class HelloWorldJunitTest extends FunctionalMunitSuite {

        static Logger logger = LogManager.getLogger(HelloWorldJunitTest.class);
        
        private Map<String, Object> payloadIn;
        
        @Before
        public void setUp() throws Exception {
            payloadIn = new HashMap<String, Object>(); 
        }

        @After
        public void tearDown() throws Exception {
        }
        
        
        // Following two methods must be overridden for APIKit apps to 
        // avoid message "Flow endpoint is null, APIKIT requires a listener ref in each of it's flows".
        @Override
        protected boolean haveToMockMuleConnectors() {
          return false;
        }
        
        @Override
        protected boolean haveToDisableInboundEndpoints() {
            return false;
        };
        
        @Test
        public void testHelloWorldSetPayload() throws Exception {
            String flowUnderTest = "hello-world-set-payload";
                
            Map<String, Object> payloadData = new HashMap<String, Object>();
            MuleEvent inputEvent = testEvent(payloadData);
                
            MuleEvent resultMuleEvent = runFlow(flowUnderTest, inputEvent);
            Object payload = resultMuleEvent.getMessage().getPayload();
                    
            assertNotNull(payload);
            assertTrue(payload instanceof String);
            assertEquals("Hello World!", (String)payload);
        }
}
