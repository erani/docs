package aermicioi.spring.fileReadingMessageSource.case0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.DefaultDirectoryScanner;
import org.springframework.integration.file.DirectoryScanner;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.AcceptAllFileListFilter;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.test.context.SpringIntegrationTest;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class DirectoryScannerExampleTest {

    private static final Path scanDirectory = Paths.get("scanning-dir-1");

    private static final BlockingDeque<File> deque = new LinkedBlockingDeque<>();

    @Configuration
    @EnableIntegration
    static class TestConfiguration {
        @Bean
        FileReadingMessageSource fileReadingMessageSource() {
            final DirectoryScanner scanner = new DefaultDirectoryScanner();
            scanner.setFilter(new AcceptAllFileListFilter<>());

            final FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
            fileReadingMessageSource.setDirectory(scanDirectory.toFile());
            fileReadingMessageSource.setScanner(scanner);

            return fileReadingMessageSource;
        }

        @Bean
        IntegrationFlow createFlow(final FileReadingMessageSource fileReadingMessageSource) {
            return IntegrationFlows.from(fileReadingMessageSource, config -> config.poller(Pollers.fixedRate(1, TimeUnit.SECONDS)))
                    .handle((message) -> deque.add((File)message.getPayload()))
                    .get();
        }
    }

    @Test
    void test() throws IOException {
        try {
//            Files.createDirectory(scanDirectory); // Looks like the directory is being created by Scanner
            Files.createFile(scanDirectory.resolve("file-1.log"));
            final File file = deque.pollFirst(30, TimeUnit.SECONDS);
            Assertions.assertEquals(file.getName(), "file-1.log");
        } catch (final Exception e) {
            Assertions.fail();
        } finally {
            if (Files.exists(scanDirectory)) {
                FileSystemUtils.deleteRecursively(scanDirectory);
            }
        }

    }

}
