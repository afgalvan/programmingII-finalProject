package test.models;

import app.models.Rowable;
import app.models.documents.Document;
import app.models.metadata.ProcessMetadata;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RowableTest {

    private Rowable metadata;
    private Rowable document;

    @Before
    public void setUp() {
        this.metadata = new ProcessMetadata();
        this.document = new Document();
    }

    @Test
    public void getMetadataRowOfNull() {
        Assert.assertNotNull(metadata.getAsRow());
        Assert.assertFalse(metadata.getAsRow().contains(null));
    }

    @Test
    public void getDocumentRowOfNull() {
        Assert.assertNotNull(document.getAsRow());
        Assert.assertFalse(document.getAsRow().contains(null));
    }
}
