package by.drivescape.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashingService {

    public String getHashString(String stringToEncrypt) {
        return BCrypt.hashpw(stringToEncrypt, BCrypt.gensalt(10));
    }

    public boolean isHashedString(String hashedString, String string) {
        return BCrypt.checkpw(hashedString, string);
    }

}
