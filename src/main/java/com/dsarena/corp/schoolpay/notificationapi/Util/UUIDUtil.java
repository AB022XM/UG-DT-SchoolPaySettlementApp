package com.dsarena.corp.schoolpay.notificationapi.Util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class UUIDUtil {

    /**
     * Returns a name-based UUID v3 using a namespace.
     *
     * @param namespace a UUID
     * @param name      a string
     * @return a UUID
     */
    public static UUID getNameBased(UUID namespace, String name) {
        // 1. Get NAMESPACE and NAME bytes
        final byte[] msb = toBytes(namespace.getMostSignificantBits());
        final byte[] lsb = toBytes(namespace.getLeastSignificantBits());
        final byte[] nam = name.getBytes(StandardCharsets.UTF_8);

        // 2. Concatenate NAMESPACE and NAME bytes
        final byte[] bytes = new byte[16 + nam.length];
        System.arraycopy(msb, 0, bytes, 0, 8);
        System.arraycopy(lsb, 0, bytes, 8, 8);
        System.arraycopy(nam, 0, bytes, 16, nam.length);

        // 3. Generate a name-based UUID
        return UUID.nameUUIDFromBytes(bytes);
    }

    private static byte[] toBytes(final long number) {
        return new byte[] {
            (byte) (number >>> 56),
            (byte) (number >>> 48),
            (byte) (number >>> 40),
            (byte) (number >>> 32),
            (byte) (number >>> 24),
            (byte) (number >>> 16),
            (byte) (number >>> 8),
            (byte) (number),
        };
    }

    public static String generationUUID(String recordIdplusstudentCodePlusAmountpusTransactionId) {
        UUID namespace = UUID.fromString("11111111-2222-3333-4444-555555555555");

        UUID uuid = getNameBased(namespace, recordIdplusstudentCodePlusAmountpusTransactionId);
        System.out.println(uuid);
        return uuid.toString();
    }
}
