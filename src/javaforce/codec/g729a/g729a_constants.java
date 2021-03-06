/* g729a_constants - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package javaforce.codec.g729a;

interface g729a_constants extends Constants {

  public static final int SPEECH_EXCITATION_OFFSET = 154;
  public static final int SPEECH_WEIGHTED_OFFSET = 144;
  public static final int SPEECH_RESIDUAL_OFFSET = 144;
  public static final int SUBFRAME_SIZE = 40;
  public static final int NUM_LP_COEF = 10;
  public static final int NUM_EVAL_POINT = 51;
  public static final int NUM_SWITCH_MA = 2;
  public static final int L1_ENTRY = 128;
  public static final int L2_ENTRY = 32;
  public static final int L3_ENTRY = 32;
  public static final int NCODE1 = 8;
  public static final int NCODE2 = 16;
  public static final int TILT_SIZE = 22;
  public static final int NOT_PERIODIC = 0;
  public static final int PERIODIC = 1;
  public static final float J_12 = 0.0012207031F;
  public static final float J_6 = 6.1035156E-4F;
  public static final float MIN_OMEGA = 0.0050F;
  public static final float MIN_DIST_OMEGA = 0.0391F;
  public static final float MAX_OMEGA = 3.135F;
  public static final float MA_COEF0 = 0.68F;
  public static final float MA_COEF1 = 0.58F;
  public static final float MA_COEF2 = 0.34F;
  public static final float MA_COEF3 = 0.19F;
  public static final float PI = 3.1415927F;
  public static final float EPS = 3.0517578E-5F;
  public static final float E_MEAN = 31.622776F;
  public static final float MIN_GP = 0.0F;
  public static final float MAX_GP = 1.2000122F;
  public static final float PAST_GP_MIN = 0.2000122F;
  public static final float PAST_GP_MAX = 0.7944946F;
  public static final int INTER10 = 10;
  public static final int STEP = 5;
  public static final int NB_POS = 8;
  public static final int MSIZE = 64;
  public static final int DIM_RR = 616;
  public static final float PRE_A0 = 0.46363717F;
  public static final float PRE_A1 = -0.92724705F;
  public static final float PRE_A2 = 0.46363717F;
  public static final float PRE_B1 = 1.9059465F;
  public static final float PRE_B2 = -0.9114024F;
  public static final float POST_A0 = 123182.23F;
  public static final float POST_A1 = -246360.75F;
  public static final float POST_A2 = 123182.23F;
  public static final float POST_B1 = 1.9330735F;
  public static final float POST_B2 = -0.93579197F;
  public static final float GAMMA1 = 0.75F;
  public static final float GAMMA2 = 0.5625F;
  public static final float GAMMA3 = 0.421875F;
  public static final float GAMMA4 = 0.31640625F;
  public static final float GAMMA5 = 0.23730469F;
  public static final float GAMMA6 = 0.17797852F;
  public static final float GAMMA7 = 0.13348389F;
  public static final float GAMMA8 = 0.100112915F;
  public static final float GAMMA9 = 0.07508469F;
  public static final float GAMMA10 = 0.056313515F;
  public static final float GAMMA_PWF1 = 0.75F;
  public static final float GAMMA_PWF2 = 0.5625F;
  public static final float GAMMA_PWF3 = 0.421875F;
  public static final float GAMMA_PWF4 = 0.31640625F;
  public static final float GAMMA_PWF5 = 0.23730469F;
  public static final float GAMMA_PWF6 = 0.17797852F;
  public static final float GAMMA_PWF7 = 0.13348389F;
  public static final float GAMMA_PWF8 = 0.100112915F;
  public static final float GAMMA_PWF9 = 0.07508469F;
  public static final float GAMMA_PWF10 = 0.056313515F;
  public static final float GAMMA2_PWF = 0.7F;
  public static final float GAMMA_N1 = 0.55F;
  public static final float GAMMA_N2 = 0.3025F;
  public static final float GAMMA_N3 = 0.16637501F;
  public static final float GAMMA_N4 = 0.09150626F;
  public static final float GAMMA_N5 = 0.05032844F;
  public static final float GAMMA_N6 = 0.027680643F;
  public static final float GAMMA_N7 = 0.015224354F;
  public static final float GAMMA_N8 = 0.008373395F;
  public static final float GAMMA_N9 = 0.0046053673F;
  public static final float GAMMA_N10 = 0.002532952F;
  public static final float GAMMA_D1 = 0.7F;
  public static final float GAMMA_D2 = 0.48999998F;
  public static final float GAMMA_D3 = 0.343F;
  public static final float GAMMA_D4 = 0.2401F;
  public static final float GAMMA_D5 = 0.16806999F;
  public static final float GAMMA_D6 = 0.11764899F;
  public static final float GAMMA_D7 = 0.08235429F;
  public static final float GAMMA_D8 = 0.057648003F;
  public static final float GAMMA_D9 = 0.0403536F;
  public static final float GAMMA_D10 = 0.02824752F;
  public static final float GAMMA_P = 0.5F;
  public static final float GAMMA_T = 0.8F;
  public static final float GAIN_C1 = 0.1F;
  public static final float GAIN_C2 = 0.9F;
  public static final float GPCLIP = 0.9499512F;
  public static final float GPCLIP2 = 0.9394531F;
  public static final float GP0999 = 0.99993896F;
  public static final int THRESH_ERR = 60000;
  public static final float COEF0 = 31.134575F;
  public static final float COEF1 = 1.612322F;
  public static final float COEF2 = 0.481389F;
  public static final float COEF3 = 0.053056F;
  public static final float INV_COEF = 0.032621384F;
}