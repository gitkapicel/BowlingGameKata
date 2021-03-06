package loadBalancerKata;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class loadBalancerKataTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void balancingAServer_noVms_serverStaysEmpty(){
		Server theServer = a(server().withCapacity(1));
		
		balance(aListOfServersWith(theServer), anEmptyListOfVms());
		
		assertThat(theServer, hasLoadPercentageOf(0.0d));
	}


	private Matcher<? super Server> hasLoadPercentageOf(double expectedLoadPercentage) {
		return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
	}


	private void balance(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}


	private Vm[] anEmptyListOfVms() {
		return new Vm[0];
	}


	private Server[] aListOfServersWith(Server server) {
		return new Server[]{server};
	}


	private Server a(ServerBuilder builder) {
		return builder.build();
	}


	private ServerBuilder server() {
		return new ServerBuilder();
	}
}