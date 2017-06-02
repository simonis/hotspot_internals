package org.simonis;

public class NullCheck {

    public static void swapField_1(NullCheck n1, NullCheck n2) {
        long tmp = n1.l0001;
        n1.l0001 = n2.l0001;
        n2.l0001 = tmp;
    }

    public static void swapField_2(NullCheck n1, NullCheck n2) {
        long tmp = n1.l0512;
        n1.l0512 = n2.l0512;
        n2.l0512 = tmp;
    }

    static void prompt(String msg) {
        System.out.println("==========================================");
        System.out.println(msg);
        System.out.println("==========================================");
        System.console().readLine();
    }
    public static void main(String[] args) {

        NullCheck n = new NullCheck();

        if ("swapField_1".equals(args[0])) {

            prompt("Calling swapField_1() to JIT-compile it:");
            for (int i = 0; i < 20_000; i++) {
                swapField_1(n, n);
            }
            for (int i = 1; i <= 5; i++) {
                prompt(i + ": calling swapField_1() with a NULL argument:");
                try {
                    swapField_1(null, n);
                } catch (NullPointerException npe) { npe.printStackTrace(System.out); }
            }
            prompt("Calling swapField_1() to JIT-compile it again:");
            for (int i = 0; i < 20_000; i++) {
                swapField_1(n, n);
            }
        }
        if ("swapField_2".equals(args[0])) {
            prompt("Calling swapField_2() to JIT-compile it:");
            for (int i = 0; i < 20_000; i++) {
                swapField_2(n, n);
            }
            prompt("Calling swapField_2() with a NULL argument:");
            try {
                swapField_2(null, n);
            } catch (NullPointerException npe) { npe.printStackTrace(System.out); }
        }
    }

    long l0000, l0001, l0002, l0003, l0004, l0005, l0006, l0007, l0008, l0009;
    long l0010, l0011, l0012, l0013, l0014, l0015, l0016, l0017, l0018, l0019;
    long l0020, l0021, l0022, l0023, l0024, l0025, l0026, l0027, l0028, l0029;
    long l0030, l0031, l0032, l0033, l0034, l0035, l0036, l0037, l0038, l0039;
    long l0040, l0041, l0042, l0043, l0044, l0045, l0046, l0047, l0048, l0049;
    long l0050, l0051, l0052, l0053, l0054, l0055, l0056, l0057, l0058, l0059;
    long l0060, l0061, l0062, l0063, l0064, l0065, l0066, l0067, l0068, l0069;
    long l0070, l0071, l0072, l0073, l0074, l0075, l0076, l0077, l0078, l0079;
    long l0080, l0081, l0082, l0083, l0084, l0085, l0086, l0087, l0088, l0089;
    long l0090, l0091, l0092, l0093, l0094, l0095, l0096, l0097, l0098, l0099;
    long l0100, l0101, l0102, l0103, l0104, l0105, l0106, l0107, l0108, l0109;
    long l0110, l0111, l0112, l0113, l0114, l0115, l0116, l0117, l0118, l0119;
    long l0120, l0121, l0122, l0123, l0124, l0125, l0126, l0127, l0128, l0129;
    long l0130, l0131, l0132, l0133, l0134, l0135, l0136, l0137, l0138, l0139;
    long l0140, l0141, l0142, l0143, l0144, l0145, l0146, l0147, l0148, l0149;
    long l0150, l0151, l0152, l0153, l0154, l0155, l0156, l0157, l0158, l0159;
    long l0160, l0161, l0162, l0163, l0164, l0165, l0166, l0167, l0168, l0169;
    long l0170, l0171, l0172, l0173, l0174, l0175, l0176, l0177, l0178, l0179;
    long l0180, l0181, l0182, l0183, l0184, l0185, l0186, l0187, l0188, l0189;
    long l0190, l0191, l0192, l0193, l0194, l0195, l0196, l0197, l0198, l0199;
    long l0200, l0201, l0202, l0203, l0204, l0205, l0206, l0207, l0208, l0209;
    long l0210, l0211, l0212, l0213, l0214, l0215, l0216, l0217, l0218, l0219;
    long l0220, l0221, l0222, l0223, l0224, l0225, l0226, l0227, l0228, l0229;
    long l0230, l0231, l0232, l0233, l0234, l0235, l0236, l0237, l0238, l0239;
    long l0240, l0241, l0242, l0243, l0244, l0245, l0246, l0247, l0248, l0249;
    long l0250, l0251, l0252, l0253, l0254, l0255, l0256, l0257, l0258, l0259;
    long l0260, l0261, l0262, l0263, l0264, l0265, l0266, l0267, l0268, l0269;
    long l0270, l0271, l0272, l0273, l0274, l0275, l0276, l0277, l0278, l0279;
    long l0280, l0281, l0282, l0283, l0284, l0285, l0286, l0287, l0288, l0289;
    long l0290, l0291, l0292, l0293, l0294, l0295, l0296, l0297, l0298, l0299;
    long l0300, l0301, l0302, l0303, l0304, l0305, l0306, l0307, l0308, l0309;
    long l0310, l0311, l0312, l0313, l0314, l0315, l0316, l0317, l0318, l0319;
    long l0320, l0321, l0322, l0323, l0324, l0325, l0326, l0327, l0328, l0329;
    long l0330, l0331, l0332, l0333, l0334, l0335, l0336, l0337, l0338, l0339;
    long l0340, l0341, l0342, l0343, l0344, l0345, l0346, l0347, l0348, l0349;
    long l0350, l0351, l0352, l0353, l0354, l0355, l0356, l0357, l0358, l0359;
    long l0360, l0361, l0362, l0363, l0364, l0365, l0366, l0367, l0368, l0369;
    long l0370, l0371, l0372, l0373, l0374, l0375, l0376, l0377, l0378, l0379;
    long l0380, l0381, l0382, l0383, l0384, l0385, l0386, l0387, l0388, l0389;
    long l0390, l0391, l0392, l0393, l0394, l0395, l0396, l0397, l0398, l0399;
    long l0400, l0401, l0402, l0403, l0404, l0405, l0406, l0407, l0408, l0409;
    long l0410, l0411, l0412, l0413, l0414, l0415, l0416, l0417, l0418, l0419;
    long l0420, l0421, l0422, l0423, l0424, l0425, l0426, l0427, l0428, l0429;
    long l0430, l0431, l0432, l0433, l0434, l0435, l0436, l0437, l0438, l0439;
    long l0440, l0441, l0442, l0443, l0444, l0445, l0446, l0447, l0448, l0449;
    long l0450, l0451, l0452, l0453, l0454, l0455, l0456, l0457, l0458, l0459;
    long l0460, l0461, l0462, l0463, l0464, l0465, l0466, l0467, l0468, l0469;
    long l0470, l0471, l0472, l0473, l0474, l0475, l0476, l0477, l0478, l0479;
    long l0480, l0481, l0482, l0483, l0484, l0485, l0486, l0487, l0488, l0489;
    long l0490, l0491, l0492, l0493, l0494, l0495, l0496, l0497, l0498, l0499;
    long l0500, l0501, l0502, l0503, l0504, l0505, l0506, l0507, l0508, l0509;
    long l0510, l0511, l0512, l0513, l0514, l0515, l0516, l0517, l0518, l0519;
}
