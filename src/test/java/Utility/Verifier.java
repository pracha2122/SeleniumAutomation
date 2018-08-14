package Utility;

import java.util.Arrays;
import java.util.Map;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import com.beust.jcommander.internal.Maps;

public  class Verifier  extends Assertion {
	
	
        private final Map<AssertionError, IAssert> m_errors = Maps.newLinkedHashMap();

        @Override
        protected void doAssert(IAssert a) {
            onBeforeAssert(a);
            try {
                a.doAssert();
                onAssertSuccess(a);
            } catch (AssertionError ex) {
                onAssertFailure(a);
                m_errors.put(ex, a);
            } finally {
                onAfterAssert(a);
            }
        }

        public void assertAll() {
            if (! m_errors.isEmpty()) {
                StringBuilder sb = new StringBuilder("The following asserts failed:");
                boolean first = true;
                for (Map.Entry<AssertionError, IAssert> ae : m_errors.entrySet()) {
                    if (first) {
                        first = false;
                    } else {
                        sb.append(",");
                    }
                    sb.append("\n\t");
                    sb.append(ae.getKey().getMessage());
                    sb.append("\nStack Trace :");
                    sb.append(Arrays.toString(ae.getKey().getStackTrace()).replaceAll(",", "\n"));
                }
                throw new AssertionError(sb.toString());
            }
        }
   

}
