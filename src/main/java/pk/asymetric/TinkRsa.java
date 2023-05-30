package pk.asymetric;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.mac.MacFactory;
import com.google.crypto.tink.mac.MacKeyTemplates;
import com.google.crypto.tink.subtle.Hex;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
public class TinkRsa {

    public TinkRsa() throws GeneralSecurityException {
        MacConfig.register();
        TinkConfig.register();
        AeadConfig.register();

    }

    public String encrypt(String input) throws Exception {
        KeysetHandle key = KeysetHandle.generateNew(MacKeyTemplates.HMAC_SHA256_128BITTAG);
        Mac sha256Mac = MacFactory.getPrimitive(key);
        return Hex.encode(sha256Mac.computeMac(input.getBytes(StandardCharsets.UTF_8)));
    }
}
