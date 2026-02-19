package mockitoLearning;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserNotifyTest {
	@Mock
	NotificationService uns;
	
	@InjectMocks
	UserNotify userns;
	
	@Test
	void shouldSendWelcomeNotification() {
		//stub void method ( do nothing is default,)
		doNothing().when(uns).sendNotification(anyString());
		
		userns.registerUser("Lakshmi");
		
		verify(uns,times(1)).sendNotification("Welcome Lakshmi");
	}
}
