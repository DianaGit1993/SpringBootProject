package org.example.Homework.Mocks.Example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestWebClientMockito {

    @Mock
    private ConnectionFactory factory;

    @Mock
    private InputStream mockStream;

    @Test
    public void testGetContentOk() throws Exception{

        when(factory.getData()).thenReturn(mockStream);
        when(mockStream.read()).thenReturn((int) 'W')
                .thenReturn((int)'o')
                .thenReturn((int)'r')
                .thenReturn((int)'k')
                .thenReturn((int)'s')
                .thenReturn((int)'!')
                .thenReturn(-1);


        WebClient client=new WebClient();
        String workingContent=client.getContent(factory);
        Assertions.assertEquals("Works!",workingContent);
    }

    @Test
    public void testGetContentCloseInputStream()throws Exception{
        when(factory.getData()).thenReturn(mockStream);
        when(mockStream.read()).thenReturn(-1);

        doThrow(new IOException("cannot close")).when(mockStream).close();

        WebClient client=new WebClient();
        String workingContent=client.getContent(factory);
        Assertions.assertNull(workingContent);
    }
}
