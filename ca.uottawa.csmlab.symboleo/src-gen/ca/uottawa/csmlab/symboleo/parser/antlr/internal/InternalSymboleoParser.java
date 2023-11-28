package ca.uottawa.csmlab.symboleo.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ca.uottawa.csmlab.symboleo.services.SymboleoGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSymboleoParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Domain'", "';'", "'endDomain'", "'TimeGranularity'", "'is'", "'Contract'", "'('", "','", "')'", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'Surviving'", "'Powers'", "'Constraints'", "'endContract'", "'isA'", "'isAn'", "'Enumeration'", "'with'", "':'", "'Number'", "'String'", "'Date'", "'Boolean'", "'Asset'", "'Event'", "'Role'", "'Env'", "':='", "'.'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'not'", "'true'", "'false'", "'Math.pow'", "'Math.abs'", "'Math.floor'", "'Math.cbrt'", "'Math.ceil'", "'Math.exp'", "'Math.sign'", "'Math.sqrt'", "'String.substring'", "'String.replaceAll'", "'String.concat'", "'String.toLowerCase'", "'String.toUpperCase'", "'String.trimEnd'", "'String.trimStart'", "'String.trim'", "'Date.add'", "'->'", "'O'", "'Obligation'", "'P'", "'Power'", "'Suspended'", "'obligations.'", "'Resumed'", "'Discharged'", "'Terminated'", "'Triggered'", "'self'", "'Happens'", "'WhappensBefore'", "'ShappensBefore'", "'HappensWithin'", "'WhappensBeforeE'", "'ShappensBeforeE'", "'HappensAfter'", "'Occurs'", "'HappensAssign'", "'Assign'", "'IsEqual'", "'IsOwner'", "'CannotBeAssigned'", "'powers.'", "'Activated'", "'Exerted'", "'Expired'", "'Fulfilled'", "'Violated'", "'FulfilledObligations'", "'RevokedParty'", "'AssignedParty'", "'Rescinded'", "'seconds'", "'minutes'", "'hours'", "'days'", "'weeks'", "'months'", "'years'", "'Interval'", "'Create'", "'UnsuccessfulTermination'", "'Active'", "'InEffect'", "'Suspension'", "'SuccessfulTermination'", "'Discharge'", "'Violation'", "'Fulfillment'", "'Form'", "'UnAssign'", "'Rescission'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSymboleoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSymboleoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSymboleoParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSymboleo.g"; }



     	private SymboleoGrammarAccess grammarAccess;

        public InternalSymboleoParser(TokenStream input, SymboleoGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SymboleoGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSymboleo.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSymboleo.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSymboleo.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSymboleo.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )? otherlv_37= 'endContract' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domainName_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_contractName_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        EObject lv_domainTypes_2_0 = null;

        AntlrDatatypeRuleToken lv_timeUnits_7_0 = null;

        EObject lv_parameters_11_0 = null;

        EObject lv_parameters_13_0 = null;

        EObject lv_variables_16_0 = null;

        EObject lv_preconditions_19_0 = null;

        EObject lv_postconditions_22_0 = null;

        EObject lv_obligations_25_0 = null;

        EObject lv_survivingObligations_29_0 = null;

        EObject lv_powers_32_0 = null;

        EObject lv_constraints_35_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:77:2: ( (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )? otherlv_37= 'endContract' ) )
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )? otherlv_37= 'endContract' )
            {
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )? otherlv_37= 'endContract' )
            // InternalSymboleo.g:79:3: otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )? otherlv_37= 'endContract'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDomainKeyword_0());
            		
            // InternalSymboleo.g:83:3: ( (lv_domainName_1_0= RULE_ID ) )
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            {
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            // InternalSymboleo.g:85:5: lv_domainName_1_0= RULE_ID
            {
            lv_domainName_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_domainName_1_0, grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSymboleo.g:101:3: ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSymboleo.g:102:4: ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';'
            	    {
            	    // InternalSymboleo.g:102:4: ( (lv_domainTypes_2_0= ruleDomainType ) )
            	    // InternalSymboleo.g:103:5: (lv_domainTypes_2_0= ruleDomainType )
            	    {
            	    // InternalSymboleo.g:103:5: (lv_domainTypes_2_0= ruleDomainType )
            	    // InternalSymboleo.g:104:6: lv_domainTypes_2_0= ruleDomainType
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getDomainTypesDomainTypeParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_domainTypes_2_0=ruleDomainType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"domainTypes",
            	    							lv_domainTypes_2_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.DomainType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModelAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getEndDomainKeyword_3());
            		
            // InternalSymboleo.g:130:3: (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSymboleo.g:131:4: otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getModelAccess().getTimeGranularityKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getIsKeyword_4_1());
                    			
                    // InternalSymboleo.g:139:4: ( (lv_timeUnits_7_0= ruleTimeUnit ) )
                    // InternalSymboleo.g:140:5: (lv_timeUnits_7_0= ruleTimeUnit )
                    {
                    // InternalSymboleo.g:140:5: (lv_timeUnits_7_0= ruleTimeUnit )
                    // InternalSymboleo.g:141:6: lv_timeUnits_7_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getTimeUnitsTimeUnitParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_timeUnits_7_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"timeUnits",
                    							lv_timeUnits_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getModelAccess().getContractKeyword_5());
            		
            // InternalSymboleo.g:163:3: ( (lv_contractName_9_0= RULE_ID ) )
            // InternalSymboleo.g:164:4: (lv_contractName_9_0= RULE_ID )
            {
            // InternalSymboleo.g:164:4: (lv_contractName_9_0= RULE_ID )
            // InternalSymboleo.g:165:5: lv_contractName_9_0= RULE_ID
            {
            lv_contractName_9_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_contractName_9_0, grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_9_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getModelAccess().getLeftParenthesisKeyword_7());
            		
            // InternalSymboleo.g:185:3: ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalSymboleo.g:186:4: ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ','
            	    {
            	    // InternalSymboleo.g:186:4: ( (lv_parameters_11_0= ruleParameter ) )
            	    // InternalSymboleo.g:187:5: (lv_parameters_11_0= ruleParameter )
            	    {
            	    // InternalSymboleo.g:187:5: (lv_parameters_11_0= ruleParameter )
            	    // InternalSymboleo.g:188:6: lv_parameters_11_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_parameters_11_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_11_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_12=(Token)match(input,18,FOLLOW_3); 

            	    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getCommaKeyword_8_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // InternalSymboleo.g:210:3: ( (lv_parameters_13_0= ruleParameter ) )
            // InternalSymboleo.g:211:4: (lv_parameters_13_0= ruleParameter )
            {
            // InternalSymboleo.g:211:4: (lv_parameters_13_0= ruleParameter )
            // InternalSymboleo.g:212:5: lv_parameters_13_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_12);
            lv_parameters_13_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"parameters",
            						lv_parameters_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_14, grammarAccess.getModelAccess().getRightParenthesisKeyword_10());
            		
            // InternalSymboleo.g:233:3: (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSymboleo.g:234:4: otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )*
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getDeclarationsKeyword_11_0());
                    			
                    // InternalSymboleo.g:238:4: ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSymboleo.g:239:5: ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';'
                    	    {
                    	    // InternalSymboleo.g:239:5: ( (lv_variables_16_0= ruleVariable ) )
                    	    // InternalSymboleo.g:240:6: (lv_variables_16_0= ruleVariable )
                    	    {
                    	    // InternalSymboleo.g:240:6: (lv_variables_16_0= ruleVariable )
                    	    // InternalSymboleo.g:241:7: lv_variables_16_0= ruleVariable
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_11_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_variables_16_0=ruleVariable();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"variables",
                    	    								lv_variables_16_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Variable");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,12,FOLLOW_14); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:264:3: (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSymboleo.g:265:4: otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_15); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getPreconditionsKeyword_12_0());
                    			
                    // InternalSymboleo.g:269:4: ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==17||LA6_0==35||(LA6_0>=55 && LA6_0<=57)||(LA6_0>=87 && LA6_0<=99)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSymboleo.g:270:5: ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';'
                    	    {
                    	    // InternalSymboleo.g:270:5: ( (lv_preconditions_19_0= ruleProposition ) )
                    	    // InternalSymboleo.g:271:6: (lv_preconditions_19_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:271:6: (lv_preconditions_19_0= ruleProposition )
                    	    // InternalSymboleo.g:272:7: lv_preconditions_19_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_12_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_preconditions_19_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"preconditions",
                    	    								lv_preconditions_19_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_20=(Token)match(input,12,FOLLOW_15); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:295:3: (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSymboleo.g:296:4: otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )*
                    {
                    otherlv_21=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_21, grammarAccess.getModelAccess().getPostconditionsKeyword_13_0());
                    			
                    // InternalSymboleo.g:300:4: ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)||LA8_0==17||LA8_0==35||(LA8_0>=55 && LA8_0<=57)||(LA8_0>=87 && LA8_0<=99)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSymboleo.g:301:5: ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';'
                    	    {
                    	    // InternalSymboleo.g:301:5: ( (lv_postconditions_22_0= ruleProposition ) )
                    	    // InternalSymboleo.g:302:6: (lv_postconditions_22_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:302:6: (lv_postconditions_22_0= ruleProposition )
                    	    // InternalSymboleo.g:303:7: lv_postconditions_22_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_13_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_postconditions_22_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"postconditions",
                    	    								lv_postconditions_22_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_23=(Token)match(input,12,FOLLOW_16); 

                    	    					newLeafNode(otherlv_23, grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:326:3: (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSymboleo.g:327:4: otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
            	    {
            	    otherlv_24=(Token)match(input,23,FOLLOW_17); 

            	    				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getObligationsKeyword_14_0());
            	    			
            	    // InternalSymboleo.g:331:4: ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==RULE_ID) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalSymboleo.g:332:5: ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';'
            	    	    {
            	    	    // InternalSymboleo.g:332:5: ( (lv_obligations_25_0= ruleObligation ) )
            	    	    // InternalSymboleo.g:333:6: (lv_obligations_25_0= ruleObligation )
            	    	    {
            	    	    // InternalSymboleo.g:333:6: (lv_obligations_25_0= ruleObligation )
            	    	    // InternalSymboleo.g:334:7: lv_obligations_25_0= ruleObligation
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_14_1_0_0());
            	    	    						
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_obligations_25_0=ruleObligation();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"obligations",
            	    	    								lv_obligations_25_0,
            	    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Obligation");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }

            	    	    otherlv_26=(Token)match(input,12,FOLLOW_17); 

            	    	    					newLeafNode(otherlv_26, grammarAccess.getModelAccess().getSemicolonKeyword_14_1_1());
            	    	    				

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // InternalSymboleo.g:357:3: (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSymboleo.g:358:4: otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )*
                    {
                    otherlv_27=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_27, grammarAccess.getModelAccess().getSurvivingKeyword_15_0());
                    			
                    otherlv_28=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_28, grammarAccess.getModelAccess().getObligationsKeyword_15_1());
                    			
                    // InternalSymboleo.g:366:4: ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSymboleo.g:367:5: ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';'
                    	    {
                    	    // InternalSymboleo.g:367:5: ( (lv_survivingObligations_29_0= ruleObligation ) )
                    	    // InternalSymboleo.g:368:6: (lv_survivingObligations_29_0= ruleObligation )
                    	    {
                    	    // InternalSymboleo.g:368:6: (lv_survivingObligations_29_0= ruleObligation )
                    	    // InternalSymboleo.g:369:7: lv_survivingObligations_29_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSurvivingObligationsObligationParserRuleCall_15_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_survivingObligations_29_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"survivingObligations",
                    	    								lv_survivingObligations_29_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_30=(Token)match(input,12,FOLLOW_19); 

                    	    					newLeafNode(otherlv_30, grammarAccess.getModelAccess().getSemicolonKeyword_15_2_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:392:3: (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSymboleo.g:393:4: otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )*
                    {
                    otherlv_31=(Token)match(input,25,FOLLOW_20); 

                    				newLeafNode(otherlv_31, grammarAccess.getModelAccess().getPowersKeyword_16_0());
                    			
                    // InternalSymboleo.g:397:4: ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalSymboleo.g:398:5: ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';'
                    	    {
                    	    // InternalSymboleo.g:398:5: ( (lv_powers_32_0= rulePower ) )
                    	    // InternalSymboleo.g:399:6: (lv_powers_32_0= rulePower )
                    	    {
                    	    // InternalSymboleo.g:399:6: (lv_powers_32_0= rulePower )
                    	    // InternalSymboleo.g:400:7: lv_powers_32_0= rulePower
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_16_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_powers_32_0=rulePower();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"powers",
                    	    								lv_powers_32_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Power");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_33=(Token)match(input,12,FOLLOW_20); 

                    	    					newLeafNode(otherlv_33, grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:423:3: (otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSymboleo.g:424:4: otherlv_34= 'Constraints' ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )*
                    {
                    otherlv_34=(Token)match(input,26,FOLLOW_21); 

                    				newLeafNode(otherlv_34, grammarAccess.getModelAccess().getConstraintsKeyword_17_0());
                    			
                    // InternalSymboleo.g:428:4: ( ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_STRING)||LA16_0==17||LA16_0==35||(LA16_0>=55 && LA16_0<=57)||(LA16_0>=87 && LA16_0<=99)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSymboleo.g:429:5: ( (lv_constraints_35_0= ruleProposition ) ) otherlv_36= ';'
                    	    {
                    	    // InternalSymboleo.g:429:5: ( (lv_constraints_35_0= ruleProposition ) )
                    	    // InternalSymboleo.g:430:6: (lv_constraints_35_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:430:6: (lv_constraints_35_0= ruleProposition )
                    	    // InternalSymboleo.g:431:7: lv_constraints_35_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_17_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_constraints_35_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"constraints",
                    	    								lv_constraints_35_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_36=(Token)match(input,12,FOLLOW_21); 

                    	    					newLeafNode(otherlv_36, grammarAccess.getModelAccess().getSemicolonKeyword_17_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_37=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_37, grammarAccess.getModelAccess().getEndContractKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainType"
    // InternalSymboleo.g:462:1: entryRuleDomainType returns [EObject current=null] : iv_ruleDomainType= ruleDomainType EOF ;
    public final EObject entryRuleDomainType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainType = null;


        try {
            // InternalSymboleo.g:462:51: (iv_ruleDomainType= ruleDomainType EOF )
            // InternalSymboleo.g:463:2: iv_ruleDomainType= ruleDomainType EOF
            {
             newCompositeNode(grammarAccess.getDomainTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainType=ruleDomainType();

            state._fsp--;

             current =iv_ruleDomainType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainType"


    // $ANTLR start "ruleDomainType"
    // InternalSymboleo.g:469:1: ruleDomainType returns [EObject current=null] : (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleDomainType() throws RecognitionException {
        EObject current = null;

        EObject this_Alias_0 = null;

        EObject this_RegularType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:475:2: ( (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration ) )
            // InternalSymboleo.g:476:2: (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalSymboleo.g:476:2: (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==28) ) {
                    int LA18_2 = input.LA(3);

                    if ( ((LA18_2>=33 && LA18_2<=36)) ) {
                        alt18=1;
                    }
                    else if ( (LA18_2==RULE_ID||LA18_2==16||(LA18_2>=37 && LA18_2<=39)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA18_1==29) ) {
                    int LA18_3 = input.LA(3);

                    if ( (LA18_3==30) ) {
                        alt18=3;
                    }
                    else if ( (LA18_3==RULE_ID||LA18_3==16||(LA18_3>=37 && LA18_3<=39)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSymboleo.g:477:3: this_Alias_0= ruleAlias
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getAliasParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Alias_0=ruleAlias();

                    state._fsp--;


                    			current = this_Alias_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:486:3: this_RegularType_1= ruleRegularType
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getRegularTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegularType_1=ruleRegularType();

                    state._fsp--;


                    			current = this_RegularType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:495:3: this_Enumeration_2= ruleEnumeration
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getEnumerationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Enumeration_2=ruleEnumeration();

                    state._fsp--;


                    			current = this_Enumeration_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainType"


    // $ANTLR start "entryRuleAlias"
    // InternalSymboleo.g:507:1: entryRuleAlias returns [EObject current=null] : iv_ruleAlias= ruleAlias EOF ;
    public final EObject entryRuleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlias = null;


        try {
            // InternalSymboleo.g:507:46: (iv_ruleAlias= ruleAlias EOF )
            // InternalSymboleo.g:508:2: iv_ruleAlias= ruleAlias EOF
            {
             newCompositeNode(grammarAccess.getAliasRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlias=ruleAlias();

            state._fsp--;

             current =iv_ruleAlias; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlias"


    // $ANTLR start "ruleAlias"
    // InternalSymboleo.g:514:1: ruleAlias returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) ) ;
    public final EObject ruleAlias() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:520:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) ) )
            // InternalSymboleo.g:521:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) )
            {
            // InternalSymboleo.g:521:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) )
            // InternalSymboleo.g:522:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) )
            {
            // InternalSymboleo.g:522:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:523:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:523:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:524:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAliasAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAliasRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getAliasAccess().getIsAKeyword_1());
            		
            // InternalSymboleo.g:544:3: ( (lv_type_2_0= ruleBaseType ) )
            // InternalSymboleo.g:545:4: (lv_type_2_0= ruleBaseType )
            {
            // InternalSymboleo.g:545:4: (lv_type_2_0= ruleBaseType )
            // InternalSymboleo.g:546:5: lv_type_2_0= ruleBaseType
            {

            					newCompositeNode(grammarAccess.getAliasAccess().getTypeBaseTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleBaseType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAliasRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlias"


    // $ANTLR start "entryRuleEnumeration"
    // InternalSymboleo.g:567:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalSymboleo.g:567:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalSymboleo.g:568:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalSymboleo.g:574:1: ruleEnumeration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_enumerationItems_4_0 = null;

        EObject lv_enumerationItems_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:580:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' ) )
            // InternalSymboleo.g:581:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' )
            {
            // InternalSymboleo.g:581:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' )
            // InternalSymboleo.g:582:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')'
            {
            // InternalSymboleo.g:582:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:583:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:583:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:584:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getIsAnKeyword_1());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getEnumerationKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSymboleo.g:612:3: ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==18) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // InternalSymboleo.g:613:4: ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ','
            	    {
            	    // InternalSymboleo.g:613:4: ( (lv_enumerationItems_4_0= ruleEnumItem ) )
            	    // InternalSymboleo.g:614:5: (lv_enumerationItems_4_0= ruleEnumItem )
            	    {
            	    // InternalSymboleo.g:614:5: (lv_enumerationItems_4_0= ruleEnumItem )
            	    // InternalSymboleo.g:615:6: lv_enumerationItems_4_0= ruleEnumItem
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_enumerationItems_4_0=ruleEnumItem();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"enumerationItems",
            	    							lv_enumerationItems_4_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.EnumItem");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,18,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnumerationAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalSymboleo.g:637:3: ( (lv_enumerationItems_6_0= ruleEnumItem ) )
            // InternalSymboleo.g:638:4: (lv_enumerationItems_6_0= ruleEnumItem )
            {
            // InternalSymboleo.g:638:4: (lv_enumerationItems_6_0= ruleEnumItem )
            // InternalSymboleo.g:639:5: lv_enumerationItems_6_0= ruleEnumItem
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_12);
            lv_enumerationItems_6_0=ruleEnumItem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"enumerationItems",
            						lv_enumerationItems_6_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.EnumItem");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumItem"
    // InternalSymboleo.g:664:1: entryRuleEnumItem returns [EObject current=null] : iv_ruleEnumItem= ruleEnumItem EOF ;
    public final EObject entryRuleEnumItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumItem = null;


        try {
            // InternalSymboleo.g:664:49: (iv_ruleEnumItem= ruleEnumItem EOF )
            // InternalSymboleo.g:665:2: iv_ruleEnumItem= ruleEnumItem EOF
            {
             newCompositeNode(grammarAccess.getEnumItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumItem=ruleEnumItem();

            state._fsp--;

             current =iv_ruleEnumItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumItem"


    // $ANTLR start "ruleEnumItem"
    // InternalSymboleo.g:671:1: ruleEnumItem returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:677:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSymboleo.g:678:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSymboleo.g:678:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:679:3: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:679:3: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:680:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEnumItemRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumItem"


    // $ANTLR start "entryRuleRegularType"
    // InternalSymboleo.g:699:1: entryRuleRegularType returns [EObject current=null] : iv_ruleRegularType= ruleRegularType EOF ;
    public final EObject entryRuleRegularType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularType = null;


        try {
            // InternalSymboleo.g:699:52: (iv_ruleRegularType= ruleRegularType EOF )
            // InternalSymboleo.g:700:2: iv_ruleRegularType= ruleRegularType EOF
            {
             newCompositeNode(grammarAccess.getRegularTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularType=ruleRegularType();

            state._fsp--;

             current =iv_ruleRegularType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularType"


    // $ANTLR start "ruleRegularType"
    // InternalSymboleo.g:706:1: ruleRegularType returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? ) | ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? ) ) ;
    public final EObject ruleRegularType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_ontologyType_3_0 = null;

        EObject lv_attributes_5_0 = null;

        EObject lv_attributes_7_0 = null;

        EObject lv_attributes_13_0 = null;

        EObject lv_attributes_15_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:712:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? ) | ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? ) ) )
            // InternalSymboleo.g:713:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? ) | ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? ) )
            {
            // InternalSymboleo.g:713:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? ) | ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==28) ) {
                    int LA26_2 = input.LA(3);

                    if ( (LA26_2==RULE_ID) ) {
                        alt26=2;
                    }
                    else if ( (LA26_2==16||(LA26_2>=37 && LA26_2<=39)) ) {
                        alt26=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA26_1==29) ) {
                    int LA26_3 = input.LA(3);

                    if ( (LA26_3==RULE_ID) ) {
                        alt26=2;
                    }
                    else if ( (LA26_3==16||(LA26_3>=37 && LA26_3<=39)) ) {
                        alt26=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymboleo.g:714:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? )
                    {
                    // InternalSymboleo.g:714:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )? )
                    // InternalSymboleo.g:715:4: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )?
                    {
                    // InternalSymboleo.g:715:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalSymboleo.g:716:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalSymboleo.g:716:5: (lv_name_0_0= RULE_ID )
                    // InternalSymboleo.g:717:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getRegularTypeAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSymboleo.g:733:4: (otherlv_1= 'isA' | otherlv_2= 'isAn' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==28) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==29) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalSymboleo.g:734:5: otherlv_1= 'isA'
                            {
                            otherlv_1=(Token)match(input,28,FOLLOW_27); 

                            					newLeafNode(otherlv_1, grammarAccess.getRegularTypeAccess().getIsAKeyword_0_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:739:5: otherlv_2= 'isAn'
                            {
                            otherlv_2=(Token)match(input,29,FOLLOW_27); 

                            					newLeafNode(otherlv_2, grammarAccess.getRegularTypeAccess().getIsAnKeyword_0_1_1());
                            				

                            }
                            break;

                    }

                    // InternalSymboleo.g:744:4: ( (lv_ontologyType_3_0= ruleOntologyType ) )
                    // InternalSymboleo.g:745:5: (lv_ontologyType_3_0= ruleOntologyType )
                    {
                    // InternalSymboleo.g:745:5: (lv_ontologyType_3_0= ruleOntologyType )
                    // InternalSymboleo.g:746:6: lv_ontologyType_3_0= ruleOntologyType
                    {

                    						newCompositeNode(grammarAccess.getRegularTypeAccess().getOntologyTypeOntologyTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_ontologyType_3_0=ruleOntologyType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                    						}
                    						set(
                    							current,
                    							"ontologyType",
                    							lv_ontologyType_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.OntologyType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:763:4: (otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==31) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSymboleo.g:764:5: otherlv_4= 'with' ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )* ( (lv_attributes_7_0= ruleAttribute ) )
                            {
                            otherlv_4=(Token)match(input,31,FOLLOW_29); 

                            					newLeafNode(otherlv_4, grammarAccess.getRegularTypeAccess().getWithKeyword_0_3_0());
                            				
                            // InternalSymboleo.g:768:5: ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )*
                            loop21:
                            do {
                                int alt21=2;
                                alt21 = dfa21.predict(input);
                                switch (alt21) {
                            	case 1 :
                            	    // InternalSymboleo.g:769:6: ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ','
                            	    {
                            	    // InternalSymboleo.g:769:6: ( (lv_attributes_5_0= ruleAttribute ) )
                            	    // InternalSymboleo.g:770:7: (lv_attributes_5_0= ruleAttribute )
                            	    {
                            	    // InternalSymboleo.g:770:7: (lv_attributes_5_0= ruleAttribute )
                            	    // InternalSymboleo.g:771:8: lv_attributes_5_0= ruleAttribute
                            	    {

                            	    								newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_0_3_1_0_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_attributes_5_0=ruleAttribute();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"attributes",
                            	    									lv_attributes_5_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }

                            	    otherlv_6=(Token)match(input,18,FOLLOW_29); 

                            	    						newLeafNode(otherlv_6, grammarAccess.getRegularTypeAccess().getCommaKeyword_0_3_1_1());
                            	    					

                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);

                            // InternalSymboleo.g:793:5: ( (lv_attributes_7_0= ruleAttribute ) )
                            // InternalSymboleo.g:794:6: (lv_attributes_7_0= ruleAttribute )
                            {
                            // InternalSymboleo.g:794:6: (lv_attributes_7_0= ruleAttribute )
                            // InternalSymboleo.g:795:7: lv_attributes_7_0= ruleAttribute
                            {

                            							newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_0_3_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_attributes_7_0=ruleAttribute();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_7_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:815:3: ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? )
                    {
                    // InternalSymboleo.g:815:3: ( ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )? )
                    // InternalSymboleo.g:816:4: ( (lv_name_8_0= RULE_ID ) ) (otherlv_9= 'isA' | otherlv_10= 'isAn' ) ( (otherlv_11= RULE_ID ) ) (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )?
                    {
                    // InternalSymboleo.g:816:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalSymboleo.g:817:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalSymboleo.g:817:5: (lv_name_8_0= RULE_ID )
                    // InternalSymboleo.g:818:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_26); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getRegularTypeAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_8_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSymboleo.g:834:4: (otherlv_9= 'isA' | otherlv_10= 'isAn' )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==28) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==29) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalSymboleo.g:835:5: otherlv_9= 'isA'
                            {
                            otherlv_9=(Token)match(input,28,FOLLOW_3); 

                            					newLeafNode(otherlv_9, grammarAccess.getRegularTypeAccess().getIsAKeyword_1_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:840:5: otherlv_10= 'isAn'
                            {
                            otherlv_10=(Token)match(input,29,FOLLOW_3); 

                            					newLeafNode(otherlv_10, grammarAccess.getRegularTypeAccess().getIsAnKeyword_1_1_1());
                            				

                            }
                            break;

                    }

                    // InternalSymboleo.g:845:4: ( (otherlv_11= RULE_ID ) )
                    // InternalSymboleo.g:846:5: (otherlv_11= RULE_ID )
                    {
                    // InternalSymboleo.g:846:5: (otherlv_11= RULE_ID )
                    // InternalSymboleo.g:847:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(otherlv_11, grammarAccess.getRegularTypeAccess().getRegularTypeRegularTypeCrossReference_1_2_0());
                    					

                    }


                    }

                    // InternalSymboleo.g:858:4: (otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==31) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalSymboleo.g:859:5: otherlv_12= 'with' ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )* ( (lv_attributes_15_0= ruleAttribute ) )
                            {
                            otherlv_12=(Token)match(input,31,FOLLOW_29); 

                            					newLeafNode(otherlv_12, grammarAccess.getRegularTypeAccess().getWithKeyword_1_3_0());
                            				
                            // InternalSymboleo.g:863:5: ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )*
                            loop24:
                            do {
                                int alt24=2;
                                alt24 = dfa24.predict(input);
                                switch (alt24) {
                            	case 1 :
                            	    // InternalSymboleo.g:864:6: ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ','
                            	    {
                            	    // InternalSymboleo.g:864:6: ( (lv_attributes_13_0= ruleAttribute ) )
                            	    // InternalSymboleo.g:865:7: (lv_attributes_13_0= ruleAttribute )
                            	    {
                            	    // InternalSymboleo.g:865:7: (lv_attributes_13_0= ruleAttribute )
                            	    // InternalSymboleo.g:866:8: lv_attributes_13_0= ruleAttribute
                            	    {

                            	    								newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_1_3_1_0_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_attributes_13_0=ruleAttribute();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"attributes",
                            	    									lv_attributes_13_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }

                            	    otherlv_14=(Token)match(input,18,FOLLOW_29); 

                            	    						newLeafNode(otherlv_14, grammarAccess.getRegularTypeAccess().getCommaKeyword_1_3_1_1());
                            	    					

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);

                            // InternalSymboleo.g:888:5: ( (lv_attributes_15_0= ruleAttribute ) )
                            // InternalSymboleo.g:889:6: (lv_attributes_15_0= ruleAttribute )
                            {
                            // InternalSymboleo.g:889:6: (lv_attributes_15_0= ruleAttribute )
                            // InternalSymboleo.g:890:7: lv_attributes_15_0= ruleAttribute
                            {

                            							newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_1_3_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_attributes_15_0=ruleAttribute();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_15_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularType"


    // $ANTLR start "entryRuleAttribute"
    // InternalSymboleo.g:913:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSymboleo.g:913:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSymboleo.g:914:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSymboleo.g:920:1: ruleAttribute returns [EObject current=null] : ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_attributeModifier_0_0 = null;

        EObject lv_baseType_3_0 = null;

        EObject lv_attributeModifier_4_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:926:2: ( ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalSymboleo.g:927:2: ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalSymboleo.g:927:2: ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==40) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==RULE_ID) ) {
                    int LA29_2 = input.LA(3);

                    if ( (LA29_2==32) ) {
                        int LA29_3 = input.LA(4);

                        if ( ((LA29_3>=33 && LA29_3<=36)) ) {
                            alt29=1;
                        }
                        else if ( (LA29_3==RULE_ID) ) {
                            alt29=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 29, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA29_0==RULE_ID) ) {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==32) ) {
                    int LA29_3 = input.LA(3);

                    if ( ((LA29_3>=33 && LA29_3<=36)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_3==RULE_ID) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalSymboleo.g:928:3: ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) )
                    {
                    // InternalSymboleo.g:928:3: ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) )
                    // InternalSymboleo.g:929:4: ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) )
                    {
                    // InternalSymboleo.g:929:4: ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==40) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalSymboleo.g:930:5: (lv_attributeModifier_0_0= ruleAttributeModifier )
                            {
                            // InternalSymboleo.g:930:5: (lv_attributeModifier_0_0= ruleAttributeModifier )
                            // InternalSymboleo.g:931:6: lv_attributeModifier_0_0= ruleAttributeModifier
                            {

                            						newCompositeNode(grammarAccess.getAttributeAccess().getAttributeModifierAttributeModifierParserRuleCall_0_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_attributeModifier_0_0=ruleAttributeModifier();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAttributeRule());
                            						}
                            						set(
                            							current,
                            							"attributeModifier",
                            							lv_attributeModifier_0_0,
                            							"ca.uottawa.csmlab.symboleo.Symboleo.AttributeModifier");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalSymboleo.g:948:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSymboleo.g:949:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSymboleo.g:949:5: (lv_name_1_0= RULE_ID )
                    // InternalSymboleo.g:950:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,32,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getColonKeyword_0_2());
                    			
                    // InternalSymboleo.g:970:4: ( (lv_baseType_3_0= ruleBaseType ) )
                    // InternalSymboleo.g:971:5: (lv_baseType_3_0= ruleBaseType )
                    {
                    // InternalSymboleo.g:971:5: (lv_baseType_3_0= ruleBaseType )
                    // InternalSymboleo.g:972:6: lv_baseType_3_0= ruleBaseType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getBaseTypeBaseTypeParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_baseType_3_0=ruleBaseType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeRule());
                    						}
                    						set(
                    							current,
                    							"baseType",
                    							lv_baseType_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:991:3: ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSymboleo.g:991:3: ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
                    // InternalSymboleo.g:992:4: ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalSymboleo.g:992:4: ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==40) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalSymboleo.g:993:5: (lv_attributeModifier_4_0= ruleAttributeModifier )
                            {
                            // InternalSymboleo.g:993:5: (lv_attributeModifier_4_0= ruleAttributeModifier )
                            // InternalSymboleo.g:994:6: lv_attributeModifier_4_0= ruleAttributeModifier
                            {

                            						newCompositeNode(grammarAccess.getAttributeAccess().getAttributeModifierAttributeModifierParserRuleCall_1_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_attributeModifier_4_0=ruleAttributeModifier();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAttributeRule());
                            						}
                            						set(
                            							current,
                            							"attributeModifier",
                            							lv_attributeModifier_4_0,
                            							"ca.uottawa.csmlab.symboleo.Symboleo.AttributeModifier");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalSymboleo.g:1011:4: ( (lv_name_5_0= RULE_ID ) )
                    // InternalSymboleo.g:1012:5: (lv_name_5_0= RULE_ID )
                    {
                    // InternalSymboleo.g:1012:5: (lv_name_5_0= RULE_ID )
                    // InternalSymboleo.g:1013:6: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(lv_name_5_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getColonKeyword_1_2());
                    			
                    // InternalSymboleo.g:1033:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSymboleo.g:1034:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSymboleo.g:1034:5: (otherlv_7= RULE_ID )
                    // InternalSymboleo.g:1035:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getDomainTypeDomainTypeCrossReference_1_3_0());
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleBaseType"
    // InternalSymboleo.g:1051:1: entryRuleBaseType returns [EObject current=null] : iv_ruleBaseType= ruleBaseType EOF ;
    public final EObject entryRuleBaseType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseType = null;


        try {
            // InternalSymboleo.g:1051:49: (iv_ruleBaseType= ruleBaseType EOF )
            // InternalSymboleo.g:1052:2: iv_ruleBaseType= ruleBaseType EOF
            {
             newCompositeNode(grammarAccess.getBaseTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBaseType=ruleBaseType();

            state._fsp--;

             current =iv_ruleBaseType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseType"


    // $ANTLR start "ruleBaseType"
    // InternalSymboleo.g:1058:1: ruleBaseType returns [EObject current=null] : ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) ) ;
    public final EObject ruleBaseType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1064:2: ( ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) ) )
            // InternalSymboleo.g:1065:2: ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) )
            {
            // InternalSymboleo.g:1065:2: ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) )
            // InternalSymboleo.g:1066:3: ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) )
            {
            // InternalSymboleo.g:1066:3: ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) )
            // InternalSymboleo.g:1067:4: (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' )
            {
            // InternalSymboleo.g:1067:4: (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt30=1;
                }
                break;
            case 34:
                {
                alt30=2;
                }
                break;
            case 35:
                {
                alt30=3;
                }
                break;
            case 36:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalSymboleo.g:1068:5: lv_name_0_1= 'Number'
                    {
                    lv_name_0_1=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getBaseTypeAccess().getNameNumberKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1079:5: lv_name_0_2= 'String'
                    {
                    lv_name_0_2=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getBaseTypeAccess().getNameStringKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1090:5: lv_name_0_3= 'Date'
                    {
                    lv_name_0_3=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getBaseTypeAccess().getNameDateKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1101:5: lv_name_0_4= 'Boolean'
                    {
                    lv_name_0_4=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getBaseTypeAccess().getNameBooleanKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseType"


    // $ANTLR start "entryRuleOntologyType"
    // InternalSymboleo.g:1117:1: entryRuleOntologyType returns [EObject current=null] : iv_ruleOntologyType= ruleOntologyType EOF ;
    public final EObject entryRuleOntologyType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOntologyType = null;


        try {
            // InternalSymboleo.g:1117:53: (iv_ruleOntologyType= ruleOntologyType EOF )
            // InternalSymboleo.g:1118:2: iv_ruleOntologyType= ruleOntologyType EOF
            {
             newCompositeNode(grammarAccess.getOntologyTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOntologyType=ruleOntologyType();

            state._fsp--;

             current =iv_ruleOntologyType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOntologyType"


    // $ANTLR start "ruleOntologyType"
    // InternalSymboleo.g:1124:1: ruleOntologyType returns [EObject current=null] : ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) ) ) ;
    public final EObject ruleOntologyType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1130:2: ( ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) ) ) )
            // InternalSymboleo.g:1131:2: ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) ) )
            {
            // InternalSymboleo.g:1131:2: ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) ) )
            // InternalSymboleo.g:1132:3: ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) )
            {
            // InternalSymboleo.g:1132:3: ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' ) )
            // InternalSymboleo.g:1133:4: (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' )
            {
            // InternalSymboleo.g:1133:4: (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt31=1;
                }
                break;
            case 38:
                {
                alt31=2;
                }
                break;
            case 39:
                {
                alt31=3;
                }
                break;
            case 16:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalSymboleo.g:1134:5: lv_name_0_1= 'Asset'
                    {
                    lv_name_0_1=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getOntologyTypeAccess().getNameAssetKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1145:5: lv_name_0_2= 'Event'
                    {
                    lv_name_0_2=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getOntologyTypeAccess().getNameEventKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1156:5: lv_name_0_3= 'Role'
                    {
                    lv_name_0_3=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getOntologyTypeAccess().getNameRoleKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1167:5: lv_name_0_4= 'Contract'
                    {
                    lv_name_0_4=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getOntologyTypeAccess().getNameContractKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOntologyType"


    // $ANTLR start "entryRuleAttributeModifier"
    // InternalSymboleo.g:1183:1: entryRuleAttributeModifier returns [EObject current=null] : iv_ruleAttributeModifier= ruleAttributeModifier EOF ;
    public final EObject entryRuleAttributeModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeModifier = null;


        try {
            // InternalSymboleo.g:1183:58: (iv_ruleAttributeModifier= ruleAttributeModifier EOF )
            // InternalSymboleo.g:1184:2: iv_ruleAttributeModifier= ruleAttributeModifier EOF
            {
             newCompositeNode(grammarAccess.getAttributeModifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeModifier=ruleAttributeModifier();

            state._fsp--;

             current =iv_ruleAttributeModifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeModifier"


    // $ANTLR start "ruleAttributeModifier"
    // InternalSymboleo.g:1190:1: ruleAttributeModifier returns [EObject current=null] : ( (lv_name_0_0= 'Env' ) ) ;
    public final EObject ruleAttributeModifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1196:2: ( ( (lv_name_0_0= 'Env' ) ) )
            // InternalSymboleo.g:1197:2: ( (lv_name_0_0= 'Env' ) )
            {
            // InternalSymboleo.g:1197:2: ( (lv_name_0_0= 'Env' ) )
            // InternalSymboleo.g:1198:3: (lv_name_0_0= 'Env' )
            {
            // InternalSymboleo.g:1198:3: (lv_name_0_0= 'Env' )
            // InternalSymboleo.g:1199:4: lv_name_0_0= 'Env'
            {
            lv_name_0_0=(Token)match(input,40,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getAttributeModifierAccess().getNameEnvKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAttributeModifierRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Env");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeModifier"


    // $ANTLR start "entryRuleParameter"
    // InternalSymboleo.g:1214:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSymboleo.g:1214:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSymboleo.g:1215:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSymboleo.g:1221:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1227:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) ) )
            // InternalSymboleo.g:1228:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) )
            {
            // InternalSymboleo.g:1228:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) )
            // InternalSymboleo.g:1229:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) )
            {
            // InternalSymboleo.g:1229:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1230:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1230:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1231:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1251:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalSymboleo.g:1252:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalSymboleo.g:1252:4: (lv_type_2_0= ruleParameterType )
            // InternalSymboleo.g:1253:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterType"
    // InternalSymboleo.g:1274:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalSymboleo.g:1274:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalSymboleo.g:1275:2: iv_ruleParameterType= ruleParameterType EOF
            {
             newCompositeNode(grammarAccess.getParameterTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;

             current =iv_ruleParameterType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalSymboleo.g:1281:1: ruleParameterType returns [EObject current=null] : ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_baseType_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1287:2: ( ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSymboleo.g:1288:2: ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSymboleo.g:1288:2: ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=33 && LA32_0<=36)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalSymboleo.g:1289:3: ( (lv_baseType_0_0= ruleBaseType ) )
                    {
                    // InternalSymboleo.g:1289:3: ( (lv_baseType_0_0= ruleBaseType ) )
                    // InternalSymboleo.g:1290:4: (lv_baseType_0_0= ruleBaseType )
                    {
                    // InternalSymboleo.g:1290:4: (lv_baseType_0_0= ruleBaseType )
                    // InternalSymboleo.g:1291:5: lv_baseType_0_0= ruleBaseType
                    {

                    					newCompositeNode(grammarAccess.getParameterTypeAccess().getBaseTypeBaseTypeParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_baseType_0_0=ruleBaseType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterTypeRule());
                    					}
                    					set(
                    						current,
                    						"baseType",
                    						lv_baseType_0_0,
                    						"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1309:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalSymboleo.g:1309:3: ( (otherlv_1= RULE_ID ) )
                    // InternalSymboleo.g:1310:4: (otherlv_1= RULE_ID )
                    {
                    // InternalSymboleo.g:1310:4: (otherlv_1= RULE_ID )
                    // InternalSymboleo.g:1311:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterTypeRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getParameterTypeAccess().getDomainTypeDomainTypeCrossReference_1_0());
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleVariable"
    // InternalSymboleo.g:1326:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSymboleo.g:1326:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSymboleo.g:1327:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalSymboleo.g:1333:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1339:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? ) )
            // InternalSymboleo.g:1340:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? )
            {
            // InternalSymboleo.g:1340:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? )
            // InternalSymboleo.g:1341:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )?
            {
            // InternalSymboleo.g:1341:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1342:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1342:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1343:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1363:3: ( (otherlv_2= RULE_ID ) )
            // InternalSymboleo.g:1364:4: (otherlv_2= RULE_ID )
            {
            // InternalSymboleo.g:1364:4: (otherlv_2= RULE_ID )
            // InternalSymboleo.g:1365:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getTypeRegularTypeCrossReference_2_0());
            				

            }


            }

            // InternalSymboleo.g:1376:3: (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalSymboleo.g:1377:4: otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )*
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getWithKeyword_3_0());
                    			
                    // InternalSymboleo.g:1381:4: ( (lv_attributes_4_0= ruleAssignment ) )
                    // InternalSymboleo.g:1382:5: (lv_attributes_4_0= ruleAssignment )
                    {
                    // InternalSymboleo.g:1382:5: (lv_attributes_4_0= ruleAssignment )
                    // InternalSymboleo.g:1383:6: lv_attributes_4_0= ruleAssignment
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getAttributesAssignmentParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_attributes_4_0=ruleAssignment();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_4_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Assignment");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:1400:4: (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==18) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalSymboleo.g:1401:5: otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalSymboleo.g:1405:5: ( (lv_attributes_6_0= ruleAssignment ) )
                    	    // InternalSymboleo.g:1406:6: (lv_attributes_6_0= ruleAssignment )
                    	    {
                    	    // InternalSymboleo.g:1406:6: (lv_attributes_6_0= ruleAssignment )
                    	    // InternalSymboleo.g:1407:7: lv_attributes_6_0= ruleAssignment
                    	    {

                    	    							newCompositeNode(grammarAccess.getVariableAccess().getAttributesAssignmentParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    lv_attributes_6_0=ruleAssignment();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getVariableRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_6_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Assignment");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleOAssignment"
    // InternalSymboleo.g:1430:1: entryRuleOAssignment returns [EObject current=null] : iv_ruleOAssignment= ruleOAssignment EOF ;
    public final EObject entryRuleOAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOAssignment = null;


        try {
            // InternalSymboleo.g:1430:52: (iv_ruleOAssignment= ruleOAssignment EOF )
            // InternalSymboleo.g:1431:2: iv_ruleOAssignment= ruleOAssignment EOF
            {
             newCompositeNode(grammarAccess.getOAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOAssignment=ruleOAssignment();

            state._fsp--;

             current =iv_ruleOAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOAssignment"


    // $ANTLR start "ruleOAssignment"
    // InternalSymboleo.g:1437:1: ruleOAssignment returns [EObject current=null] : ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleOAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject lv_name2_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1443:2: ( ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalSymboleo.g:1444:2: ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalSymboleo.g:1444:2: ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) )
            // InternalSymboleo.g:1445:3: () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalSymboleo.g:1445:3: ()
            // InternalSymboleo.g:1446:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOAssignmentAccess().getOAssignExpressionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:1452:3: ( (lv_name2_1_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:1453:4: (lv_name2_1_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:1453:4: (lv_name2_1_0= ruleVariableDotExpression )
            // InternalSymboleo.g:1454:5: lv_name2_1_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getOAssignmentAccess().getName2VariableDotExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_33);
            lv_name2_1_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOAssignmentRule());
            					}
            					set(
            						current,
            						"name2",
            						lv_name2_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:1471:3: ( (lv_op_2_0= ':=' ) )
            // InternalSymboleo.g:1472:4: (lv_op_2_0= ':=' )
            {
            // InternalSymboleo.g:1472:4: (lv_op_2_0= ':=' )
            // InternalSymboleo.g:1473:5: lv_op_2_0= ':='
            {
            lv_op_2_0=(Token)match(input,41,FOLLOW_34); 

            					newLeafNode(lv_op_2_0, grammarAccess.getOAssignmentAccess().getOpColonEqualsSignKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAssignmentRule());
            					}
            					setWithLastConsumed(current, "op", lv_op_2_0, ":=");
            				

            }


            }

            // InternalSymboleo.g:1485:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalSymboleo.g:1486:4: (lv_value_3_0= ruleExpression )
            {
            // InternalSymboleo.g:1486:4: (lv_value_3_0= ruleExpression )
            // InternalSymboleo.g:1487:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getOAssignmentAccess().getValueExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOAssignment"


    // $ANTLR start "entryRuleVariableDotExpression"
    // InternalSymboleo.g:1508:1: entryRuleVariableDotExpression returns [EObject current=null] : iv_ruleVariableDotExpression= ruleVariableDotExpression EOF ;
    public final EObject entryRuleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDotExpression = null;


        try {
            // InternalSymboleo.g:1508:62: (iv_ruleVariableDotExpression= ruleVariableDotExpression EOF )
            // InternalSymboleo.g:1509:2: iv_ruleVariableDotExpression= ruleVariableDotExpression EOF
            {
             newCompositeNode(grammarAccess.getVariableDotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDotExpression=ruleVariableDotExpression();

            state._fsp--;

             current =iv_ruleVariableDotExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDotExpression"


    // $ANTLR start "ruleVariableDotExpression"
    // InternalSymboleo.g:1515:1: ruleVariableDotExpression returns [EObject current=null] : (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_VariableRef_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1521:2: ( (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalSymboleo.g:1522:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalSymboleo.g:1522:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalSymboleo.g:1523:3: this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {

            			newCompositeNode(grammarAccess.getVariableDotExpressionAccess().getVariableRefParserRuleCall_0());
            		
            pushFollow(FOLLOW_35);
            this_VariableRef_0=ruleVariableRef();

            state._fsp--;


            			current = this_VariableRef_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:1531:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==42) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSymboleo.g:1532:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalSymboleo.g:1532:4: ()
            	    // InternalSymboleo.g:1533:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getVariableDotExpressionAccess().getVariableDotExpressionRefAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getVariableDotExpressionAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:1543:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalSymboleo.g:1544:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSymboleo.g:1544:5: (otherlv_3= RULE_ID )
            	    // InternalSymboleo.g:1545:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getVariableDotExpressionRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    						newLeafNode(otherlv_3, grammarAccess.getVariableDotExpressionAccess().getTailAttributeCrossReference_1_2_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDotExpression"


    // $ANTLR start "entryRuleVariableRef"
    // InternalSymboleo.g:1561:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalSymboleo.g:1561:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalSymboleo.g:1562:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalSymboleo.g:1568:1: ruleVariableRef returns [EObject current=null] : ( () ( (lv_variable_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token lv_variable_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1574:2: ( ( () ( (lv_variable_1_0= RULE_ID ) ) ) )
            // InternalSymboleo.g:1575:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            {
            // InternalSymboleo.g:1575:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            // InternalSymboleo.g:1576:3: () ( (lv_variable_1_0= RULE_ID ) )
            {
            // InternalSymboleo.g:1576:3: ()
            // InternalSymboleo.g:1577:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:1583:3: ( (lv_variable_1_0= RULE_ID ) )
            // InternalSymboleo.g:1584:4: (lv_variable_1_0= RULE_ID )
            {
            // InternalSymboleo.g:1584:4: (lv_variable_1_0= RULE_ID )
            // InternalSymboleo.g:1585:5: lv_variable_1_0= RULE_ID
            {
            lv_variable_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getVariableRefAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleAssignment"
    // InternalSymboleo.g:1605:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSymboleo.g:1605:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSymboleo.g:1606:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalSymboleo.g:1612:1: ruleAssignment returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1618:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalSymboleo.g:1619:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalSymboleo.g:1619:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalSymboleo.g:1620:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalSymboleo.g:1620:3: ()
            // InternalSymboleo.g:1621:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssignmentAccess().getAssignExpressionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:1627:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSymboleo.g:1628:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSymboleo.g:1628:4: (lv_name_1_0= RULE_ID )
            // InternalSymboleo.g:1629:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAssignmentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getColonEqualsSignKeyword_2());
            		
            // InternalSymboleo.g:1649:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalSymboleo.g:1650:4: (lv_value_3_0= ruleExpression )
            {
            // InternalSymboleo.g:1650:4: (lv_value_3_0= ruleExpression )
            // InternalSymboleo.g:1651:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleDouble"
    // InternalSymboleo.g:1672:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // InternalSymboleo.g:1672:46: (iv_ruleDouble= ruleDouble EOF )
            // InternalSymboleo.g:1673:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalSymboleo.g:1679:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1685:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalSymboleo.g:1686:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalSymboleo.g:1686:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalSymboleo.g:1687:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_36); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,42,FOLLOW_37); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "entryRuleDate"
    // InternalSymboleo.g:1710:1: entryRuleDate returns [String current=null] : iv_ruleDate= ruleDate EOF ;
    public final String entryRuleDate() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDate = null;


        try {
            // InternalSymboleo.g:1710:44: (iv_ruleDate= ruleDate EOF )
            // InternalSymboleo.g:1711:2: iv_ruleDate= ruleDate EOF
            {
             newCompositeNode(grammarAccess.getDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDate=ruleDate();

            state._fsp--;

             current =iv_ruleDate.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDate"


    // $ANTLR start "ruleDate"
    // InternalSymboleo.g:1717:1: ruleDate returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleDate() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_2=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1723:2: ( (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) )
            // InternalSymboleo.g:1724:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            {
            // InternalSymboleo.g:1724:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            // InternalSymboleo.g:1725:3: kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')'
            {
            kw=(Token)match(input,35,FOLLOW_10); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getDateKeyword_0());
            		
            kw=(Token)match(input,17,FOLLOW_38); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getLeftParenthesisKeyword_1());
            		
            this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_12); 

            			current.merge(this_STRING_2);
            		

            			newLeafNode(this_STRING_2, grammarAccess.getDateAccess().getSTRINGTerminalRuleCall_2());
            		
            kw=(Token)match(input,19,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDate"


    // $ANTLR start "entryRuleExpression"
    // InternalSymboleo.g:1751:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSymboleo.g:1751:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSymboleo.g:1752:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSymboleo.g:1758:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1764:2: (this_Or_0= ruleOr )
            // InternalSymboleo.g:1765:2: this_Or_0= ruleOr
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;


            		current = this_Or_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalSymboleo.g:1776:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalSymboleo.g:1776:43: (iv_ruleOr= ruleOr EOF )
            // InternalSymboleo.g:1777:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalSymboleo.g:1783:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1789:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalSymboleo.g:1790:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalSymboleo.g:1790:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalSymboleo.g:1791:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_39);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:1799:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSymboleo.g:1800:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalSymboleo.g:1800:4: ()
            	    // InternalSymboleo.g:1801:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_34); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:1811:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalSymboleo.g:1812:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalSymboleo.g:1812:5: (lv_right_3_0= ruleAnd )
            	    // InternalSymboleo.g:1813:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalSymboleo.g:1835:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalSymboleo.g:1835:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalSymboleo.g:1836:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalSymboleo.g:1842:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Equality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1848:2: ( (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalSymboleo.g:1849:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalSymboleo.g:1849:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalSymboleo.g:1850:3: this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_40);
            this_Equality_0=ruleEquality();

            state._fsp--;


            			current = this_Equality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:1858:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==44) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalSymboleo.g:1859:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalSymboleo.g:1859:4: ()
            	    // InternalSymboleo.g:1860:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_34); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:1870:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalSymboleo.g:1871:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalSymboleo.g:1871:5: (lv_right_3_0= ruleEquality )
            	    // InternalSymboleo.g:1872:6: lv_right_3_0= ruleEquality
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Equality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalSymboleo.g:1894:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalSymboleo.g:1894:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalSymboleo.g:1895:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalSymboleo.g:1901:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1907:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalSymboleo.g:1908:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalSymboleo.g:1908:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalSymboleo.g:1909:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_Comparison_0=ruleComparison();

            state._fsp--;


            			current = this_Comparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:1917:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=45 && LA39_0<=46)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalSymboleo.g:1918:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalSymboleo.g:1918:4: ()
            	    // InternalSymboleo.g:1919:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:1925:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalSymboleo.g:1926:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalSymboleo.g:1926:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalSymboleo.g:1927:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalSymboleo.g:1927:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==45) ) {
            	        alt38=1;
            	    }
            	    else if ( (LA38_0==46) ) {
            	        alt38=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // InternalSymboleo.g:1928:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,45,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:1939:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,46,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:1952:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalSymboleo.g:1953:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalSymboleo.g:1953:5: (lv_right_3_0= ruleComparison )
            	    // InternalSymboleo.g:1954:6: lv_right_3_0= ruleComparison
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Comparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalSymboleo.g:1976:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalSymboleo.g:1976:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalSymboleo.g:1977:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalSymboleo.g:1983:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1989:2: ( (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalSymboleo.g:1990:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalSymboleo.g:1990:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalSymboleo.g:1991:3: this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {

            			newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_42);
            this_Addition_0=ruleAddition();

            state._fsp--;


            			current = this_Addition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:1999:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=47 && LA41_0<=50)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSymboleo.g:2000:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalSymboleo.g:2000:4: ()
            	    // InternalSymboleo.g:2001:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:2007:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalSymboleo.g:2008:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalSymboleo.g:2008:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalSymboleo.g:2009:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalSymboleo.g:2009:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt40=4;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 49:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    case 50:
            	        {
            	        alt40=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // InternalSymboleo.g:2010:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,47,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:2021:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,48,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:2032:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,49,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSymboleo.g:2043:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,50,FOLLOW_34); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:2056:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalSymboleo.g:2057:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalSymboleo.g:2057:5: (lv_right_3_0= ruleAddition )
            	    // InternalSymboleo.g:2058:6: lv_right_3_0= ruleAddition
            	    {

            	    						newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Addition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // InternalSymboleo.g:2080:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSymboleo.g:2080:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSymboleo.g:2081:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalSymboleo.g:2087:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2093:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSymboleo.g:2094:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSymboleo.g:2094:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSymboleo.g:2095:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_43);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:2103:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=51 && LA43_0<=52)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSymboleo.g:2104:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSymboleo.g:2104:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==51) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==52) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // InternalSymboleo.g:2105:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSymboleo.g:2105:5: ( () otherlv_2= '+' )
            	            // InternalSymboleo.g:2106:6: () otherlv_2= '+'
            	            {
            	            // InternalSymboleo.g:2106:6: ()
            	            // InternalSymboleo.g:2107:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,51,FOLLOW_34); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:2119:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSymboleo.g:2119:5: ( () otherlv_4= '-' )
            	            // InternalSymboleo.g:2120:6: () otherlv_4= '-'
            	            {
            	            // InternalSymboleo.g:2120:6: ()
            	            // InternalSymboleo.g:2121:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,52,FOLLOW_34); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSymboleo.g:2133:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSymboleo.g:2134:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSymboleo.g:2134:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSymboleo.g:2135:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Multiplication");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSymboleo.g:2157:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSymboleo.g:2157:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSymboleo.g:2158:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalSymboleo.g:2164:1: ruleMultiplication returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2170:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
            // InternalSymboleo.g:2171:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            {
            // InternalSymboleo.g:2171:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            // InternalSymboleo.g:2172:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_44);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:2180:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=53 && LA45_0<=54)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalSymboleo.g:2181:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
            	    {
            	    // InternalSymboleo.g:2181:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==53) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==54) ) {
            	        alt44=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // InternalSymboleo.g:2182:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSymboleo.g:2182:5: ( () otherlv_2= '*' )
            	            // InternalSymboleo.g:2183:6: () otherlv_2= '*'
            	            {
            	            // InternalSymboleo.g:2183:6: ()
            	            // InternalSymboleo.g:2184:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,53,FOLLOW_34); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:2196:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSymboleo.g:2196:5: ( () otherlv_4= '/' )
            	            // InternalSymboleo.g:2197:6: () otherlv_4= '/'
            	            {
            	            // InternalSymboleo.g:2197:6: ()
            	            // InternalSymboleo.g:2198:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,54,FOLLOW_34); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSymboleo.g:2210:4: ( (lv_right_5_0= rulePrimaryExpression ) )
            	    // InternalSymboleo.g:2211:5: (lv_right_5_0= rulePrimaryExpression )
            	    {
            	    // InternalSymboleo.g:2211:5: (lv_right_5_0= rulePrimaryExpression )
            	    // InternalSymboleo.g:2212:6: lv_right_5_0= rulePrimaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_right_5_0=rulePrimaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PrimaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSymboleo.g:2234:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSymboleo.g:2234:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSymboleo.g:2235:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSymboleo.g:2241:1: rulePrimaryExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_inner_2_0 = null;

        EObject lv_function_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject this_AtomicExpression_9 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2247:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) )
            // InternalSymboleo.g:2248:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            {
            // InternalSymboleo.g:2248:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            int alt46=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt46=1;
                }
                break;
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt46=2;
                }
                break;
            case 55:
                {
                alt46=3;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 35:
            case 56:
            case 57:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalSymboleo.g:2249:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalSymboleo.g:2249:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalSymboleo.g:2250:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalSymboleo.g:2250:4: ()
                    // InternalSymboleo.g:2251:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymboleo.g:2261:4: ( (lv_inner_2_0= ruleExpression ) )
                    // InternalSymboleo.g:2262:5: (lv_inner_2_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2262:5: (lv_inner_2_0= ruleExpression )
                    // InternalSymboleo.g:2263:6: lv_inner_2_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInnerExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_inner_2_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2286:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    {
                    // InternalSymboleo.g:2286:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    // InternalSymboleo.g:2287:4: () ( (lv_function_5_0= ruleFunctionCall ) )
                    {
                    // InternalSymboleo.g:2287:4: ()
                    // InternalSymboleo.g:2288:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionFunctionCallAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2294:4: ( (lv_function_5_0= ruleFunctionCall ) )
                    // InternalSymboleo.g:2295:5: (lv_function_5_0= ruleFunctionCall )
                    {
                    // InternalSymboleo.g:2295:5: (lv_function_5_0= ruleFunctionCall )
                    // InternalSymboleo.g:2296:6: lv_function_5_0= ruleFunctionCall
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionFunctionCallParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_5_0=ruleFunctionCall();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.FunctionCall");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2315:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    {
                    // InternalSymboleo.g:2315:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    // InternalSymboleo.g:2316:4: () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) )
                    {
                    // InternalSymboleo.g:2316:4: ()
                    // InternalSymboleo.g:2317:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNegatedPrimaryExpressionAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,55,FOLLOW_34); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getNotKeyword_2_1());
                    			
                    // InternalSymboleo.g:2327:4: ( (lv_expression_8_0= rulePrimaryExpression ) )
                    // InternalSymboleo.g:2328:5: (lv_expression_8_0= rulePrimaryExpression )
                    {
                    // InternalSymboleo.g:2328:5: (lv_expression_8_0= rulePrimaryExpression )
                    // InternalSymboleo.g:2329:6: lv_expression_8_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionPrimaryExpressionParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_8_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2348:3: this_AtomicExpression_9= ruleAtomicExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAtomicExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicExpression_9=ruleAtomicExpression();

                    state._fsp--;


                    			current = this_AtomicExpression_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalSymboleo.g:2360:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalSymboleo.g:2360:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalSymboleo.g:2361:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;

             current =iv_ruleAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalSymboleo.g:2367:1: ruleAtomicExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_7_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_value_16_0=null;
        AntlrDatatypeRuleToken lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_value_9_0 = null;

        EObject lv_value_18_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2373:2: ( ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) )
            // InternalSymboleo.g:2374:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalSymboleo.g:2374:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            int alt47=8;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // InternalSymboleo.g:2375:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    {
                    // InternalSymboleo.g:2375:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    // InternalSymboleo.g:2376:4: () ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSymboleo.g:2376:4: ()
                    // InternalSymboleo.g:2377:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionTrueAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2383:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSymboleo.g:2384:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSymboleo.g:2384:5: (lv_value_1_0= 'true' )
                    // InternalSymboleo.g:2385:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,56,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getAtomicExpressionAccess().getValueTrueKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2399:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    {
                    // InternalSymboleo.g:2399:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    // InternalSymboleo.g:2400:4: () ( (lv_value_3_0= 'false' ) )
                    {
                    // InternalSymboleo.g:2400:4: ()
                    // InternalSymboleo.g:2401:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionFalseAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2407:4: ( (lv_value_3_0= 'false' ) )
                    // InternalSymboleo.g:2408:5: (lv_value_3_0= 'false' )
                    {
                    // InternalSymboleo.g:2408:5: (lv_value_3_0= 'false' )
                    // InternalSymboleo.g:2409:6: lv_value_3_0= 'false'
                    {
                    lv_value_3_0=(Token)match(input,57,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getAtomicExpressionAccess().getValueFalseKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_3_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2423:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    {
                    // InternalSymboleo.g:2423:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    // InternalSymboleo.g:2424:4: () ( (lv_value_5_0= ruleDouble ) )
                    {
                    // InternalSymboleo.g:2424:4: ()
                    // InternalSymboleo.g:2425:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDoubleAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2431:4: ( (lv_value_5_0= ruleDouble ) )
                    // InternalSymboleo.g:2432:5: (lv_value_5_0= ruleDouble )
                    {
                    // InternalSymboleo.g:2432:5: (lv_value_5_0= ruleDouble )
                    // InternalSymboleo.g:2433:6: lv_value_5_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDoubleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2452:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:2452:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    // InternalSymboleo.g:2453:4: () ( (lv_value_7_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:2453:4: ()
                    // InternalSymboleo.g:2454:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionIntAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2460:4: ( (lv_value_7_0= RULE_INT ) )
                    // InternalSymboleo.g:2461:5: (lv_value_7_0= RULE_INT )
                    {
                    // InternalSymboleo.g:2461:5: (lv_value_7_0= RULE_INT )
                    // InternalSymboleo.g:2462:6: lv_value_7_0= RULE_INT
                    {
                    lv_value_7_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_7_0, grammarAccess.getAtomicExpressionAccess().getValueINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_7_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2480:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    {
                    // InternalSymboleo.g:2480:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    // InternalSymboleo.g:2481:4: () ( (lv_value_9_0= ruleDate ) )
                    {
                    // InternalSymboleo.g:2481:4: ()
                    // InternalSymboleo.g:2482:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDateAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2488:4: ( (lv_value_9_0= ruleDate ) )
                    // InternalSymboleo.g:2489:5: (lv_value_9_0= ruleDate )
                    {
                    // InternalSymboleo.g:2489:5: (lv_value_9_0= ruleDate )
                    // InternalSymboleo.g:2490:6: lv_value_9_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDateParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_9_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_9_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2509:3: ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' )
                    {
                    // InternalSymboleo.g:2509:3: ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' )
                    // InternalSymboleo.g:2510:4: () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')'
                    {
                    // InternalSymboleo.g:2510:4: ()
                    // InternalSymboleo.g:2511:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionEnumAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2517:4: ( (otherlv_11= RULE_ID ) )
                    // InternalSymboleo.g:2518:5: (otherlv_11= RULE_ID )
                    {
                    // InternalSymboleo.g:2518:5: (otherlv_11= RULE_ID )
                    // InternalSymboleo.g:2519:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_11, grammarAccess.getAtomicExpressionAccess().getEnumerationEnumerationCrossReference_5_1_0());
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:2534:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSymboleo.g:2535:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSymboleo.g:2535:5: (otherlv_13= RULE_ID )
                    // InternalSymboleo.g:2536:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_13, grammarAccess.getAtomicExpressionAccess().getEnumItemEnumItemCrossReference_5_3_0());
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:2553:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    {
                    // InternalSymboleo.g:2553:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    // InternalSymboleo.g:2554:4: () ( (lv_value_16_0= RULE_STRING ) )
                    {
                    // InternalSymboleo.g:2554:4: ()
                    // InternalSymboleo.g:2555:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionStringAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2561:4: ( (lv_value_16_0= RULE_STRING ) )
                    // InternalSymboleo.g:2562:5: (lv_value_16_0= RULE_STRING )
                    {
                    // InternalSymboleo.g:2562:5: (lv_value_16_0= RULE_STRING )
                    // InternalSymboleo.g:2563:6: lv_value_16_0= RULE_STRING
                    {
                    lv_value_16_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_16_0, grammarAccess.getAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_16_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:2581:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:2581:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:2582:4: () ( (lv_value_18_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:2582:4: ()
                    // InternalSymboleo.g:2583:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionParameterAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2589:4: ( (lv_value_18_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:2590:5: (lv_value_18_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:2590:5: (lv_value_18_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:2591:6: lv_value_18_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueVariableDotExpressionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_18_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_18_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalSymboleo.g:2613:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalSymboleo.g:2613:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalSymboleo.g:2614:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalSymboleo.g:2620:1: ruleFunctionCall returns [EObject current=null] : (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_MathFunction_0 = null;

        EObject this_StringFunction_1 = null;

        EObject this_DateFunction_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2626:2: ( (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) )
            // InternalSymboleo.g:2627:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            {
            // InternalSymboleo.g:2627:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt48=1;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt48=2;
                }
                break;
            case 74:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalSymboleo.g:2628:3: this_MathFunction_0= ruleMathFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getMathFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathFunction_0=ruleMathFunction();

                    state._fsp--;


                    			current = this_MathFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2637:3: this_StringFunction_1= ruleStringFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getStringFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringFunction_1=ruleStringFunction();

                    state._fsp--;


                    			current = this_StringFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2646:3: this_DateFunction_2= ruleDateFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getDateFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateFunction_2=ruleDateFunction();

                    state._fsp--;


                    			current = this_DateFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleMathFunction"
    // InternalSymboleo.g:2658:1: entryRuleMathFunction returns [EObject current=null] : iv_ruleMathFunction= ruleMathFunction EOF ;
    public final EObject entryRuleMathFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathFunction = null;


        try {
            // InternalSymboleo.g:2658:53: (iv_ruleMathFunction= ruleMathFunction EOF )
            // InternalSymboleo.g:2659:2: iv_ruleMathFunction= ruleMathFunction EOF
            {
             newCompositeNode(grammarAccess.getMathFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathFunction=ruleMathFunction();

            state._fsp--;

             current =iv_ruleMathFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathFunction"


    // $ANTLR start "ruleMathFunction"
    // InternalSymboleo.g:2665:1: ruleMathFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) ;
    public final EObject ruleMathFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_name_8_1=null;
        Token lv_name_8_2=null;
        Token lv_name_8_3=null;
        Token lv_name_8_4=null;
        Token lv_name_8_5=null;
        Token lv_name_8_6=null;
        Token lv_name_8_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg1_10_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2671:2: ( ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) )
            // InternalSymboleo.g:2672:2: ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            {
            // InternalSymboleo.g:2672:2: ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==58) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=59 && LA50_0<=65)) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalSymboleo.g:2673:3: ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:2673:3: ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:2674:4: () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:2674:4: ()
                    // InternalSymboleo.g:2675:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getTwoArgMathFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2681:4: ( (lv_name_1_0= 'Math.pow' ) )
                    // InternalSymboleo.g:2682:5: (lv_name_1_0= 'Math.pow' )
                    {
                    // InternalSymboleo.g:2682:5: (lv_name_1_0= 'Math.pow' )
                    // InternalSymboleo.g:2683:6: lv_name_1_0= 'Math.pow'
                    {
                    lv_name_1_0=(Token)match(input,58,FOLLOW_10); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getMathFunctionAccess().getNameMathPowKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMathFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "Math.pow");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_2, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:2699:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalSymboleo.g:2700:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2700:5: (lv_arg1_3_0= ruleExpression )
                    // InternalSymboleo.g:2701:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_4, grammarAccess.getMathFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:2722:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalSymboleo.g:2723:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2723:5: (lv_arg2_5_0= ruleExpression )
                    // InternalSymboleo.g:2724:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2747:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:2747:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:2748:4: () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:2748:4: ()
                    // InternalSymboleo.g:2749:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getOneArgMathFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2755:4: ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) )
                    // InternalSymboleo.g:2756:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    {
                    // InternalSymboleo.g:2756:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    // InternalSymboleo.g:2757:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    {
                    // InternalSymboleo.g:2757:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    int alt49=7;
                    switch ( input.LA(1) ) {
                    case 59:
                        {
                        alt49=1;
                        }
                        break;
                    case 60:
                        {
                        alt49=2;
                        }
                        break;
                    case 61:
                        {
                        alt49=3;
                        }
                        break;
                    case 62:
                        {
                        alt49=4;
                        }
                        break;
                    case 63:
                        {
                        alt49=5;
                        }
                        break;
                    case 64:
                        {
                        alt49=6;
                        }
                        break;
                    case 65:
                        {
                        alt49=7;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }

                    switch (alt49) {
                        case 1 :
                            // InternalSymboleo.g:2758:7: lv_name_8_1= 'Math.abs'
                            {
                            lv_name_8_1=(Token)match(input,59,FOLLOW_10); 

                            							newLeafNode(lv_name_8_1, grammarAccess.getMathFunctionAccess().getNameMathAbsKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:2769:7: lv_name_8_2= 'Math.floor'
                            {
                            lv_name_8_2=(Token)match(input,60,FOLLOW_10); 

                            							newLeafNode(lv_name_8_2, grammarAccess.getMathFunctionAccess().getNameMathFloorKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSymboleo.g:2780:7: lv_name_8_3= 'Math.cbrt'
                            {
                            lv_name_8_3=(Token)match(input,61,FOLLOW_10); 

                            							newLeafNode(lv_name_8_3, grammarAccess.getMathFunctionAccess().getNameMathCbrtKeyword_1_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSymboleo.g:2791:7: lv_name_8_4= 'Math.ceil'
                            {
                            lv_name_8_4=(Token)match(input,62,FOLLOW_10); 

                            							newLeafNode(lv_name_8_4, grammarAccess.getMathFunctionAccess().getNameMathCeilKeyword_1_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSymboleo.g:2802:7: lv_name_8_5= 'Math.exp'
                            {
                            lv_name_8_5=(Token)match(input,63,FOLLOW_10); 

                            							newLeafNode(lv_name_8_5, grammarAccess.getMathFunctionAccess().getNameMathExpKeyword_1_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSymboleo.g:2813:7: lv_name_8_6= 'Math.sign'
                            {
                            lv_name_8_6=(Token)match(input,64,FOLLOW_10); 

                            							newLeafNode(lv_name_8_6, grammarAccess.getMathFunctionAccess().getNameMathSignKeyword_1_1_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSymboleo.g:2824:7: lv_name_8_7= 'Math.sqrt'
                            {
                            lv_name_8_7=(Token)match(input,65,FOLLOW_10); 

                            							newLeafNode(lv_name_8_7, grammarAccess.getMathFunctionAccess().getNameMathSqrtKeyword_1_1_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_7, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:2841:4: ( (lv_arg1_10_0= ruleExpression ) )
                    // InternalSymboleo.g:2842:5: (lv_arg1_10_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2842:5: (lv_arg1_10_0= ruleExpression )
                    // InternalSymboleo.g:2843:6: lv_arg1_10_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg1_10_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathFunction"


    // $ANTLR start "entryRuleStringFunction"
    // InternalSymboleo.g:2869:1: entryRuleStringFunction returns [EObject current=null] : iv_ruleStringFunction= ruleStringFunction EOF ;
    public final EObject entryRuleStringFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringFunction = null;


        try {
            // InternalSymboleo.g:2869:55: (iv_ruleStringFunction= ruleStringFunction EOF )
            // InternalSymboleo.g:2870:2: iv_ruleStringFunction= ruleStringFunction EOF
            {
             newCompositeNode(grammarAccess.getStringFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringFunction=ruleStringFunction();

            state._fsp--;

             current =iv_ruleStringFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringFunction"


    // $ANTLR start "ruleStringFunction"
    // InternalSymboleo.g:2876:1: ruleStringFunction returns [EObject current=null] : ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) ;
    public final EObject ruleStringFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_name_17_1=null;
        Token lv_name_17_2=null;
        Token lv_name_17_3=null;
        Token lv_name_17_4=null;
        Token lv_name_17_5=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg3_7_0 = null;

        EObject lv_arg1_12_0 = null;

        EObject lv_arg2_14_0 = null;

        EObject lv_arg1_19_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2882:2: ( ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) )
            // InternalSymboleo.g:2883:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            {
            // InternalSymboleo.g:2883:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            int alt53=3;
            switch ( input.LA(1) ) {
            case 66:
            case 67:
                {
                alt53=1;
                }
                break;
            case 68:
                {
                alt53=2;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt53=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalSymboleo.g:2884:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalSymboleo.g:2884:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalSymboleo.g:2885:4: () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    // InternalSymboleo.g:2885:4: ()
                    // InternalSymboleo.g:2886:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getThreeArgStringFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2892:4: ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) )
                    // InternalSymboleo.g:2893:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    {
                    // InternalSymboleo.g:2893:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    // InternalSymboleo.g:2894:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    {
                    // InternalSymboleo.g:2894:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==66) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==67) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalSymboleo.g:2895:7: lv_name_1_1= 'String.substring'
                            {
                            lv_name_1_1=(Token)match(input,66,FOLLOW_10); 

                            							newLeafNode(lv_name_1_1, grammarAccess.getStringFunctionAccess().getNameStringSubstringKeyword_0_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:2906:7: lv_name_1_2= 'String.replaceAll'
                            {
                            lv_name_1_2=(Token)match(input,67,FOLLOW_10); 

                            							newLeafNode(lv_name_1_2, grammarAccess.getStringFunctionAccess().getNameStringReplaceAllKeyword_0_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_2, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:2923:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalSymboleo.g:2924:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2924:5: (lv_arg1_3_0= ruleExpression )
                    // InternalSymboleo.g:2925:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_4, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:2946:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalSymboleo.g:2947:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2947:5: (lv_arg2_5_0= ruleExpression )
                    // InternalSymboleo.g:2948:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_6, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_6());
                    			
                    // InternalSymboleo.g:2969:4: ( (lv_arg3_7_0= ruleExpression ) )
                    // InternalSymboleo.g:2970:5: (lv_arg3_7_0= ruleExpression )
                    {
                    // InternalSymboleo.g:2970:5: (lv_arg3_7_0= ruleExpression )
                    // InternalSymboleo.g:2971:6: lv_arg3_7_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg3ExpressionParserRuleCall_0_7_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg3_7_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg3",
                    							lv_arg3_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_8());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2994:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    {
                    // InternalSymboleo.g:2994:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    // InternalSymboleo.g:2995:4: () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')'
                    {
                    // InternalSymboleo.g:2995:4: ()
                    // InternalSymboleo.g:2996:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getTwoArgStringFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3002:4: ( (lv_name_10_0= 'String.concat' ) )
                    // InternalSymboleo.g:3003:5: (lv_name_10_0= 'String.concat' )
                    {
                    // InternalSymboleo.g:3003:5: (lv_name_10_0= 'String.concat' )
                    // InternalSymboleo.g:3004:6: lv_name_10_0= 'String.concat'
                    {
                    lv_name_10_0=(Token)match(input,68,FOLLOW_10); 

                    						newLeafNode(lv_name_10_0, grammarAccess.getStringFunctionAccess().getNameStringConcatKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_10_0, "String.concat");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_11, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:3020:4: ( (lv_arg1_12_0= ruleExpression ) )
                    // InternalSymboleo.g:3021:5: (lv_arg1_12_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3021:5: (lv_arg1_12_0= ruleExpression )
                    // InternalSymboleo.g:3022:6: lv_arg1_12_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_12_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_12_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_13, grammarAccess.getStringFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:3043:4: ( (lv_arg2_14_0= ruleExpression ) )
                    // InternalSymboleo.g:3044:5: (lv_arg2_14_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3044:5: (lv_arg2_14_0= ruleExpression )
                    // InternalSymboleo.g:3045:6: lv_arg2_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_14_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3068:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    {
                    // InternalSymboleo.g:3068:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    // InternalSymboleo.g:3069:4: () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')'
                    {
                    // InternalSymboleo.g:3069:4: ()
                    // InternalSymboleo.g:3070:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getOneArgStringFunctionAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3076:4: ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) )
                    // InternalSymboleo.g:3077:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    {
                    // InternalSymboleo.g:3077:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    // InternalSymboleo.g:3078:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    {
                    // InternalSymboleo.g:3078:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    int alt52=5;
                    switch ( input.LA(1) ) {
                    case 69:
                        {
                        alt52=1;
                        }
                        break;
                    case 70:
                        {
                        alt52=2;
                        }
                        break;
                    case 71:
                        {
                        alt52=3;
                        }
                        break;
                    case 72:
                        {
                        alt52=4;
                        }
                        break;
                    case 73:
                        {
                        alt52=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }

                    switch (alt52) {
                        case 1 :
                            // InternalSymboleo.g:3079:7: lv_name_17_1= 'String.toLowerCase'
                            {
                            lv_name_17_1=(Token)match(input,69,FOLLOW_10); 

                            							newLeafNode(lv_name_17_1, grammarAccess.getStringFunctionAccess().getNameStringToLowerCaseKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:3090:7: lv_name_17_2= 'String.toUpperCase'
                            {
                            lv_name_17_2=(Token)match(input,70,FOLLOW_10); 

                            							newLeafNode(lv_name_17_2, grammarAccess.getStringFunctionAccess().getNameStringToUpperCaseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSymboleo.g:3101:7: lv_name_17_3= 'String.trimEnd'
                            {
                            lv_name_17_3=(Token)match(input,71,FOLLOW_10); 

                            							newLeafNode(lv_name_17_3, grammarAccess.getStringFunctionAccess().getNameStringTrimEndKeyword_2_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSymboleo.g:3112:7: lv_name_17_4= 'String.trimStart'
                            {
                            lv_name_17_4=(Token)match(input,72,FOLLOW_10); 

                            							newLeafNode(lv_name_17_4, grammarAccess.getStringFunctionAccess().getNameStringTrimStartKeyword_2_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSymboleo.g:3123:7: lv_name_17_5= 'String.trim'
                            {
                            lv_name_17_5=(Token)match(input,73,FOLLOW_10); 

                            							newLeafNode(lv_name_17_5, grammarAccess.getStringFunctionAccess().getNameStringTrimKeyword_2_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_5, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_18=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_18, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:3140:4: ( (lv_arg1_19_0= ruleExpression ) )
                    // InternalSymboleo.g:3141:5: (lv_arg1_19_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3141:5: (lv_arg1_19_0= ruleExpression )
                    // InternalSymboleo.g:3142:6: lv_arg1_19_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg1_19_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_19_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringFunction"


    // $ANTLR start "entryRuleDateFunction"
    // InternalSymboleo.g:3168:1: entryRuleDateFunction returns [EObject current=null] : iv_ruleDateFunction= ruleDateFunction EOF ;
    public final EObject entryRuleDateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFunction = null;


        try {
            // InternalSymboleo.g:3168:53: (iv_ruleDateFunction= ruleDateFunction EOF )
            // InternalSymboleo.g:3169:2: iv_ruleDateFunction= ruleDateFunction EOF
            {
             newCompositeNode(grammarAccess.getDateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateFunction=ruleDateFunction();

            state._fsp--;

             current =iv_ruleDateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateFunction"


    // $ANTLR start "ruleDateFunction"
    // InternalSymboleo.g:3175:1: ruleDateFunction returns [EObject current=null] : ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject ruleDateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3181:2: ( ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalSymboleo.g:3182:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalSymboleo.g:3182:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalSymboleo.g:3183:3: () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalSymboleo.g:3183:3: ()
            // InternalSymboleo.g:3184:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDateFunctionAccess().getThreeArgDateFunctionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:3190:3: ( (lv_name_1_0= 'Date.add' ) )
            // InternalSymboleo.g:3191:4: (lv_name_1_0= 'Date.add' )
            {
            // InternalSymboleo.g:3191:4: (lv_name_1_0= 'Date.add' )
            // InternalSymboleo.g:3192:5: lv_name_1_0= 'Date.add'
            {
            lv_name_1_0=(Token)match(input,74,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateFunctionAccess().getNameDateAddKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateFunctionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "Date.add");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getDateFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSymboleo.g:3208:3: ( (lv_arg1_3_0= ruleExpression ) )
            // InternalSymboleo.g:3209:4: (lv_arg1_3_0= ruleExpression )
            {
            // InternalSymboleo.g:3209:4: (lv_arg1_3_0= ruleExpression )
            // InternalSymboleo.g:3210:5: lv_arg1_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getArg1ExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_arg1_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"arg1",
            						lv_arg1_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getDateFunctionAccess().getCommaKeyword_4());
            		
            // InternalSymboleo.g:3231:3: ( (lv_value_5_0= ruleExpression ) )
            // InternalSymboleo.g:3232:4: (lv_value_5_0= ruleExpression )
            {
            // InternalSymboleo.g:3232:4: (lv_value_5_0= ruleExpression )
            // InternalSymboleo.g:3233:5: lv_value_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getValueExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getDateFunctionAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:3254:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalSymboleo.g:3255:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalSymboleo.g:3255:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalSymboleo.g:3256:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDateFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateFunction"


    // $ANTLR start "entryRuleObligation"
    // InternalSymboleo.g:3281:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalSymboleo.g:3281:51: (iv_ruleObligation= ruleObligation EOF )
            // InternalSymboleo.g:3282:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalSymboleo.g:3288:1: ruleObligation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_debtor_7_0 = null;

        EObject lv_creditor_9_0 = null;

        EObject lv_antecedent_11_0 = null;

        EObject lv_consequent_13_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3294:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' ) )
            // InternalSymboleo.g:3295:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' )
            {
            // InternalSymboleo.g:3295:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' )
            // InternalSymboleo.g:3296:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')'
            {
            // InternalSymboleo.g:3296:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:3297:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:3297:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:3298:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_name_0_0, grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:3318:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_STRING)||LA54_0==17||LA54_0==35||(LA54_0>=55 && LA54_0<=57)||(LA54_0>=87 && LA54_0<=99)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalSymboleo.g:3319:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:3319:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:3320:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:3320:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:3321:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,75,FOLLOW_47); 

                    				newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalSymboleo.g:3343:3: (otherlv_4= 'O' | otherlv_5= 'Obligation' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==76) ) {
                alt55=1;
            }
            else if ( (LA55_0==77) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalSymboleo.g:3344:4: otherlv_4= 'O'
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getOKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3349:4: otherlv_5= 'Obligation'
                    {
                    otherlv_5=(Token)match(input,77,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getObligationAccess().getObligationKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:3358:3: ( (lv_debtor_7_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:3359:4: (lv_debtor_7_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:3359:4: (lv_debtor_7_0= ruleVariableDotExpression )
            // InternalSymboleo.g:3360:5: lv_debtor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getDebtorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_debtor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getObligationAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:3381:3: ( (lv_creditor_9_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:3382:4: (lv_creditor_9_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:3382:4: (lv_creditor_9_0= ruleVariableDotExpression )
            // InternalSymboleo.g:3383:5: lv_creditor_9_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getCreditorVariableDotExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_creditor_9_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_9_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_48); 

            			newLeafNode(otherlv_10, grammarAccess.getObligationAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:3404:3: ( (lv_antecedent_11_0= ruleProposition ) )
            // InternalSymboleo.g:3405:4: (lv_antecedent_11_0= ruleProposition )
            {
            // InternalSymboleo.g:3405:4: (lv_antecedent_11_0= ruleProposition )
            // InternalSymboleo.g:3406:5: lv_antecedent_11_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_antecedent_11_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_11_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_48); 

            			newLeafNode(otherlv_12, grammarAccess.getObligationAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:3427:3: ( (lv_consequent_13_0= ruleProposition ) )
            // InternalSymboleo.g:3428:4: (lv_consequent_13_0= ruleProposition )
            {
            // InternalSymboleo.g:3428:4: (lv_consequent_13_0= ruleProposition )
            // InternalSymboleo.g:3429:5: lv_consequent_13_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_12);
            lv_consequent_13_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getObligationAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalSymboleo.g:3454:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // InternalSymboleo.g:3454:46: (iv_rulePower= rulePower EOF )
            // InternalSymboleo.g:3455:2: iv_rulePower= rulePower EOF
            {
             newCompositeNode(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePower=rulePower();

            state._fsp--;

             current =iv_rulePower; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalSymboleo.g:3461:1: rulePower returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_creditor_7_0 = null;

        EObject lv_debtor_9_0 = null;

        EObject lv_antecedent_11_0 = null;

        EObject lv_consequent_13_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3467:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' ) )
            // InternalSymboleo.g:3468:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' )
            {
            // InternalSymboleo.g:3468:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' )
            // InternalSymboleo.g:3469:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')'
            {
            // InternalSymboleo.g:3469:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:3470:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:3470:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:3471:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:3491:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_STRING)||LA56_0==17||LA56_0==35||(LA56_0>=55 && LA56_0<=57)||(LA56_0>=87 && LA56_0<=99)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalSymboleo.g:3492:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:3492:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:3493:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:3493:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:3494:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,75,FOLLOW_50); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalSymboleo.g:3516:3: (otherlv_4= 'P' | otherlv_5= 'Power' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==78) ) {
                alt57=1;
            }
            else if ( (LA57_0==79) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalSymboleo.g:3517:4: otherlv_4= 'P'
                    {
                    otherlv_4=(Token)match(input,78,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getPowerAccess().getPKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3522:4: otherlv_5= 'Power'
                    {
                    otherlv_5=(Token)match(input,79,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getPowerAccess().getPowerKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:3531:3: ( (lv_creditor_7_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:3532:4: (lv_creditor_7_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:3532:4: (lv_creditor_7_0= ruleVariableDotExpression )
            // InternalSymboleo.g:3533:5: lv_creditor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getCreditorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_creditor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getPowerAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:3554:3: ( (lv_debtor_9_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:3555:4: (lv_debtor_9_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:3555:4: (lv_debtor_9_0= ruleVariableDotExpression )
            // InternalSymboleo.g:3556:5: lv_debtor_9_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getDebtorVariableDotExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_debtor_9_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_9_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_48); 

            			newLeafNode(otherlv_10, grammarAccess.getPowerAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:3577:3: ( (lv_antecedent_11_0= ruleProposition ) )
            // InternalSymboleo.g:3578:4: (lv_antecedent_11_0= ruleProposition )
            {
            // InternalSymboleo.g:3578:4: (lv_antecedent_11_0= ruleProposition )
            // InternalSymboleo.g:3579:5: lv_antecedent_11_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_antecedent_11_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_11_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_51); 

            			newLeafNode(otherlv_12, grammarAccess.getPowerAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:3600:3: ( (lv_consequent_13_0= rulePowerFunction ) )
            // InternalSymboleo.g:3601:4: (lv_consequent_13_0= rulePowerFunction )
            {
            // InternalSymboleo.g:3601:4: (lv_consequent_13_0= rulePowerFunction )
            // InternalSymboleo.g:3602:5: lv_consequent_13_0= rulePowerFunction
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getConsequentPowerFunctionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_12);
            lv_consequent_13_0=rulePowerFunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerFunction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getPowerAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRulePowerFunction"
    // InternalSymboleo.g:3627:1: entryRulePowerFunction returns [EObject current=null] : iv_rulePowerFunction= rulePowerFunction EOF ;
    public final EObject entryRulePowerFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerFunction = null;


        try {
            // InternalSymboleo.g:3627:54: (iv_rulePowerFunction= rulePowerFunction EOF )
            // InternalSymboleo.g:3628:2: iv_rulePowerFunction= rulePowerFunction EOF
            {
             newCompositeNode(grammarAccess.getPowerFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerFunction=rulePowerFunction();

            state._fsp--;

             current =iv_rulePowerFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerFunction"


    // $ANTLR start "rulePowerFunction"
    // InternalSymboleo.g:3634:1: rulePowerFunction returns [EObject current=null] : ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) ;
    public final EObject rulePowerFunction() throws RecognitionException {
        EObject current = null;

        Token lv_action_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_action_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_action_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_action_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_action_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token lv_action_31_0=null;
        Token otherlv_32=null;
        Token lv_norm_33_0=null;
        Token otherlv_34=null;
        Token lv_action_36_0=null;
        Token otherlv_37=null;
        Token lv_norm_38_0=null;
        Token otherlv_39=null;
        Token lv_action_41_0=null;
        Token otherlv_42=null;
        Token lv_norm_43_0=null;
        Token otherlv_44=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3640:2: ( ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) )
            // InternalSymboleo.g:3641:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            {
            // InternalSymboleo.g:3641:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            int alt58=8;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalSymboleo.g:3642:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    {
                    // InternalSymboleo.g:3642:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    // InternalSymboleo.g:3643:4: () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
                    {
                    // InternalSymboleo.g:3643:4: ()
                    // InternalSymboleo.g:3644:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationSuspendedAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3650:4: ( (lv_action_1_0= 'Suspended' ) )
                    // InternalSymboleo.g:3651:5: (lv_action_1_0= 'Suspended' )
                    {
                    // InternalSymboleo.g:3651:5: (lv_action_1_0= 'Suspended' )
                    // InternalSymboleo.g:3652:6: lv_action_1_0= 'Suspended'
                    {
                    lv_action_1_0=(Token)match(input,80,FOLLOW_10); 

                    						newLeafNode(lv_action_1_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_1_0, "Suspended");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_0_3());
                    			
                    // InternalSymboleo.g:3672:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSymboleo.g:3673:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSymboleo.g:3673:5: (otherlv_4= RULE_ID )
                    // InternalSymboleo.g:3674:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3691:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:3691:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:3692:4: () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:3692:4: ()
                    // InternalSymboleo.g:3693:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationResumedAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3699:4: ( (lv_action_7_0= 'Resumed' ) )
                    // InternalSymboleo.g:3700:5: (lv_action_7_0= 'Resumed' )
                    {
                    // InternalSymboleo.g:3700:5: (lv_action_7_0= 'Resumed' )
                    // InternalSymboleo.g:3701:6: lv_action_7_0= 'Resumed'
                    {
                    lv_action_7_0=(Token)match(input,82,FOLLOW_10); 

                    						newLeafNode(lv_action_7_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_7_0, "Resumed");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_8, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    otherlv_9=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_1_3());
                    			
                    // InternalSymboleo.g:3721:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSymboleo.g:3722:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSymboleo.g:3722:5: (otherlv_10= RULE_ID )
                    // InternalSymboleo.g:3723:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3740:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    {
                    // InternalSymboleo.g:3740:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    // InternalSymboleo.g:3741:4: () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')'
                    {
                    // InternalSymboleo.g:3741:4: ()
                    // InternalSymboleo.g:3742:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationDischargedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3748:4: ( (lv_action_13_0= 'Discharged' ) )
                    // InternalSymboleo.g:3749:5: (lv_action_13_0= 'Discharged' )
                    {
                    // InternalSymboleo.g:3749:5: (lv_action_13_0= 'Discharged' )
                    // InternalSymboleo.g:3750:6: lv_action_13_0= 'Discharged'
                    {
                    lv_action_13_0=(Token)match(input,83,FOLLOW_10); 

                    						newLeafNode(lv_action_13_0, grammarAccess.getPowerFunctionAccess().getActionDischargedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_13_0, "Discharged");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_14, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    otherlv_15=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_2_3());
                    			
                    // InternalSymboleo.g:3770:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSymboleo.g:3771:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSymboleo.g:3771:5: (otherlv_16= RULE_ID )
                    // InternalSymboleo.g:3772:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3789:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    {
                    // InternalSymboleo.g:3789:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    // InternalSymboleo.g:3790:4: () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')'
                    {
                    // InternalSymboleo.g:3790:4: ()
                    // InternalSymboleo.g:3791:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTerminatedAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3797:4: ( (lv_action_19_0= 'Terminated' ) )
                    // InternalSymboleo.g:3798:5: (lv_action_19_0= 'Terminated' )
                    {
                    // InternalSymboleo.g:3798:5: (lv_action_19_0= 'Terminated' )
                    // InternalSymboleo.g:3799:6: lv_action_19_0= 'Terminated'
                    {
                    lv_action_19_0=(Token)match(input,84,FOLLOW_10); 

                    						newLeafNode(lv_action_19_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_19_0, "Terminated");
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_20, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    otherlv_21=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_3_3());
                    			
                    // InternalSymboleo.g:3819:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSymboleo.g:3820:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSymboleo.g:3820:5: (otherlv_22= RULE_ID )
                    // InternalSymboleo.g:3821:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3838:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    {
                    // InternalSymboleo.g:3838:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    // InternalSymboleo.g:3839:4: () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')'
                    {
                    // InternalSymboleo.g:3839:4: ()
                    // InternalSymboleo.g:3840:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTriggeredAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3846:4: ( (lv_action_25_0= 'Triggered' ) )
                    // InternalSymboleo.g:3847:5: (lv_action_25_0= 'Triggered' )
                    {
                    // InternalSymboleo.g:3847:5: (lv_action_25_0= 'Triggered' )
                    // InternalSymboleo.g:3848:6: lv_action_25_0= 'Triggered'
                    {
                    lv_action_25_0=(Token)match(input,85,FOLLOW_10); 

                    						newLeafNode(lv_action_25_0, grammarAccess.getPowerFunctionAccess().getActionTriggeredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_25_0, "Triggered");
                    					

                    }


                    }

                    otherlv_26=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_26, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    otherlv_27=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_4_3());
                    			
                    // InternalSymboleo.g:3868:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSymboleo.g:3869:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSymboleo.g:3869:5: (otherlv_28= RULE_ID )
                    // InternalSymboleo.g:3870:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3887:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    {
                    // InternalSymboleo.g:3887:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    // InternalSymboleo.g:3888:4: () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')'
                    {
                    // InternalSymboleo.g:3888:4: ()
                    // InternalSymboleo.g:3889:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractSuspendedAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3895:4: ( (lv_action_31_0= 'Suspended' ) )
                    // InternalSymboleo.g:3896:5: (lv_action_31_0= 'Suspended' )
                    {
                    // InternalSymboleo.g:3896:5: (lv_action_31_0= 'Suspended' )
                    // InternalSymboleo.g:3897:6: lv_action_31_0= 'Suspended'
                    {
                    lv_action_31_0=(Token)match(input,80,FOLLOW_10); 

                    						newLeafNode(lv_action_31_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_31_0, "Suspended");
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,17,FOLLOW_53); 

                    				newLeafNode(otherlv_32, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:3913:4: ( (lv_norm_33_0= 'self' ) )
                    // InternalSymboleo.g:3914:5: (lv_norm_33_0= 'self' )
                    {
                    // InternalSymboleo.g:3914:5: (lv_norm_33_0= 'self' )
                    // InternalSymboleo.g:3915:6: lv_norm_33_0= 'self'
                    {
                    lv_norm_33_0=(Token)match(input,86,FOLLOW_12); 

                    						newLeafNode(lv_norm_33_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_33_0, "self");
                    					

                    }


                    }

                    otherlv_34=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_34, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:3933:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    {
                    // InternalSymboleo.g:3933:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    // InternalSymboleo.g:3934:4: () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')'
                    {
                    // InternalSymboleo.g:3934:4: ()
                    // InternalSymboleo.g:3935:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractResumedAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3941:4: ( (lv_action_36_0= 'Resumed' ) )
                    // InternalSymboleo.g:3942:5: (lv_action_36_0= 'Resumed' )
                    {
                    // InternalSymboleo.g:3942:5: (lv_action_36_0= 'Resumed' )
                    // InternalSymboleo.g:3943:6: lv_action_36_0= 'Resumed'
                    {
                    lv_action_36_0=(Token)match(input,82,FOLLOW_10); 

                    						newLeafNode(lv_action_36_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_36_0, "Resumed");
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,17,FOLLOW_53); 

                    				newLeafNode(otherlv_37, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalSymboleo.g:3959:4: ( (lv_norm_38_0= 'self' ) )
                    // InternalSymboleo.g:3960:5: (lv_norm_38_0= 'self' )
                    {
                    // InternalSymboleo.g:3960:5: (lv_norm_38_0= 'self' )
                    // InternalSymboleo.g:3961:6: lv_norm_38_0= 'self'
                    {
                    lv_norm_38_0=(Token)match(input,86,FOLLOW_12); 

                    						newLeafNode(lv_norm_38_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_38_0, "self");
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_6_4());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:3979:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    {
                    // InternalSymboleo.g:3979:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    // InternalSymboleo.g:3980:4: () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')'
                    {
                    // InternalSymboleo.g:3980:4: ()
                    // InternalSymboleo.g:3981:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractTerminatedAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3987:4: ( (lv_action_41_0= 'Terminated' ) )
                    // InternalSymboleo.g:3988:5: (lv_action_41_0= 'Terminated' )
                    {
                    // InternalSymboleo.g:3988:5: (lv_action_41_0= 'Terminated' )
                    // InternalSymboleo.g:3989:6: lv_action_41_0= 'Terminated'
                    {
                    lv_action_41_0=(Token)match(input,84,FOLLOW_10); 

                    						newLeafNode(lv_action_41_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_41_0, "Terminated");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,17,FOLLOW_53); 

                    				newLeafNode(otherlv_42, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalSymboleo.g:4005:4: ( (lv_norm_43_0= 'self' ) )
                    // InternalSymboleo.g:4006:5: (lv_norm_43_0= 'self' )
                    {
                    // InternalSymboleo.g:4006:5: (lv_norm_43_0= 'self' )
                    // InternalSymboleo.g:4007:6: lv_norm_43_0= 'self'
                    {
                    lv_norm_43_0=(Token)match(input,86,FOLLOW_12); 

                    						newLeafNode(lv_norm_43_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_43_0, "self");
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_44, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_7_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerFunction"


    // $ANTLR start "entryRuleProposition"
    // InternalSymboleo.g:4028:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalSymboleo.g:4028:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalSymboleo.g:4029:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalSymboleo.g:4035:1: ruleProposition returns [EObject current=null] : this_POr_0= rulePOr ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        EObject this_POr_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4041:2: (this_POr_0= rulePOr )
            // InternalSymboleo.g:4042:2: this_POr_0= rulePOr
            {

            		newCompositeNode(grammarAccess.getPropositionAccess().getPOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_POr_0=rulePOr();

            state._fsp--;


            		current = this_POr_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRulePOr"
    // InternalSymboleo.g:4053:1: entryRulePOr returns [EObject current=null] : iv_rulePOr= rulePOr EOF ;
    public final EObject entryRulePOr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePOr = null;


        try {
            // InternalSymboleo.g:4053:44: (iv_rulePOr= rulePOr EOF )
            // InternalSymboleo.g:4054:2: iv_rulePOr= rulePOr EOF
            {
             newCompositeNode(grammarAccess.getPOrRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePOr=rulePOr();

            state._fsp--;

             current =iv_rulePOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePOr"


    // $ANTLR start "rulePOr"
    // InternalSymboleo.g:4060:1: rulePOr returns [EObject current=null] : (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) ;
    public final EObject rulePOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PAnd_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4066:2: ( (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) )
            // InternalSymboleo.g:4067:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            {
            // InternalSymboleo.g:4067:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            // InternalSymboleo.g:4068:3: this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getPOrAccess().getPAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_39);
            this_PAnd_0=rulePAnd();

            state._fsp--;


            			current = this_PAnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:4076:3: ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==43) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalSymboleo.g:4077:4: () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) )
            	    {
            	    // InternalSymboleo.g:4077:4: ()
            	    // InternalSymboleo.g:4078:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPOrAccess().getPOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_48); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:4088:4: ( (lv_right_3_0= rulePAnd ) )
            	    // InternalSymboleo.g:4089:5: (lv_right_3_0= rulePAnd )
            	    {
            	    // InternalSymboleo.g:4089:5: (lv_right_3_0= rulePAnd )
            	    // InternalSymboleo.g:4090:6: lv_right_3_0= rulePAnd
            	    {

            	    						newCompositeNode(grammarAccess.getPOrAccess().getRightPAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=rulePAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PAnd");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePOr"


    // $ANTLR start "entryRulePAnd"
    // InternalSymboleo.g:4112:1: entryRulePAnd returns [EObject current=null] : iv_rulePAnd= rulePAnd EOF ;
    public final EObject entryRulePAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAnd = null;


        try {
            // InternalSymboleo.g:4112:45: (iv_rulePAnd= rulePAnd EOF )
            // InternalSymboleo.g:4113:2: iv_rulePAnd= rulePAnd EOF
            {
             newCompositeNode(grammarAccess.getPAndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAnd=rulePAnd();

            state._fsp--;

             current =iv_rulePAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAnd"


    // $ANTLR start "rulePAnd"
    // InternalSymboleo.g:4119:1: rulePAnd returns [EObject current=null] : (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) ;
    public final EObject rulePAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PEquality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4125:2: ( (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) )
            // InternalSymboleo.g:4126:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            {
            // InternalSymboleo.g:4126:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            // InternalSymboleo.g:4127:3: this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getPAndAccess().getPEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_40);
            this_PEquality_0=rulePEquality();

            state._fsp--;


            			current = this_PEquality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:4135:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==44) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalSymboleo.g:4136:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) )
            	    {
            	    // InternalSymboleo.g:4136:4: ()
            	    // InternalSymboleo.g:4137:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPAndAccess().getPAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_48); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:4147:4: ( (lv_right_3_0= rulePEquality ) )
            	    // InternalSymboleo.g:4148:5: (lv_right_3_0= rulePEquality )
            	    {
            	    // InternalSymboleo.g:4148:5: (lv_right_3_0= rulePEquality )
            	    // InternalSymboleo.g:4149:6: lv_right_3_0= rulePEquality
            	    {

            	    						newCompositeNode(grammarAccess.getPAndAccess().getRightPEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=rulePEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PEquality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAnd"


    // $ANTLR start "entryRulePEquality"
    // InternalSymboleo.g:4171:1: entryRulePEquality returns [EObject current=null] : iv_rulePEquality= rulePEquality EOF ;
    public final EObject entryRulePEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEquality = null;


        try {
            // InternalSymboleo.g:4171:50: (iv_rulePEquality= rulePEquality EOF )
            // InternalSymboleo.g:4172:2: iv_rulePEquality= rulePEquality EOF
            {
             newCompositeNode(grammarAccess.getPEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePEquality=rulePEquality();

            state._fsp--;

             current =iv_rulePEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEquality"


    // $ANTLR start "rulePEquality"
    // InternalSymboleo.g:4178:1: rulePEquality returns [EObject current=null] : (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) ;
    public final EObject rulePEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PComparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4184:2: ( (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) )
            // InternalSymboleo.g:4185:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            {
            // InternalSymboleo.g:4185:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            // InternalSymboleo.g:4186:3: this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getPEqualityAccess().getPComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_PComparison_0=rulePComparison();

            state._fsp--;


            			current = this_PComparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:4194:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=45 && LA62_0<=46)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalSymboleo.g:4195:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) )
            	    {
            	    // InternalSymboleo.g:4195:4: ()
            	    // InternalSymboleo.g:4196:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPEqualityAccess().getPEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:4202:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalSymboleo.g:4203:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalSymboleo.g:4203:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalSymboleo.g:4204:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalSymboleo.g:4204:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt61=2;
            	    int LA61_0 = input.LA(1);

            	    if ( (LA61_0==45) ) {
            	        alt61=1;
            	    }
            	    else if ( (LA61_0==46) ) {
            	        alt61=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt61) {
            	        case 1 :
            	            // InternalSymboleo.g:4205:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,45,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:4216:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,46,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:4229:4: ( (lv_right_3_0= rulePComparison ) )
            	    // InternalSymboleo.g:4230:5: (lv_right_3_0= rulePComparison )
            	    {
            	    // InternalSymboleo.g:4230:5: (lv_right_3_0= rulePComparison )
            	    // InternalSymboleo.g:4231:6: lv_right_3_0= rulePComparison
            	    {

            	    						newCompositeNode(grammarAccess.getPEqualityAccess().getRightPComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=rulePComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PComparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEquality"


    // $ANTLR start "entryRulePComparison"
    // InternalSymboleo.g:4253:1: entryRulePComparison returns [EObject current=null] : iv_rulePComparison= rulePComparison EOF ;
    public final EObject entryRulePComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePComparison = null;


        try {
            // InternalSymboleo.g:4253:52: (iv_rulePComparison= rulePComparison EOF )
            // InternalSymboleo.g:4254:2: iv_rulePComparison= rulePComparison EOF
            {
             newCompositeNode(grammarAccess.getPComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePComparison=rulePComparison();

            state._fsp--;

             current =iv_rulePComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePComparison"


    // $ANTLR start "rulePComparison"
    // InternalSymboleo.g:4260:1: rulePComparison returns [EObject current=null] : (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) ;
    public final EObject rulePComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PAtomicExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4266:2: ( (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) )
            // InternalSymboleo.g:4267:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            {
            // InternalSymboleo.g:4267:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            // InternalSymboleo.g:4268:3: this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPComparisonAccess().getPAtomicExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_42);
            this_PAtomicExpression_0=rulePAtomicExpression();

            state._fsp--;


            			current = this_PAtomicExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:4276:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=47 && LA64_0<=50)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalSymboleo.g:4277:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) )
            	    {
            	    // InternalSymboleo.g:4277:4: ()
            	    // InternalSymboleo.g:4278:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPComparisonAccess().getPComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:4284:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalSymboleo.g:4285:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalSymboleo.g:4285:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalSymboleo.g:4286:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalSymboleo.g:4286:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt63=4;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        alt63=1;
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt63=2;
            	        }
            	        break;
            	    case 49:
            	        {
            	        alt63=3;
            	        }
            	        break;
            	    case 50:
            	        {
            	        alt63=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 63, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt63) {
            	        case 1 :
            	            // InternalSymboleo.g:4287:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,47,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:4298:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,48,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:4309:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,49,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getPComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSymboleo.g:4320:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,50,FOLLOW_48); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getPComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:4333:4: ( (lv_right_3_0= rulePAtomicExpression ) )
            	    // InternalSymboleo.g:4334:5: (lv_right_3_0= rulePAtomicExpression )
            	    {
            	    // InternalSymboleo.g:4334:5: (lv_right_3_0= rulePAtomicExpression )
            	    // InternalSymboleo.g:4335:6: lv_right_3_0= rulePAtomicExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPComparisonAccess().getRightPAtomicExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=rulePAtomicExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PAtomicExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePComparison"


    // $ANTLR start "entryRulePAtomicExpression"
    // InternalSymboleo.g:4357:1: entryRulePAtomicExpression returns [EObject current=null] : iv_rulePAtomicExpression= rulePAtomicExpression EOF ;
    public final EObject entryRulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAtomicExpression = null;


        try {
            // InternalSymboleo.g:4357:58: (iv_rulePAtomicExpression= rulePAtomicExpression EOF )
            // InternalSymboleo.g:4358:2: iv_rulePAtomicExpression= rulePAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getPAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAtomicExpression=rulePAtomicExpression();

            state._fsp--;

             current =iv_rulePAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAtomicExpression"


    // $ANTLR start "rulePAtomicExpression"
    // InternalSymboleo.g:4364:1: rulePAtomicExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) ;
    public final EObject rulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_value_19_0=null;
        Token lv_value_21_0=null;
        Token lv_value_25_0=null;
        Token lv_value_27_0=null;
        EObject lv_inner_2_0 = null;

        EObject lv_negated_6_0 = null;

        EObject lv_predicateFunction_8_0 = null;

        EObject lv_function_10_0 = null;

        EObject lv_variable_17_0 = null;

        AntlrDatatypeRuleToken lv_value_23_0 = null;

        AntlrDatatypeRuleToken lv_value_29_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4370:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) )
            // InternalSymboleo.g:4371:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            {
            // InternalSymboleo.g:4371:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            int alt65=12;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // InternalSymboleo.g:4372:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    {
                    // InternalSymboleo.g:4372:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    // InternalSymboleo.g:4373:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')'
                    {
                    // InternalSymboleo.g:4373:4: ()
                    // InternalSymboleo.g:4374:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymboleo.g:4384:4: ( (lv_inner_2_0= ruleProposition ) )
                    // InternalSymboleo.g:4385:5: (lv_inner_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:4385:5: (lv_inner_2_0= ruleProposition )
                    // InternalSymboleo.g:4386:6: lv_inner_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getInnerPropositionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_inner_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4409:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    {
                    // InternalSymboleo.g:4409:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    // InternalSymboleo.g:4410:4: () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) )
                    {
                    // InternalSymboleo.g:4410:4: ()
                    // InternalSymboleo.g:4411:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,55,FOLLOW_48); 

                    				newLeafNode(otherlv_5, grammarAccess.getPAtomicExpressionAccess().getNotKeyword_1_1());
                    			
                    // InternalSymboleo.g:4421:4: ( (lv_negated_6_0= rulePAtomicExpression ) )
                    // InternalSymboleo.g:4422:5: (lv_negated_6_0= rulePAtomicExpression )
                    {
                    // InternalSymboleo.g:4422:5: (lv_negated_6_0= rulePAtomicExpression )
                    // InternalSymboleo.g:4423:6: lv_negated_6_0= rulePAtomicExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomicExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_negated_6_0=rulePAtomicExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"negated",
                    							lv_negated_6_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PAtomicExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:4442:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    {
                    // InternalSymboleo.g:4442:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    // InternalSymboleo.g:4443:4: () ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    {
                    // InternalSymboleo.g:4443:4: ()
                    // InternalSymboleo.g:4444:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4450:4: ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    // InternalSymboleo.g:4451:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    {
                    // InternalSymboleo.g:4451:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    // InternalSymboleo.g:4452:6: lv_predicateFunction_8_0= rulePredicateFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getPredicateFunctionPredicateFunctionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_predicateFunction_8_0=rulePredicateFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"predicateFunction",
                    							lv_predicateFunction_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PredicateFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:4471:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    {
                    // InternalSymboleo.g:4471:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    // InternalSymboleo.g:4472:4: () ( (lv_function_10_0= ruleOtherFunction ) )
                    {
                    // InternalSymboleo.g:4472:4: ()
                    // InternalSymboleo.g:4473:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomFunctionAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4479:4: ( (lv_function_10_0= ruleOtherFunction ) )
                    // InternalSymboleo.g:4480:5: (lv_function_10_0= ruleOtherFunction )
                    {
                    // InternalSymboleo.g:4480:5: (lv_function_10_0= ruleOtherFunction )
                    // InternalSymboleo.g:4481:6: lv_function_10_0= ruleOtherFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getFunctionOtherFunctionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_10_0=ruleOtherFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.OtherFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:4500:3: ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' )
                    {
                    // InternalSymboleo.g:4500:3: ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' )
                    // InternalSymboleo.g:4501:4: () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')'
                    {
                    // InternalSymboleo.g:4501:4: ()
                    // InternalSymboleo.g:4502:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomEnumAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4508:4: ( (otherlv_12= RULE_ID ) )
                    // InternalSymboleo.g:4509:5: (otherlv_12= RULE_ID )
                    {
                    // InternalSymboleo.g:4509:5: (otherlv_12= RULE_ID )
                    // InternalSymboleo.g:4510:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_12, grammarAccess.getPAtomicExpressionAccess().getEnumerationEnumerationCrossReference_4_1_0());
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalSymboleo.g:4525:4: ( (otherlv_14= RULE_ID ) )
                    // InternalSymboleo.g:4526:5: (otherlv_14= RULE_ID )
                    {
                    // InternalSymboleo.g:4526:5: (otherlv_14= RULE_ID )
                    // InternalSymboleo.g:4527:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_14, grammarAccess.getPAtomicExpressionAccess().getEnumItemEnumItemCrossReference_4_3_0());
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_4_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:4544:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:4544:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:4545:4: () ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:4545:4: ()
                    // InternalSymboleo.g:4546:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomVariableAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4552:4: ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:4553:5: (lv_variable_17_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:4553:5: (lv_variable_17_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:4554:6: lv_variable_17_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getVariableVariableDotExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_17_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:4573:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    {
                    // InternalSymboleo.g:4573:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    // InternalSymboleo.g:4574:4: () ( (lv_value_19_0= 'true' ) )
                    {
                    // InternalSymboleo.g:4574:4: ()
                    // InternalSymboleo.g:4575:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateTrueLiteralAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4581:4: ( (lv_value_19_0= 'true' ) )
                    // InternalSymboleo.g:4582:5: (lv_value_19_0= 'true' )
                    {
                    // InternalSymboleo.g:4582:5: (lv_value_19_0= 'true' )
                    // InternalSymboleo.g:4583:6: lv_value_19_0= 'true'
                    {
                    lv_value_19_0=(Token)match(input,56,FOLLOW_2); 

                    						newLeafNode(lv_value_19_0, grammarAccess.getPAtomicExpressionAccess().getValueTrueKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_19_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:4597:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    {
                    // InternalSymboleo.g:4597:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    // InternalSymboleo.g:4598:4: () ( (lv_value_21_0= 'false' ) )
                    {
                    // InternalSymboleo.g:4598:4: ()
                    // InternalSymboleo.g:4599:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateFalseLiteralAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4605:4: ( (lv_value_21_0= 'false' ) )
                    // InternalSymboleo.g:4606:5: (lv_value_21_0= 'false' )
                    {
                    // InternalSymboleo.g:4606:5: (lv_value_21_0= 'false' )
                    // InternalSymboleo.g:4607:6: lv_value_21_0= 'false'
                    {
                    lv_value_21_0=(Token)match(input,57,FOLLOW_2); 

                    						newLeafNode(lv_value_21_0, grammarAccess.getPAtomicExpressionAccess().getValueFalseKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_21_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:4621:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    {
                    // InternalSymboleo.g:4621:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    // InternalSymboleo.g:4622:4: () ( (lv_value_23_0= ruleDouble ) )
                    {
                    // InternalSymboleo.g:4622:4: ()
                    // InternalSymboleo.g:4623:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDoubleLiteralAction_8_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4629:4: ( (lv_value_23_0= ruleDouble ) )
                    // InternalSymboleo.g:4630:5: (lv_value_23_0= ruleDouble )
                    {
                    // InternalSymboleo.g:4630:5: (lv_value_23_0= ruleDouble )
                    // InternalSymboleo.g:4631:6: lv_value_23_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDoubleParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_23_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_23_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalSymboleo.g:4650:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:4650:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    // InternalSymboleo.g:4651:4: () ( (lv_value_25_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:4651:4: ()
                    // InternalSymboleo.g:4652:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomIntLiteralAction_9_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4658:4: ( (lv_value_25_0= RULE_INT ) )
                    // InternalSymboleo.g:4659:5: (lv_value_25_0= RULE_INT )
                    {
                    // InternalSymboleo.g:4659:5: (lv_value_25_0= RULE_INT )
                    // InternalSymboleo.g:4660:6: lv_value_25_0= RULE_INT
                    {
                    lv_value_25_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_25_0, grammarAccess.getPAtomicExpressionAccess().getValueINTTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_25_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalSymboleo.g:4678:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    {
                    // InternalSymboleo.g:4678:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    // InternalSymboleo.g:4679:4: () ( (lv_value_27_0= RULE_STRING ) )
                    {
                    // InternalSymboleo.g:4679:4: ()
                    // InternalSymboleo.g:4680:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomStringLiteralAction_10_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4686:4: ( (lv_value_27_0= RULE_STRING ) )
                    // InternalSymboleo.g:4687:5: (lv_value_27_0= RULE_STRING )
                    {
                    // InternalSymboleo.g:4687:5: (lv_value_27_0= RULE_STRING )
                    // InternalSymboleo.g:4688:6: lv_value_27_0= RULE_STRING
                    {
                    lv_value_27_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_27_0, grammarAccess.getPAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_27_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalSymboleo.g:4706:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    {
                    // InternalSymboleo.g:4706:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    // InternalSymboleo.g:4707:4: () ( (lv_value_29_0= ruleDate ) )
                    {
                    // InternalSymboleo.g:4707:4: ()
                    // InternalSymboleo.g:4708:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDateLiteralAction_11_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4714:4: ( (lv_value_29_0= ruleDate ) )
                    // InternalSymboleo.g:4715:5: (lv_value_29_0= ruleDate )
                    {
                    // InternalSymboleo.g:4715:5: (lv_value_29_0= ruleDate )
                    // InternalSymboleo.g:4716:6: lv_value_29_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDateParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_29_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_29_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAtomicExpression"


    // $ANTLR start "entryRulePredicateFunction"
    // InternalSymboleo.g:4738:1: entryRulePredicateFunction returns [EObject current=null] : iv_rulePredicateFunction= rulePredicateFunction EOF ;
    public final EObject entryRulePredicateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateFunction = null;


        try {
            // InternalSymboleo.g:4738:58: (iv_rulePredicateFunction= rulePredicateFunction EOF )
            // InternalSymboleo.g:4739:2: iv_rulePredicateFunction= rulePredicateFunction EOF
            {
             newCompositeNode(grammarAccess.getPredicateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicateFunction=rulePredicateFunction();

            state._fsp--;

             current =iv_rulePredicateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateFunction"


    // $ANTLR start "rulePredicateFunction"
    // InternalSymboleo.g:4745:1: rulePredicateFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) ) ;
    public final EObject rulePredicateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_name_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_name_20_0=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token lv_name_27_0=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token lv_name_34_0=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token lv_name_41_0=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token lv_name_48_0=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token lv_name_55_0=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        Token otherlv_60=null;
        Token otherlv_62=null;
        Token lv_name_64_0=null;
        Token otherlv_65=null;
        Token otherlv_67=null;
        Token otherlv_69=null;
        EObject lv_event_3_0 = null;

        EObject lv_event_8_0 = null;

        EObject lv_point_10_0 = null;

        EObject lv_event_15_0 = null;

        EObject lv_point_17_0 = null;

        EObject lv_event_22_0 = null;

        EObject lv_interval_24_0 = null;

        EObject lv_event1_29_0 = null;

        EObject lv_event2_31_0 = null;

        EObject lv_event1_36_0 = null;

        EObject lv_event2_38_0 = null;

        EObject lv_event_43_0 = null;

        EObject lv_point_45_0 = null;

        EObject lv_situation_50_0 = null;

        EObject lv_interval_52_0 = null;

        EObject lv_event_57_0 = null;

        EObject lv_assignment_59_0 = null;

        EObject lv_assignment_61_0 = null;

        EObject lv_assignment_66_0 = null;

        EObject lv_assignment_68_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4751:2: ( ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) ) )
            // InternalSymboleo.g:4752:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) )
            {
            // InternalSymboleo.g:4752:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) )
            int alt70=10;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt70=1;
                }
                break;
            case 88:
                {
                alt70=2;
                }
                break;
            case 89:
                {
                alt70=3;
                }
                break;
            case 90:
                {
                alt70=4;
                }
                break;
            case 91:
                {
                alt70=5;
                }
                break;
            case 92:
                {
                alt70=6;
                }
                break;
            case 93:
                {
                alt70=7;
                }
                break;
            case 94:
                {
                alt70=8;
                }
                break;
            case 95:
                {
                alt70=9;
                }
                break;
            case 96:
                {
                alt70=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalSymboleo.g:4753:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    {
                    // InternalSymboleo.g:4753:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    // InternalSymboleo.g:4754:4: () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')'
                    {
                    // InternalSymboleo.g:4754:4: ()
                    // InternalSymboleo.g:4755:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4761:4: ( (lv_name_1_0= 'Happens' ) )
                    // InternalSymboleo.g:4762:5: (lv_name_1_0= 'Happens' )
                    {
                    // InternalSymboleo.g:4762:5: (lv_name_1_0= 'Happens' )
                    // InternalSymboleo.g:4763:6: lv_name_1_0= 'Happens'
                    {
                    lv_name_1_0=(Token)match(input,87,FOLLOW_10); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getPredicateFunctionAccess().getNameHappensKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "Happens");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:4779:4: ( (lv_event_3_0= ruleEvent ) )
                    // InternalSymboleo.g:4780:5: (lv_event_3_0= ruleEvent )
                    {
                    // InternalSymboleo.g:4780:5: (lv_event_3_0= ruleEvent )
                    // InternalSymboleo.g:4781:6: lv_event_3_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event_3_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4804:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:4804:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:4805:4: () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:4805:4: ()
                    // InternalSymboleo.g:4806:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4812:4: ( (lv_name_6_0= 'WhappensBefore' ) )
                    // InternalSymboleo.g:4813:5: (lv_name_6_0= 'WhappensBefore' )
                    {
                    // InternalSymboleo.g:4813:5: (lv_name_6_0= 'WhappensBefore' )
                    // InternalSymboleo.g:4814:6: lv_name_6_0= 'WhappensBefore'
                    {
                    lv_name_6_0=(Token)match(input,88,FOLLOW_10); 

                    						newLeafNode(lv_name_6_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_6_0, "WhappensBefore");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_7, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:4830:4: ( (lv_event_8_0= ruleEvent ) )
                    // InternalSymboleo.g:4831:5: (lv_event_8_0= ruleEvent )
                    {
                    // InternalSymboleo.g:4831:5: (lv_event_8_0= ruleEvent )
                    // InternalSymboleo.g:4832:6: lv_event_8_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_8_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,18,FOLLOW_55); 

                    				newLeafNode(otherlv_9, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:4853:4: ( (lv_point_10_0= rulePoint ) )
                    // InternalSymboleo.g:4854:5: (lv_point_10_0= rulePoint )
                    {
                    // InternalSymboleo.g:4854:5: (lv_point_10_0= rulePoint )
                    // InternalSymboleo.g:4855:6: lv_point_10_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_10_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:4878:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    {
                    // InternalSymboleo.g:4878:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    // InternalSymboleo.g:4879:4: () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')'
                    {
                    // InternalSymboleo.g:4879:4: ()
                    // InternalSymboleo.g:4880:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4886:4: ( (lv_name_13_0= 'ShappensBefore' ) )
                    // InternalSymboleo.g:4887:5: (lv_name_13_0= 'ShappensBefore' )
                    {
                    // InternalSymboleo.g:4887:5: (lv_name_13_0= 'ShappensBefore' )
                    // InternalSymboleo.g:4888:6: lv_name_13_0= 'ShappensBefore'
                    {
                    lv_name_13_0=(Token)match(input,89,FOLLOW_10); 

                    						newLeafNode(lv_name_13_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_13_0, "ShappensBefore");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_14, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:4904:4: ( (lv_event_15_0= ruleEvent ) )
                    // InternalSymboleo.g:4905:5: (lv_event_15_0= ruleEvent )
                    {
                    // InternalSymboleo.g:4905:5: (lv_event_15_0= ruleEvent )
                    // InternalSymboleo.g:4906:6: lv_event_15_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_15_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_15_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,18,FOLLOW_55); 

                    				newLeafNode(otherlv_16, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_2_4());
                    			
                    // InternalSymboleo.g:4927:4: ( (lv_point_17_0= rulePoint ) )
                    // InternalSymboleo.g:4928:5: (lv_point_17_0= rulePoint )
                    {
                    // InternalSymboleo.g:4928:5: (lv_point_17_0= rulePoint )
                    // InternalSymboleo.g:4929:6: lv_point_17_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_2_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_17_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_2_6());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:4952:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    {
                    // InternalSymboleo.g:4952:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    // InternalSymboleo.g:4953:4: () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')'
                    {
                    // InternalSymboleo.g:4953:4: ()
                    // InternalSymboleo.g:4954:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensWithinAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4960:4: ( (lv_name_20_0= 'HappensWithin' ) )
                    // InternalSymboleo.g:4961:5: (lv_name_20_0= 'HappensWithin' )
                    {
                    // InternalSymboleo.g:4961:5: (lv_name_20_0= 'HappensWithin' )
                    // InternalSymboleo.g:4962:6: lv_name_20_0= 'HappensWithin'
                    {
                    lv_name_20_0=(Token)match(input,90,FOLLOW_10); 

                    						newLeafNode(lv_name_20_0, grammarAccess.getPredicateFunctionAccess().getNameHappensWithinKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_20_0, "HappensWithin");
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_21, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    // InternalSymboleo.g:4978:4: ( (lv_event_22_0= ruleEvent ) )
                    // InternalSymboleo.g:4979:5: (lv_event_22_0= ruleEvent )
                    {
                    // InternalSymboleo.g:4979:5: (lv_event_22_0= ruleEvent )
                    // InternalSymboleo.g:4980:6: lv_event_22_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_22_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_22_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_56); 

                    				newLeafNode(otherlv_23, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_3_4());
                    			
                    // InternalSymboleo.g:5001:4: ( (lv_interval_24_0= ruleInterval ) )
                    // InternalSymboleo.g:5002:5: (lv_interval_24_0= ruleInterval )
                    {
                    // InternalSymboleo.g:5002:5: (lv_interval_24_0= ruleInterval )
                    // InternalSymboleo.g:5003:6: lv_interval_24_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_3_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_interval_24_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_24_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_25=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_25, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_3_6());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:5026:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    {
                    // InternalSymboleo.g:5026:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    // InternalSymboleo.g:5027:4: () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')'
                    {
                    // InternalSymboleo.g:5027:4: ()
                    // InternalSymboleo.g:5028:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeEventAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5034:4: ( (lv_name_27_0= 'WhappensBeforeE' ) )
                    // InternalSymboleo.g:5035:5: (lv_name_27_0= 'WhappensBeforeE' )
                    {
                    // InternalSymboleo.g:5035:5: (lv_name_27_0= 'WhappensBeforeE' )
                    // InternalSymboleo.g:5036:6: lv_name_27_0= 'WhappensBeforeE'
                    {
                    lv_name_27_0=(Token)match(input,91,FOLLOW_10); 

                    						newLeafNode(lv_name_27_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeEKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_27_0, "WhappensBeforeE");
                    					

                    }


                    }

                    otherlv_28=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_28, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalSymboleo.g:5052:4: ( (lv_event1_29_0= ruleEvent ) )
                    // InternalSymboleo.g:5053:5: (lv_event1_29_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5053:5: (lv_event1_29_0= ruleEvent )
                    // InternalSymboleo.g:5054:6: lv_event1_29_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event1_29_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_29_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_30=(Token)match(input,18,FOLLOW_54); 

                    				newLeafNode(otherlv_30, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_4_4());
                    			
                    // InternalSymboleo.g:5075:4: ( (lv_event2_31_0= ruleEvent ) )
                    // InternalSymboleo.g:5076:5: (lv_event2_31_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5076:5: (lv_event2_31_0= ruleEvent )
                    // InternalSymboleo.g:5077:6: lv_event2_31_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_4_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event2_31_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_31_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_32, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_4_6());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:5100:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    {
                    // InternalSymboleo.g:5100:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    // InternalSymboleo.g:5101:4: () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')'
                    {
                    // InternalSymboleo.g:5101:4: ()
                    // InternalSymboleo.g:5102:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeEventAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5108:4: ( (lv_name_34_0= 'ShappensBeforeE' ) )
                    // InternalSymboleo.g:5109:5: (lv_name_34_0= 'ShappensBeforeE' )
                    {
                    // InternalSymboleo.g:5109:5: (lv_name_34_0= 'ShappensBeforeE' )
                    // InternalSymboleo.g:5110:6: lv_name_34_0= 'ShappensBeforeE'
                    {
                    lv_name_34_0=(Token)match(input,92,FOLLOW_10); 

                    						newLeafNode(lv_name_34_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeEKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_34_0, "ShappensBeforeE");
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_35, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:5126:4: ( (lv_event1_36_0= ruleEvent ) )
                    // InternalSymboleo.g:5127:5: (lv_event1_36_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5127:5: (lv_event1_36_0= ruleEvent )
                    // InternalSymboleo.g:5128:6: lv_event1_36_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_5_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event1_36_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_36_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,18,FOLLOW_54); 

                    				newLeafNode(otherlv_37, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_5_4());
                    			
                    // InternalSymboleo.g:5149:4: ( (lv_event2_38_0= ruleEvent ) )
                    // InternalSymboleo.g:5150:5: (lv_event2_38_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5150:5: (lv_event2_38_0= ruleEvent )
                    // InternalSymboleo.g:5151:6: lv_event2_38_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_5_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event2_38_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_38_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_5_6());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:5174:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    {
                    // InternalSymboleo.g:5174:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    // InternalSymboleo.g:5175:4: () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')'
                    {
                    // InternalSymboleo.g:5175:4: ()
                    // InternalSymboleo.g:5176:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAfterAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5182:4: ( (lv_name_41_0= 'HappensAfter' ) )
                    // InternalSymboleo.g:5183:5: (lv_name_41_0= 'HappensAfter' )
                    {
                    // InternalSymboleo.g:5183:5: (lv_name_41_0= 'HappensAfter' )
                    // InternalSymboleo.g:5184:6: lv_name_41_0= 'HappensAfter'
                    {
                    lv_name_41_0=(Token)match(input,93,FOLLOW_10); 

                    						newLeafNode(lv_name_41_0, grammarAccess.getPredicateFunctionAccess().getNameHappensAfterKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_41_0, "HappensAfter");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_42, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalSymboleo.g:5200:4: ( (lv_event_43_0= ruleEvent ) )
                    // InternalSymboleo.g:5201:5: (lv_event_43_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5201:5: (lv_event_43_0= ruleEvent )
                    // InternalSymboleo.g:5202:6: lv_event_43_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_43_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_43_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,18,FOLLOW_55); 

                    				newLeafNode(otherlv_44, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_6_4());
                    			
                    // InternalSymboleo.g:5223:4: ( (lv_point_45_0= rulePoint ) )
                    // InternalSymboleo.g:5224:5: (lv_point_45_0= rulePoint )
                    {
                    // InternalSymboleo.g:5224:5: (lv_point_45_0= rulePoint )
                    // InternalSymboleo.g:5225:6: lv_point_45_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_6_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_45_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_45_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_46=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_46, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_6_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:5248:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    {
                    // InternalSymboleo.g:5248:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    // InternalSymboleo.g:5249:4: () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')'
                    {
                    // InternalSymboleo.g:5249:4: ()
                    // InternalSymboleo.g:5250:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionOccursAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5256:4: ( (lv_name_48_0= 'Occurs' ) )
                    // InternalSymboleo.g:5257:5: (lv_name_48_0= 'Occurs' )
                    {
                    // InternalSymboleo.g:5257:5: (lv_name_48_0= 'Occurs' )
                    // InternalSymboleo.g:5258:6: lv_name_48_0= 'Occurs'
                    {
                    lv_name_48_0=(Token)match(input,94,FOLLOW_10); 

                    						newLeafNode(lv_name_48_0, grammarAccess.getPredicateFunctionAccess().getNameOccursKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_48_0, "Occurs");
                    					

                    }


                    }

                    otherlv_49=(Token)match(input,17,FOLLOW_56); 

                    				newLeafNode(otherlv_49, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalSymboleo.g:5274:4: ( (lv_situation_50_0= ruleSituation ) )
                    // InternalSymboleo.g:5275:5: (lv_situation_50_0= ruleSituation )
                    {
                    // InternalSymboleo.g:5275:5: (lv_situation_50_0= ruleSituation )
                    // InternalSymboleo.g:5276:6: lv_situation_50_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getSituationSituationParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_situation_50_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_50_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_51=(Token)match(input,18,FOLLOW_56); 

                    				newLeafNode(otherlv_51, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_7_4());
                    			
                    // InternalSymboleo.g:5297:4: ( (lv_interval_52_0= ruleInterval ) )
                    // InternalSymboleo.g:5298:5: (lv_interval_52_0= ruleInterval )
                    {
                    // InternalSymboleo.g:5298:5: (lv_interval_52_0= ruleInterval )
                    // InternalSymboleo.g:5299:6: lv_interval_52_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_7_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_interval_52_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_52_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_53=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_53, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_7_6());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:5322:3: ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' )
                    {
                    // InternalSymboleo.g:5322:3: ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' )
                    // InternalSymboleo.g:5323:4: () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')'
                    {
                    // InternalSymboleo.g:5323:4: ()
                    // InternalSymboleo.g:5324:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionAssignmentAction_8_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5330:4: ( (lv_name_55_0= 'HappensAssign' ) )
                    // InternalSymboleo.g:5331:5: (lv_name_55_0= 'HappensAssign' )
                    {
                    // InternalSymboleo.g:5331:5: (lv_name_55_0= 'HappensAssign' )
                    // InternalSymboleo.g:5332:6: lv_name_55_0= 'HappensAssign'
                    {
                    lv_name_55_0=(Token)match(input,95,FOLLOW_10); 

                    						newLeafNode(lv_name_55_0, grammarAccess.getPredicateFunctionAccess().getNameHappensAssignKeyword_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_55_0, "HappensAssign");
                    					

                    }


                    }

                    otherlv_56=(Token)match(input,17,FOLLOW_54); 

                    				newLeafNode(otherlv_56, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_8_2());
                    			
                    // InternalSymboleo.g:5348:4: ( (lv_event_57_0= ruleEvent ) )
                    // InternalSymboleo.g:5349:5: (lv_event_57_0= ruleEvent )
                    {
                    // InternalSymboleo.g:5349:5: (lv_event_57_0= ruleEvent )
                    // InternalSymboleo.g:5350:6: lv_event_57_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_8_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_57_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_57_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_58=(Token)match(input,18,FOLLOW_57); 

                    				newLeafNode(otherlv_58, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_8_4());
                    			
                    // InternalSymboleo.g:5371:4: ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_ID) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalSymboleo.g:5372:5: ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )*
                            {
                            // InternalSymboleo.g:5372:5: ( (lv_assignment_59_0= ruleOAssignment ) )
                            // InternalSymboleo.g:5373:6: (lv_assignment_59_0= ruleOAssignment )
                            {
                            // InternalSymboleo.g:5373:6: (lv_assignment_59_0= ruleOAssignment )
                            // InternalSymboleo.g:5374:7: lv_assignment_59_0= ruleOAssignment
                            {

                            							newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_8_5_0_0());
                            						
                            pushFollow(FOLLOW_58);
                            lv_assignment_59_0=ruleOAssignment();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            							}
                            							add(
                            								current,
                            								"assignment",
                            								lv_assignment_59_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSymboleo.g:5391:5: (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )*
                            loop66:
                            do {
                                int alt66=2;
                                int LA66_0 = input.LA(1);

                                if ( (LA66_0==12) ) {
                                    alt66=1;
                                }


                                switch (alt66) {
                            	case 1 :
                            	    // InternalSymboleo.g:5392:6: otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) )
                            	    {
                            	    otherlv_60=(Token)match(input,12,FOLLOW_3); 

                            	    						newLeafNode(otherlv_60, grammarAccess.getPredicateFunctionAccess().getSemicolonKeyword_8_5_1_0());
                            	    					
                            	    // InternalSymboleo.g:5396:6: ( (lv_assignment_61_0= ruleOAssignment ) )
                            	    // InternalSymboleo.g:5397:7: (lv_assignment_61_0= ruleOAssignment )
                            	    {
                            	    // InternalSymboleo.g:5397:7: (lv_assignment_61_0= ruleOAssignment )
                            	    // InternalSymboleo.g:5398:8: lv_assignment_61_0= ruleOAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_8_5_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_58);
                            	    lv_assignment_61_0=ruleOAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"assignment",
                            	    									lv_assignment_61_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop66;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_62=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_62, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_8_6());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalSymboleo.g:5423:3: ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' )
                    {
                    // InternalSymboleo.g:5423:3: ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' )
                    // InternalSymboleo.g:5424:4: () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')'
                    {
                    // InternalSymboleo.g:5424:4: ()
                    // InternalSymboleo.g:5425:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionAssignmentOnlyAction_9_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5431:4: ( (lv_name_64_0= 'Assign' ) )
                    // InternalSymboleo.g:5432:5: (lv_name_64_0= 'Assign' )
                    {
                    // InternalSymboleo.g:5432:5: (lv_name_64_0= 'Assign' )
                    // InternalSymboleo.g:5433:6: lv_name_64_0= 'Assign'
                    {
                    lv_name_64_0=(Token)match(input,96,FOLLOW_10); 

                    						newLeafNode(lv_name_64_0, grammarAccess.getPredicateFunctionAccess().getNameAssignKeyword_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_64_0, "Assign");
                    					

                    }


                    }

                    otherlv_65=(Token)match(input,17,FOLLOW_57); 

                    				newLeafNode(otherlv_65, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_9_2());
                    			
                    // InternalSymboleo.g:5449:4: ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==RULE_ID) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalSymboleo.g:5450:5: ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )*
                            {
                            // InternalSymboleo.g:5450:5: ( (lv_assignment_66_0= ruleOAssignment ) )
                            // InternalSymboleo.g:5451:6: (lv_assignment_66_0= ruleOAssignment )
                            {
                            // InternalSymboleo.g:5451:6: (lv_assignment_66_0= ruleOAssignment )
                            // InternalSymboleo.g:5452:7: lv_assignment_66_0= ruleOAssignment
                            {

                            							newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_9_3_0_0());
                            						
                            pushFollow(FOLLOW_58);
                            lv_assignment_66_0=ruleOAssignment();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            							}
                            							add(
                            								current,
                            								"assignment",
                            								lv_assignment_66_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSymboleo.g:5469:5: (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )*
                            loop68:
                            do {
                                int alt68=2;
                                int LA68_0 = input.LA(1);

                                if ( (LA68_0==12) ) {
                                    alt68=1;
                                }


                                switch (alt68) {
                            	case 1 :
                            	    // InternalSymboleo.g:5470:6: otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) )
                            	    {
                            	    otherlv_67=(Token)match(input,12,FOLLOW_3); 

                            	    						newLeafNode(otherlv_67, grammarAccess.getPredicateFunctionAccess().getSemicolonKeyword_9_3_1_0());
                            	    					
                            	    // InternalSymboleo.g:5474:6: ( (lv_assignment_68_0= ruleOAssignment ) )
                            	    // InternalSymboleo.g:5475:7: (lv_assignment_68_0= ruleOAssignment )
                            	    {
                            	    // InternalSymboleo.g:5475:7: (lv_assignment_68_0= ruleOAssignment )
                            	    // InternalSymboleo.g:5476:8: lv_assignment_68_0= ruleOAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_9_3_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_58);
                            	    lv_assignment_68_0=ruleOAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"assignment",
                            	    									lv_assignment_68_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop68;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_69=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_69, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_9_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicateFunction"


    // $ANTLR start "entryRuleOtherFunction"
    // InternalSymboleo.g:5504:1: entryRuleOtherFunction returns [EObject current=null] : iv_ruleOtherFunction= ruleOtherFunction EOF ;
    public final EObject entryRuleOtherFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherFunction = null;


        try {
            // InternalSymboleo.g:5504:54: (iv_ruleOtherFunction= ruleOtherFunction EOF )
            // InternalSymboleo.g:5505:2: iv_ruleOtherFunction= ruleOtherFunction EOF
            {
             newCompositeNode(grammarAccess.getOtherFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherFunction=ruleOtherFunction();

            state._fsp--;

             current =iv_ruleOtherFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherFunction"


    // $ANTLR start "ruleOtherFunction"
    // InternalSymboleo.g:5511:1: ruleOtherFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) ;
    public final EObject ruleOtherFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_arg1_3_0=null;
        Token otherlv_4=null;
        Token lv_arg2_5_0=null;
        Token otherlv_6=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token lv_arg1_10_0=null;
        Token otherlv_11=null;
        Token lv_arg2_12_0=null;
        Token otherlv_13=null;
        Token lv_name_15_0=null;
        Token otherlv_16=null;
        Token lv_arg1_17_0=null;
        Token otherlv_18=null;


        	enterRule();

        try {
            // InternalSymboleo.g:5517:2: ( ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) )
            // InternalSymboleo.g:5518:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            {
            // InternalSymboleo.g:5518:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt71=1;
                }
                break;
            case 98:
                {
                alt71=2;
                }
                break;
            case 99:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalSymboleo.g:5519:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:5519:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:5520:4: () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:5520:4: ()
                    // InternalSymboleo.g:5521:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsEqualAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5527:4: ( (lv_name_1_0= 'IsEqual' ) )
                    // InternalSymboleo.g:5528:5: (lv_name_1_0= 'IsEqual' )
                    {
                    // InternalSymboleo.g:5528:5: (lv_name_1_0= 'IsEqual' )
                    // InternalSymboleo.g:5529:6: lv_name_1_0= 'IsEqual'
                    {
                    lv_name_1_0=(Token)match(input,97,FOLLOW_10); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getOtherFunctionAccess().getNameIsEqualKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "IsEqual");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:5545:4: ( (lv_arg1_3_0= RULE_ID ) )
                    // InternalSymboleo.g:5546:5: (lv_arg1_3_0= RULE_ID )
                    {
                    // InternalSymboleo.g:5546:5: (lv_arg1_3_0= RULE_ID )
                    // InternalSymboleo.g:5547:6: lv_arg1_3_0= RULE_ID
                    {
                    lv_arg1_3_0=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(lv_arg1_3_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getOtherFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:5567:4: ( (lv_arg2_5_0= RULE_ID ) )
                    // InternalSymboleo.g:5568:5: (lv_arg2_5_0= RULE_ID )
                    {
                    // InternalSymboleo.g:5568:5: (lv_arg2_5_0= RULE_ID )
                    // InternalSymboleo.g:5569:6: lv_arg2_5_0= RULE_ID
                    {
                    lv_arg2_5_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg2_5_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_0_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:5591:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    {
                    // InternalSymboleo.g:5591:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    // InternalSymboleo.g:5592:4: () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')'
                    {
                    // InternalSymboleo.g:5592:4: ()
                    // InternalSymboleo.g:5593:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsOwnerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5599:4: ( (lv_name_8_0= 'IsOwner' ) )
                    // InternalSymboleo.g:5600:5: (lv_name_8_0= 'IsOwner' )
                    {
                    // InternalSymboleo.g:5600:5: (lv_name_8_0= 'IsOwner' )
                    // InternalSymboleo.g:5601:6: lv_name_8_0= 'IsOwner'
                    {
                    lv_name_8_0=(Token)match(input,98,FOLLOW_10); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getOtherFunctionAccess().getNameIsOwnerKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_8_0, "IsOwner");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:5617:4: ( (lv_arg1_10_0= RULE_ID ) )
                    // InternalSymboleo.g:5618:5: (lv_arg1_10_0= RULE_ID )
                    {
                    // InternalSymboleo.g:5618:5: (lv_arg1_10_0= RULE_ID )
                    // InternalSymboleo.g:5619:6: lv_arg1_10_0= RULE_ID
                    {
                    lv_arg1_10_0=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(lv_arg1_10_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getOtherFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:5639:4: ( (lv_arg2_12_0= RULE_ID ) )
                    // InternalSymboleo.g:5640:5: (lv_arg2_12_0= RULE_ID )
                    {
                    // InternalSymboleo.g:5640:5: (lv_arg2_12_0= RULE_ID )
                    // InternalSymboleo.g:5641:6: lv_arg2_12_0= RULE_ID
                    {
                    lv_arg2_12_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg2_12_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_1_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_12_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:5663:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    {
                    // InternalSymboleo.g:5663:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    // InternalSymboleo.g:5664:4: () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')'
                    {
                    // InternalSymboleo.g:5664:4: ()
                    // InternalSymboleo.g:5665:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionCannotBeAssignedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5671:4: ( (lv_name_15_0= 'CannotBeAssigned' ) )
                    // InternalSymboleo.g:5672:5: (lv_name_15_0= 'CannotBeAssigned' )
                    {
                    // InternalSymboleo.g:5672:5: (lv_name_15_0= 'CannotBeAssigned' )
                    // InternalSymboleo.g:5673:6: lv_name_15_0= 'CannotBeAssigned'
                    {
                    lv_name_15_0=(Token)match(input,99,FOLLOW_10); 

                    						newLeafNode(lv_name_15_0, grammarAccess.getOtherFunctionAccess().getNameCannotBeAssignedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_15_0, "CannotBeAssigned");
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:5689:4: ( (lv_arg1_17_0= RULE_ID ) )
                    // InternalSymboleo.g:5690:5: (lv_arg1_17_0= RULE_ID )
                    {
                    // InternalSymboleo.g:5690:5: (lv_arg1_17_0= RULE_ID )
                    // InternalSymboleo.g:5691:6: lv_arg1_17_0= RULE_ID
                    {
                    lv_arg1_17_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg1_17_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_17_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherFunction"


    // $ANTLR start "entryRuleEvent"
    // InternalSymboleo.g:5716:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalSymboleo.g:5716:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalSymboleo.g:5717:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalSymboleo.g:5723:1: ruleEvent returns [EObject current=null] : (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_VariableEvent_0 = null;

        EObject this_ObligationEvent_1 = null;

        EObject this_ContractEvent_2 = null;

        EObject this_PowerEvent_3 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5729:2: ( (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent ) )
            // InternalSymboleo.g:5730:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )
            {
            // InternalSymboleo.g:5730:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )
            int alt72=4;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // InternalSymboleo.g:5731:3: this_VariableEvent_0= ruleVariableEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getVariableEventParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableEvent_0=ruleVariableEvent();

                    state._fsp--;


                    			current = this_VariableEvent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:5740:3: this_ObligationEvent_1= ruleObligationEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getObligationEventParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationEvent_1=ruleObligationEvent();

                    state._fsp--;


                    			current = this_ObligationEvent_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:5749:3: this_ContractEvent_2= ruleContractEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getContractEventParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractEvent_2=ruleContractEvent();

                    state._fsp--;


                    			current = this_ContractEvent_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:5758:3: this_PowerEvent_3= rulePowerEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getPowerEventParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerEvent_3=rulePowerEvent();

                    state._fsp--;


                    			current = this_PowerEvent_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleVariableEvent"
    // InternalSymboleo.g:5770:1: entryRuleVariableEvent returns [EObject current=null] : iv_ruleVariableEvent= ruleVariableEvent EOF ;
    public final EObject entryRuleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEvent = null;


        try {
            // InternalSymboleo.g:5770:54: (iv_ruleVariableEvent= ruleVariableEvent EOF )
            // InternalSymboleo.g:5771:2: iv_ruleVariableEvent= ruleVariableEvent EOF
            {
             newCompositeNode(grammarAccess.getVariableEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableEvent=ruleVariableEvent();

            state._fsp--;

             current =iv_ruleVariableEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableEvent"


    // $ANTLR start "ruleVariableEvent"
    // InternalSymboleo.g:5777:1: ruleVariableEvent returns [EObject current=null] : ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) ;
    public final EObject ruleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5783:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) )
            // InternalSymboleo.g:5784:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            {
            // InternalSymboleo.g:5784:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            // InternalSymboleo.g:5785:3: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
            {
            // InternalSymboleo.g:5785:3: ()
            // InternalSymboleo.g:5786:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableEventAccess().getVariableEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:5792:3: ( (lv_variable_1_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:5793:4: (lv_variable_1_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:5793:4: (lv_variable_1_0= ruleVariableDotExpression )
            // InternalSymboleo.g:5794:5: lv_variable_1_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getVariableEventAccess().getVariableVariableDotExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_variable_1_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableEventRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableEvent"


    // $ANTLR start "entryRulePowerEvent"
    // InternalSymboleo.g:5815:1: entryRulePowerEvent returns [EObject current=null] : iv_rulePowerEvent= rulePowerEvent EOF ;
    public final EObject entryRulePowerEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerEvent = null;


        try {
            // InternalSymboleo.g:5815:51: (iv_rulePowerEvent= rulePowerEvent EOF )
            // InternalSymboleo.g:5816:2: iv_rulePowerEvent= rulePowerEvent EOF
            {
             newCompositeNode(grammarAccess.getPowerEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEvent=rulePowerEvent();

            state._fsp--;

             current =iv_rulePowerEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEvent"


    // $ANTLR start "rulePowerEvent"
    // InternalSymboleo.g:5822:1: rulePowerEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject rulePowerEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5828:2: ( ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalSymboleo.g:5829:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalSymboleo.g:5829:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalSymboleo.g:5830:3: () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalSymboleo.g:5830:3: ()
            // InternalSymboleo.g:5831:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPowerEventAccess().getPowerEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:5837:3: ( (lv_eventName_1_0= rulePowerEventName ) )
            // InternalSymboleo.g:5838:4: (lv_eventName_1_0= rulePowerEventName )
            {
            // InternalSymboleo.g:5838:4: (lv_eventName_1_0= rulePowerEventName )
            // InternalSymboleo.g:5839:5: lv_eventName_1_0= rulePowerEventName
            {

            					newCompositeNode(grammarAccess.getPowerEventAccess().getEventNamePowerEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=rulePowerEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,100,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPowerEventAccess().getPowersKeyword_3());
            		
            // InternalSymboleo.g:5864:3: ( (otherlv_4= RULE_ID ) )
            // InternalSymboleo.g:5865:4: (otherlv_4= RULE_ID )
            {
            // InternalSymboleo.g:5865:4: (otherlv_4= RULE_ID )
            // InternalSymboleo.g:5866:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getPowerEventAccess().getPowerVariablePowerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEvent"


    // $ANTLR start "entryRulePowerEventName"
    // InternalSymboleo.g:5885:1: entryRulePowerEventName returns [String current=null] : iv_rulePowerEventName= rulePowerEventName EOF ;
    public final String entryRulePowerEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerEventName = null;


        try {
            // InternalSymboleo.g:5885:54: (iv_rulePowerEventName= rulePowerEventName EOF )
            // InternalSymboleo.g:5886:2: iv_rulePowerEventName= rulePowerEventName EOF
            {
             newCompositeNode(grammarAccess.getPowerEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEventName=rulePowerEventName();

            state._fsp--;

             current =iv_rulePowerEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEventName"


    // $ANTLR start "rulePowerEventName"
    // InternalSymboleo.g:5892:1: rulePowerEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken rulePowerEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:5898:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) )
            // InternalSymboleo.g:5899:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            {
            // InternalSymboleo.g:5899:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            int alt73=7;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt73=1;
                }
                break;
            case 101:
                {
                alt73=2;
                }
                break;
            case 80:
                {
                alt73=3;
                }
                break;
            case 82:
                {
                alt73=4;
                }
                break;
            case 102:
                {
                alt73=5;
                }
                break;
            case 103:
                {
                alt73=6;
                }
                break;
            case 84:
                {
                alt73=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalSymboleo.g:5900:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:5906:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:5912:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:5918:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:5924:3: kw= 'Exerted'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExertedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:5930:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:5936:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEventName"


    // $ANTLR start "entryRuleObligationEvent"
    // InternalSymboleo.g:5945:1: entryRuleObligationEvent returns [EObject current=null] : iv_ruleObligationEvent= ruleObligationEvent EOF ;
    public final EObject entryRuleObligationEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationEvent = null;


        try {
            // InternalSymboleo.g:5945:56: (iv_ruleObligationEvent= ruleObligationEvent EOF )
            // InternalSymboleo.g:5946:2: iv_ruleObligationEvent= ruleObligationEvent EOF
            {
             newCompositeNode(grammarAccess.getObligationEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEvent=ruleObligationEvent();

            state._fsp--;

             current =iv_ruleObligationEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEvent"


    // $ANTLR start "ruleObligationEvent"
    // InternalSymboleo.g:5952:1: ruleObligationEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject ruleObligationEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5958:2: ( ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalSymboleo.g:5959:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalSymboleo.g:5959:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalSymboleo.g:5960:3: () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalSymboleo.g:5960:3: ()
            // InternalSymboleo.g:5961:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getObligationEventAccess().getObligationEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:5967:3: ( (lv_eventName_1_0= ruleObligationEventName ) )
            // InternalSymboleo.g:5968:4: (lv_eventName_1_0= ruleObligationEventName )
            {
            // InternalSymboleo.g:5968:4: (lv_eventName_1_0= ruleObligationEventName )
            // InternalSymboleo.g:5969:5: lv_eventName_1_0= ruleObligationEventName
            {

            					newCompositeNode(grammarAccess.getObligationEventAccess().getEventNameObligationEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=ruleObligationEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ObligationEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,81,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getObligationEventAccess().getObligationsKeyword_3());
            		
            // InternalSymboleo.g:5994:3: ( (otherlv_4= RULE_ID ) )
            // InternalSymboleo.g:5995:4: (otherlv_4= RULE_ID )
            {
            // InternalSymboleo.g:5995:4: (otherlv_4= RULE_ID )
            // InternalSymboleo.g:5996:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getObligationEventAccess().getObligationVariableObligationCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getObligationEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEvent"


    // $ANTLR start "entryRuleObligationEventName"
    // InternalSymboleo.g:6015:1: entryRuleObligationEventName returns [String current=null] : iv_ruleObligationEventName= ruleObligationEventName EOF ;
    public final String entryRuleObligationEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationEventName = null;


        try {
            // InternalSymboleo.g:6015:59: (iv_ruleObligationEventName= ruleObligationEventName EOF )
            // InternalSymboleo.g:6016:2: iv_ruleObligationEventName= ruleObligationEventName EOF
            {
             newCompositeNode(grammarAccess.getObligationEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEventName=ruleObligationEventName();

            state._fsp--;

             current =iv_ruleObligationEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEventName"


    // $ANTLR start "ruleObligationEventName"
    // InternalSymboleo.g:6022:1: ruleObligationEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken ruleObligationEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6028:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) )
            // InternalSymboleo.g:6029:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            {
            // InternalSymboleo.g:6029:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            int alt74=9;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt74=1;
                }
                break;
            case 101:
                {
                alt74=2;
                }
                break;
            case 80:
                {
                alt74=3;
                }
                break;
            case 82:
                {
                alt74=4;
                }
                break;
            case 83:
                {
                alt74=5;
                }
                break;
            case 103:
                {
                alt74=6;
                }
                break;
            case 104:
                {
                alt74=7;
                }
                break;
            case 105:
                {
                alt74=8;
                }
                break;
            case 84:
                {
                alt74=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalSymboleo.g:6030:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6036:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6042:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6048:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:6054:3: kw= 'Discharged'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getDischargedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:6060:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:6066:3: kw= 'Fulfilled'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getFulfilledKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:6072:3: kw= 'Violated'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getViolatedKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:6078:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTerminatedKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEventName"


    // $ANTLR start "entryRuleContractEvent"
    // InternalSymboleo.g:6087:1: entryRuleContractEvent returns [EObject current=null] : iv_ruleContractEvent= ruleContractEvent EOF ;
    public final EObject entryRuleContractEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractEvent = null;


        try {
            // InternalSymboleo.g:6087:54: (iv_ruleContractEvent= ruleContractEvent EOF )
            // InternalSymboleo.g:6088:2: iv_ruleContractEvent= ruleContractEvent EOF
            {
             newCompositeNode(grammarAccess.getContractEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEvent=ruleContractEvent();

            state._fsp--;

             current =iv_ruleContractEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEvent"


    // $ANTLR start "ruleContractEvent"
    // InternalSymboleo.g:6094:1: ruleContractEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) ;
    public final EObject ruleContractEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6100:2: ( ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) )
            // InternalSymboleo.g:6101:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            {
            // InternalSymboleo.g:6101:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            // InternalSymboleo.g:6102:3: () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')'
            {
            // InternalSymboleo.g:6102:3: ()
            // InternalSymboleo.g:6103:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContractEventAccess().getContractEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:6109:3: ( (lv_eventName_1_0= ruleContractEventName ) )
            // InternalSymboleo.g:6110:4: (lv_eventName_1_0= ruleContractEventName )
            {
            // InternalSymboleo.g:6110:4: (lv_eventName_1_0= ruleContractEventName )
            // InternalSymboleo.g:6111:5: lv_eventName_1_0= ruleContractEventName
            {

            					newCompositeNode(grammarAccess.getContractEventAccess().getEventNameContractEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=ruleContractEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ContractEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_53); 

            			newLeafNode(otherlv_2, grammarAccess.getContractEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,86,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getContractEventAccess().getSelfKeyword_3());
            		
            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getContractEventAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEvent"


    // $ANTLR start "entryRuleContractEventName"
    // InternalSymboleo.g:6144:1: entryRuleContractEventName returns [String current=null] : iv_ruleContractEventName= ruleContractEventName EOF ;
    public final String entryRuleContractEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractEventName = null;


        try {
            // InternalSymboleo.g:6144:57: (iv_ruleContractEventName= ruleContractEventName EOF )
            // InternalSymboleo.g:6145:2: iv_ruleContractEventName= ruleContractEventName EOF
            {
             newCompositeNode(grammarAccess.getContractEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEventName=ruleContractEventName();

            state._fsp--;

             current =iv_ruleContractEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEventName"


    // $ANTLR start "ruleContractEventName"
    // InternalSymboleo.g:6151:1: ruleContractEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) ;
    public final AntlrDatatypeRuleToken ruleContractEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6157:2: ( (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) )
            // InternalSymboleo.g:6158:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            {
            // InternalSymboleo.g:6158:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            int alt75=8;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt75=1;
                }
                break;
            case 80:
                {
                alt75=2;
                }
                break;
            case 82:
                {
                alt75=3;
                }
                break;
            case 106:
                {
                alt75=4;
                }
                break;
            case 107:
                {
                alt75=5;
                }
                break;
            case 108:
                {
                alt75=6;
                }
                break;
            case 84:
                {
                alt75=7;
                }
                break;
            case 109:
                {
                alt75=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // InternalSymboleo.g:6159:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getActivatedKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6165:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getSuspendedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6171:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getResumedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6177:3: kw= 'FulfilledObligations'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getFulfilledObligationsKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:6183:3: kw= 'RevokedParty'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRevokedPartyKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:6189:3: kw= 'AssignedParty'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getAssignedPartyKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:6195:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:6201:3: kw= 'Rescinded'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRescindedKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEventName"


    // $ANTLR start "entryRulePoint"
    // InternalSymboleo.g:6210:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalSymboleo.g:6210:46: (iv_rulePoint= rulePoint EOF )
            // InternalSymboleo.g:6211:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalSymboleo.g:6217:1: rulePoint returns [EObject current=null] : ( (lv_pointExpression_0_0= rulePointExpression ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        EObject lv_pointExpression_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6223:2: ( ( (lv_pointExpression_0_0= rulePointExpression ) ) )
            // InternalSymboleo.g:6224:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            {
            // InternalSymboleo.g:6224:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            // InternalSymboleo.g:6225:3: (lv_pointExpression_0_0= rulePointExpression )
            {
            // InternalSymboleo.g:6225:3: (lv_pointExpression_0_0= rulePointExpression )
            // InternalSymboleo.g:6226:4: lv_pointExpression_0_0= rulePointExpression
            {

            				newCompositeNode(grammarAccess.getPointAccess().getPointExpressionPointExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_pointExpression_0_0=rulePointExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPointRule());
            				}
            				set(
            					current,
            					"pointExpression",
            					lv_pointExpression_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRulePointExpression"
    // InternalSymboleo.g:6246:1: entryRulePointExpression returns [EObject current=null] : iv_rulePointExpression= rulePointExpression EOF ;
    public final EObject entryRulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointExpression = null;


        try {
            // InternalSymboleo.g:6246:56: (iv_rulePointExpression= rulePointExpression EOF )
            // InternalSymboleo.g:6247:2: iv_rulePointExpression= rulePointExpression EOF
            {
             newCompositeNode(grammarAccess.getPointExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointExpression=rulePointExpression();

            state._fsp--;

             current =iv_rulePointExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointExpression"


    // $ANTLR start "rulePointExpression"
    // InternalSymboleo.g:6253:1: rulePointExpression returns [EObject current=null] : (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) ;
    public final EObject rulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PointFunction_0 = null;

        EObject this_PointAtom_1 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6259:2: ( (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) )
            // InternalSymboleo.g:6260:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            {
            // InternalSymboleo.g:6260:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==74) ) {
                alt76=1;
            }
            else if ( (LA76_0==RULE_ID||LA76_0==80||(LA76_0>=82 && LA76_0<=85)||(LA76_0>=101 && LA76_0<=109)) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalSymboleo.g:6261:3: this_PointFunction_0= rulePointFunction
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointFunction_0=rulePointFunction();

                    state._fsp--;


                    			current = this_PointFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6270:3: this_PointAtom_1= rulePointAtom
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointAtomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointAtom_1=rulePointAtom();

                    state._fsp--;


                    			current = this_PointAtom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointExpression"


    // $ANTLR start "entryRulePointFunction"
    // InternalSymboleo.g:6282:1: entryRulePointFunction returns [EObject current=null] : iv_rulePointFunction= rulePointFunction EOF ;
    public final EObject entryRulePointFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointFunction = null;


        try {
            // InternalSymboleo.g:6282:54: (iv_rulePointFunction= rulePointFunction EOF )
            // InternalSymboleo.g:6283:2: iv_rulePointFunction= rulePointFunction EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunction=rulePointFunction();

            state._fsp--;

             current =iv_rulePointFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunction"


    // $ANTLR start "rulePointFunction"
    // InternalSymboleo.g:6289:1: rulePointFunction returns [EObject current=null] : ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject rulePointFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_arg_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6295:2: ( ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalSymboleo.g:6296:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalSymboleo.g:6296:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalSymboleo.g:6297:3: () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalSymboleo.g:6297:3: ()
            // InternalSymboleo.g:6298:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointFunctionAccess().getPointFunctionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:6304:3: ( (lv_name_1_0= rulePointFunctionName ) )
            // InternalSymboleo.g:6305:4: (lv_name_1_0= rulePointFunctionName )
            {
            // InternalSymboleo.g:6305:4: (lv_name_1_0= rulePointFunctionName )
            // InternalSymboleo.g:6306:5: lv_name_1_0= rulePointFunctionName
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getNamePointFunctionNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_1_0=rulePointFunctionName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PointFunctionName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_55); 

            			newLeafNode(otherlv_2, grammarAccess.getPointFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSymboleo.g:6327:3: ( (lv_arg_3_0= rulePointExpression ) )
            // InternalSymboleo.g:6328:4: (lv_arg_3_0= rulePointExpression )
            {
            // InternalSymboleo.g:6328:4: (lv_arg_3_0= rulePointExpression )
            // InternalSymboleo.g:6329:5: lv_arg_3_0= rulePointExpression
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getArgPointExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_arg_3_0=rulePointExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"arg",
            						lv_arg_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_60); 

            			newLeafNode(otherlv_4, grammarAccess.getPointFunctionAccess().getCommaKeyword_4());
            		
            // InternalSymboleo.g:6350:3: ( (lv_value_5_0= ruleTimevalue ) )
            // InternalSymboleo.g:6351:4: (lv_value_5_0= ruleTimevalue )
            {
            // InternalSymboleo.g:6351:4: (lv_value_5_0= ruleTimevalue )
            // InternalSymboleo.g:6352:5: lv_value_5_0= ruleTimevalue
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getValueTimevalueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_5_0=ruleTimevalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Timevalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getPointFunctionAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:6373:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalSymboleo.g:6374:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalSymboleo.g:6374:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalSymboleo.g:6375:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPointFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunction"


    // $ANTLR start "entryRulePointFunctionName"
    // InternalSymboleo.g:6400:1: entryRulePointFunctionName returns [String current=null] : iv_rulePointFunctionName= rulePointFunctionName EOF ;
    public final String entryRulePointFunctionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePointFunctionName = null;


        try {
            // InternalSymboleo.g:6400:57: (iv_rulePointFunctionName= rulePointFunctionName EOF )
            // InternalSymboleo.g:6401:2: iv_rulePointFunctionName= rulePointFunctionName EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunctionName=rulePointFunctionName();

            state._fsp--;

             current =iv_rulePointFunctionName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunctionName"


    // $ANTLR start "rulePointFunctionName"
    // InternalSymboleo.g:6407:1: rulePointFunctionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Date.add' ;
    public final AntlrDatatypeRuleToken rulePointFunctionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6413:2: (kw= 'Date.add' )
            // InternalSymboleo.g:6414:2: kw= 'Date.add'
            {
            kw=(Token)match(input,74,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPointFunctionNameAccess().getDateAddKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunctionName"


    // $ANTLR start "entryRulePointAtom"
    // InternalSymboleo.g:6422:1: entryRulePointAtom returns [EObject current=null] : iv_rulePointAtom= rulePointAtom EOF ;
    public final EObject entryRulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointAtom = null;


        try {
            // InternalSymboleo.g:6422:50: (iv_rulePointAtom= rulePointAtom EOF )
            // InternalSymboleo.g:6423:2: iv_rulePointAtom= rulePointAtom EOF
            {
             newCompositeNode(grammarAccess.getPointAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointAtom=rulePointAtom();

            state._fsp--;

             current =iv_rulePointAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointAtom"


    // $ANTLR start "rulePointAtom"
    // InternalSymboleo.g:6429:1: rulePointAtom returns [EObject current=null] : ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) ;
    public final EObject rulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_obligationEvent_3_0 = null;

        EObject lv_contractEvent_5_0 = null;

        EObject lv_powerEvent_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6435:2: ( ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) )
            // InternalSymboleo.g:6436:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            {
            // InternalSymboleo.g:6436:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            int alt77=4;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalSymboleo.g:6437:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:6437:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:6438:4: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:6438:4: ()
                    // InternalSymboleo.g:6439:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomParameterDotExpressionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6445:4: ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:6446:5: (lv_variable_1_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:6446:5: (lv_variable_1_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:6447:6: lv_variable_1_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getVariableVariableDotExpressionParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_1_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_1_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6466:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    {
                    // InternalSymboleo.g:6466:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    // InternalSymboleo.g:6467:4: () ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    {
                    // InternalSymboleo.g:6467:4: ()
                    // InternalSymboleo.g:6468:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomObligationEventAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6474:4: ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    // InternalSymboleo.g:6475:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    {
                    // InternalSymboleo.g:6475:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    // InternalSymboleo.g:6476:6: lv_obligationEvent_3_0= ruleObligationEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getObligationEventObligationEventParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_obligationEvent_3_0=ruleObligationEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"obligationEvent",
                    							lv_obligationEvent_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ObligationEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6495:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    {
                    // InternalSymboleo.g:6495:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    // InternalSymboleo.g:6496:4: () ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    {
                    // InternalSymboleo.g:6496:4: ()
                    // InternalSymboleo.g:6497:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomContractEventAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6503:4: ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    // InternalSymboleo.g:6504:5: (lv_contractEvent_5_0= ruleContractEvent )
                    {
                    // InternalSymboleo.g:6504:5: (lv_contractEvent_5_0= ruleContractEvent )
                    // InternalSymboleo.g:6505:6: lv_contractEvent_5_0= ruleContractEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getContractEventContractEventParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contractEvent_5_0=ruleContractEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"contractEvent",
                    							lv_contractEvent_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ContractEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6524:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    {
                    // InternalSymboleo.g:6524:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    // InternalSymboleo.g:6525:4: () ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    {
                    // InternalSymboleo.g:6525:4: ()
                    // InternalSymboleo.g:6526:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomPowerEventAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6532:4: ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    // InternalSymboleo.g:6533:5: (lv_powerEvent_7_0= rulePowerEvent )
                    {
                    // InternalSymboleo.g:6533:5: (lv_powerEvent_7_0= rulePowerEvent )
                    // InternalSymboleo.g:6534:6: lv_powerEvent_7_0= rulePowerEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getPowerEventPowerEventParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_powerEvent_7_0=rulePowerEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"powerEvent",
                    							lv_powerEvent_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PowerEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointAtom"


    // $ANTLR start "entryRuleTimevalue"
    // InternalSymboleo.g:6556:1: entryRuleTimevalue returns [EObject current=null] : iv_ruleTimevalue= ruleTimevalue EOF ;
    public final EObject entryRuleTimevalue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimevalue = null;


        try {
            // InternalSymboleo.g:6556:50: (iv_ruleTimevalue= ruleTimevalue EOF )
            // InternalSymboleo.g:6557:2: iv_ruleTimevalue= ruleTimevalue EOF
            {
             newCompositeNode(grammarAccess.getTimevalueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimevalue=ruleTimevalue();

            state._fsp--;

             current =iv_ruleTimevalue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimevalue"


    // $ANTLR start "ruleTimevalue"
    // InternalSymboleo.g:6563:1: ruleTimevalue returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleTimevalue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_variable_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6569:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) )
            // InternalSymboleo.g:6570:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalSymboleo.g:6570:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_INT) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_ID) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalSymboleo.g:6571:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:6571:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalSymboleo.g:6572:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:6572:4: ()
                    // InternalSymboleo.g:6573:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueIntAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6579:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalSymboleo.g:6580:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalSymboleo.g:6580:5: (lv_value_1_0= RULE_INT )
                    // InternalSymboleo.g:6581:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getTimevalueAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimevalueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6599:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:6599:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:6600:4: () ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:6600:4: ()
                    // InternalSymboleo.g:6601:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueVariableAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6607:4: ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:6608:5: (lv_variable_3_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:6608:5: (lv_variable_3_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:6609:6: lv_variable_3_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getTimevalueAccess().getVariableVariableDotExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_3_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimevalueRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimevalue"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalSymboleo.g:6631:1: entryRuleTimeUnit returns [String current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final String entryRuleTimeUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnit = null;


        try {
            // InternalSymboleo.g:6631:48: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalSymboleo.g:6632:2: iv_ruleTimeUnit= ruleTimeUnit EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnit=ruleTimeUnit();

            state._fsp--;

             current =iv_ruleTimeUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalSymboleo.g:6638:1: ruleTimeUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6644:2: ( (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) )
            // InternalSymboleo.g:6645:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            {
            // InternalSymboleo.g:6645:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            int alt79=7;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt79=1;
                }
                break;
            case 111:
                {
                alt79=2;
                }
                break;
            case 112:
                {
                alt79=3;
                }
                break;
            case 113:
                {
                alt79=4;
                }
                break;
            case 114:
                {
                alt79=5;
                }
                break;
            case 115:
                {
                alt79=6;
                }
                break;
            case 116:
                {
                alt79=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalSymboleo.g:6646:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getSecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6652:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMinutesKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6658:3: kw= 'hours'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getHoursKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6664:3: kw= 'days'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getDaysKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:6670:3: kw= 'weeks'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getWeeksKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:6676:3: kw= 'months'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMonthsKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:6682:3: kw= 'years'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getYearsKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleInterval"
    // InternalSymboleo.g:6691:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalSymboleo.g:6691:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalSymboleo.g:6692:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalSymboleo.g:6698:1: ruleInterval returns [EObject current=null] : ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        EObject lv_intervalExpression_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6704:2: ( ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) )
            // InternalSymboleo.g:6705:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            {
            // InternalSymboleo.g:6705:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            // InternalSymboleo.g:6706:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            {
            // InternalSymboleo.g:6706:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            // InternalSymboleo.g:6707:4: lv_intervalExpression_0_0= ruleIntervalExpression
            {

            				newCompositeNode(grammarAccess.getIntervalAccess().getIntervalExpressionIntervalExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_intervalExpression_0_0=ruleIntervalExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getIntervalRule());
            				}
            				set(
            					current,
            					"intervalExpression",
            					lv_intervalExpression_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.IntervalExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleIntervalExpression"
    // InternalSymboleo.g:6727:1: entryRuleIntervalExpression returns [EObject current=null] : iv_ruleIntervalExpression= ruleIntervalExpression EOF ;
    public final EObject entryRuleIntervalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalExpression = null;


        try {
            // InternalSymboleo.g:6727:59: (iv_ruleIntervalExpression= ruleIntervalExpression EOF )
            // InternalSymboleo.g:6728:2: iv_ruleIntervalExpression= ruleIntervalExpression EOF
            {
             newCompositeNode(grammarAccess.getIntervalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntervalExpression=ruleIntervalExpression();

            state._fsp--;

             current =iv_ruleIntervalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntervalExpression"


    // $ANTLR start "ruleIntervalExpression"
    // InternalSymboleo.g:6734:1: ruleIntervalExpression returns [EObject current=null] : ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) ;
    public final EObject ruleIntervalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_situation_8_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6740:2: ( ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) )
            // InternalSymboleo.g:6741:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            {
            // InternalSymboleo.g:6741:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==117) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=118 && LA80_0<=129)) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalSymboleo.g:6742:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:6742:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:6743:4: () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:6743:4: ()
                    // InternalSymboleo.g:6744:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getIntervalFunctionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,117,FOLLOW_10); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntervalExpressionAccess().getIntervalKeyword_0_1());
                    			
                    otherlv_2=(Token)match(input,17,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getIntervalExpressionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:6758:4: ( (lv_arg1_3_0= rulePointExpression ) )
                    // InternalSymboleo.g:6759:5: (lv_arg1_3_0= rulePointExpression )
                    {
                    // InternalSymboleo.g:6759:5: (lv_arg1_3_0= rulePointExpression )
                    // InternalSymboleo.g:6760:6: lv_arg1_3_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg1PointExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_55); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntervalExpressionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:6781:4: ( (lv_arg2_5_0= rulePointExpression ) )
                    // InternalSymboleo.g:6782:5: (lv_arg2_5_0= rulePointExpression )
                    {
                    // InternalSymboleo.g:6782:5: (lv_arg2_5_0= rulePointExpression )
                    // InternalSymboleo.g:6783:6: lv_arg2_5_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg2PointExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_5_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getIntervalExpressionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6806:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    {
                    // InternalSymboleo.g:6806:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    // InternalSymboleo.g:6807:4: () ( (lv_situation_8_0= ruleSituation ) )
                    {
                    // InternalSymboleo.g:6807:4: ()
                    // InternalSymboleo.g:6808:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getSituationExpressionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6814:4: ( (lv_situation_8_0= ruleSituation ) )
                    // InternalSymboleo.g:6815:5: (lv_situation_8_0= ruleSituation )
                    {
                    // InternalSymboleo.g:6815:5: (lv_situation_8_0= ruleSituation )
                    // InternalSymboleo.g:6816:6: lv_situation_8_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getSituationSituationParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_situation_8_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntervalExpression"


    // $ANTLR start "entryRuleSituation"
    // InternalSymboleo.g:6838:1: entryRuleSituation returns [EObject current=null] : iv_ruleSituation= ruleSituation EOF ;
    public final EObject entryRuleSituation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSituation = null;


        try {
            // InternalSymboleo.g:6838:50: (iv_ruleSituation= ruleSituation EOF )
            // InternalSymboleo.g:6839:2: iv_ruleSituation= ruleSituation EOF
            {
             newCompositeNode(grammarAccess.getSituationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSituation=ruleSituation();

            state._fsp--;

             current =iv_ruleSituation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSituation"


    // $ANTLR start "ruleSituation"
    // InternalSymboleo.g:6845:1: ruleSituation returns [EObject current=null] : (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) ;
    public final EObject ruleSituation() throws RecognitionException {
        EObject current = null;

        EObject this_ObligationState_0 = null;

        EObject this_ContractState_1 = null;

        EObject this_PowerState_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6851:2: ( (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) )
            // InternalSymboleo.g:6852:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            {
            // InternalSymboleo.g:6852:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            int alt81=3;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalSymboleo.g:6853:3: this_ObligationState_0= ruleObligationState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getObligationStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationState_0=ruleObligationState();

                    state._fsp--;


                    			current = this_ObligationState_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6862:3: this_ContractState_1= ruleContractState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getContractStateParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractState_1=ruleContractState();

                    state._fsp--;


                    			current = this_ContractState_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6871:3: this_PowerState_2= rulePowerState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getPowerStateParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerState_2=rulePowerState();

                    state._fsp--;


                    			current = this_PowerState_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSituation"


    // $ANTLR start "entryRulePowerState"
    // InternalSymboleo.g:6883:1: entryRulePowerState returns [EObject current=null] : iv_rulePowerState= rulePowerState EOF ;
    public final EObject entryRulePowerState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerState = null;


        try {
            // InternalSymboleo.g:6883:51: (iv_rulePowerState= rulePowerState EOF )
            // InternalSymboleo.g:6884:2: iv_rulePowerState= rulePowerState EOF
            {
             newCompositeNode(grammarAccess.getPowerStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerState=rulePowerState();

            state._fsp--;

             current =iv_rulePowerState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerState"


    // $ANTLR start "rulePowerState"
    // InternalSymboleo.g:6890:1: rulePowerState returns [EObject current=null] : ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject rulePowerState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6896:2: ( ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalSymboleo.g:6897:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalSymboleo.g:6897:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalSymboleo.g:6898:3: ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalSymboleo.g:6898:3: ( (lv_stateName_0_0= rulePowerStateName ) )
            // InternalSymboleo.g:6899:4: (lv_stateName_0_0= rulePowerStateName )
            {
            // InternalSymboleo.g:6899:4: (lv_stateName_0_0= rulePowerStateName )
            // InternalSymboleo.g:6900:5: lv_stateName_0_0= rulePowerStateName
            {

            					newCompositeNode(grammarAccess.getPowerStateAccess().getStateNamePowerStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=rulePowerStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,100,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerStateAccess().getPowersKeyword_2());
            		
            // InternalSymboleo.g:6925:3: ( (otherlv_3= RULE_ID ) )
            // InternalSymboleo.g:6926:4: (otherlv_3= RULE_ID )
            {
            // InternalSymboleo.g:6926:4: (otherlv_3= RULE_ID )
            // InternalSymboleo.g:6927:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getPowerStateAccess().getPowerVariablePowerCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerState"


    // $ANTLR start "entryRulePowerStateName"
    // InternalSymboleo.g:6946:1: entryRulePowerStateName returns [String current=null] : iv_rulePowerStateName= rulePowerStateName EOF ;
    public final String entryRulePowerStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerStateName = null;


        try {
            // InternalSymboleo.g:6946:54: (iv_rulePowerStateName= rulePowerStateName EOF )
            // InternalSymboleo.g:6947:2: iv_rulePowerStateName= rulePowerStateName EOF
            {
             newCompositeNode(grammarAccess.getPowerStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerStateName=rulePowerStateName();

            state._fsp--;

             current =iv_rulePowerStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerStateName"


    // $ANTLR start "rulePowerStateName"
    // InternalSymboleo.g:6953:1: rulePowerStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken rulePowerStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6959:2: ( (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) )
            // InternalSymboleo.g:6960:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            {
            // InternalSymboleo.g:6960:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            int alt82=6;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt82=1;
                }
                break;
            case 119:
                {
                alt82=2;
                }
                break;
            case 120:
                {
                alt82=3;
                }
                break;
            case 121:
                {
                alt82=4;
                }
                break;
            case 122:
                {
                alt82=5;
                }
                break;
            case 123:
                {
                alt82=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalSymboleo.g:6961:3: kw= 'Create'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6967:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getUnsuccessfulTerminationKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6973:3: kw= 'Active'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6979:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:6985:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:6991:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerStateName"


    // $ANTLR start "entryRuleObligationState"
    // InternalSymboleo.g:7000:1: entryRuleObligationState returns [EObject current=null] : iv_ruleObligationState= ruleObligationState EOF ;
    public final EObject entryRuleObligationState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationState = null;


        try {
            // InternalSymboleo.g:7000:56: (iv_ruleObligationState= ruleObligationState EOF )
            // InternalSymboleo.g:7001:2: iv_ruleObligationState= ruleObligationState EOF
            {
             newCompositeNode(grammarAccess.getObligationStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationState=ruleObligationState();

            state._fsp--;

             current =iv_ruleObligationState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationState"


    // $ANTLR start "ruleObligationState"
    // InternalSymboleo.g:7007:1: ruleObligationState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleObligationState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7013:2: ( ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalSymboleo.g:7014:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalSymboleo.g:7014:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalSymboleo.g:7015:3: ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalSymboleo.g:7015:3: ( (lv_stateName_0_0= ruleObligationStateName ) )
            // InternalSymboleo.g:7016:4: (lv_stateName_0_0= ruleObligationStateName )
            {
            // InternalSymboleo.g:7016:4: (lv_stateName_0_0= ruleObligationStateName )
            // InternalSymboleo.g:7017:5: lv_stateName_0_0= ruleObligationStateName
            {

            					newCompositeNode(grammarAccess.getObligationStateAccess().getStateNameObligationStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=ruleObligationStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ObligationStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,81,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationStateAccess().getObligationsKeyword_2());
            		
            // InternalSymboleo.g:7042:3: ( (otherlv_3= RULE_ID ) )
            // InternalSymboleo.g:7043:4: (otherlv_3= RULE_ID )
            {
            // InternalSymboleo.g:7043:4: (otherlv_3= RULE_ID )
            // InternalSymboleo.g:7044:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getObligationStateAccess().getObligationVariableObligationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationState"


    // $ANTLR start "entryRuleObligationStateName"
    // InternalSymboleo.g:7063:1: entryRuleObligationStateName returns [String current=null] : iv_ruleObligationStateName= ruleObligationStateName EOF ;
    public final String entryRuleObligationStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationStateName = null;


        try {
            // InternalSymboleo.g:7063:59: (iv_ruleObligationStateName= ruleObligationStateName EOF )
            // InternalSymboleo.g:7064:2: iv_ruleObligationStateName= ruleObligationStateName EOF
            {
             newCompositeNode(grammarAccess.getObligationStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationStateName=ruleObligationStateName();

            state._fsp--;

             current =iv_ruleObligationStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationStateName"


    // $ANTLR start "ruleObligationStateName"
    // InternalSymboleo.g:7070:1: ruleObligationStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken ruleObligationStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7076:2: ( (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) )
            // InternalSymboleo.g:7077:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            {
            // InternalSymboleo.g:7077:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            int alt83=8;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt83=1;
                }
                break;
            case 124:
                {
                alt83=2;
                }
                break;
            case 120:
                {
                alt83=3;
                }
                break;
            case 121:
                {
                alt83=4;
                }
                break;
            case 122:
                {
                alt83=5;
                }
                break;
            case 125:
                {
                alt83=6;
                }
                break;
            case 126:
                {
                alt83=7;
                }
                break;
            case 119:
                {
                alt83=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalSymboleo.g:7078:3: kw= 'Create'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7084:3: kw= 'Discharge'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getDischargeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7090:3: kw= 'Active'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7096:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7102:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:7108:3: kw= 'Violation'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getViolationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:7114:3: kw= 'Fulfillment'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getFulfillmentKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:7120:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getUnsuccessfulTerminationKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationStateName"


    // $ANTLR start "entryRuleContractState"
    // InternalSymboleo.g:7129:1: entryRuleContractState returns [EObject current=null] : iv_ruleContractState= ruleContractState EOF ;
    public final EObject entryRuleContractState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractState = null;


        try {
            // InternalSymboleo.g:7129:54: (iv_ruleContractState= ruleContractState EOF )
            // InternalSymboleo.g:7130:2: iv_ruleContractState= ruleContractState EOF
            {
             newCompositeNode(grammarAccess.getContractStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractState=ruleContractState();

            state._fsp--;

             current =iv_ruleContractState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractState"


    // $ANTLR start "ruleContractState"
    // InternalSymboleo.g:7136:1: ruleContractState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) ;
    public final EObject ruleContractState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7142:2: ( ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) )
            // InternalSymboleo.g:7143:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            {
            // InternalSymboleo.g:7143:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            // InternalSymboleo.g:7144:3: ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')'
            {
            // InternalSymboleo.g:7144:3: ( (lv_stateName_0_0= ruleContractStateName ) )
            // InternalSymboleo.g:7145:4: (lv_stateName_0_0= ruleContractStateName )
            {
            // InternalSymboleo.g:7145:4: (lv_stateName_0_0= ruleContractStateName )
            // InternalSymboleo.g:7146:5: lv_stateName_0_0= ruleContractStateName
            {

            					newCompositeNode(grammarAccess.getContractStateAccess().getStateNameContractStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=ruleContractStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ContractStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getContractStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,86,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getContractStateAccess().getSelfKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getContractStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractState"


    // $ANTLR start "entryRuleContractStateName"
    // InternalSymboleo.g:7179:1: entryRuleContractStateName returns [String current=null] : iv_ruleContractStateName= ruleContractStateName EOF ;
    public final String entryRuleContractStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractStateName = null;


        try {
            // InternalSymboleo.g:7179:57: (iv_ruleContractStateName= ruleContractStateName EOF )
            // InternalSymboleo.g:7180:2: iv_ruleContractStateName= ruleContractStateName EOF
            {
             newCompositeNode(grammarAccess.getContractStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractStateName=ruleContractStateName();

            state._fsp--;

             current =iv_ruleContractStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractStateName"


    // $ANTLR start "ruleContractStateName"
    // InternalSymboleo.g:7186:1: ruleContractStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) ;
    public final AntlrDatatypeRuleToken ruleContractStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7192:2: ( (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) )
            // InternalSymboleo.g:7193:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            {
            // InternalSymboleo.g:7193:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            int alt84=8;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt84=1;
                }
                break;
            case 128:
                {
                alt84=2;
                }
                break;
            case 121:
                {
                alt84=3;
                }
                break;
            case 122:
                {
                alt84=4;
                }
                break;
            case 129:
                {
                alt84=5;
                }
                break;
            case 123:
                {
                alt84=6;
                }
                break;
            case 119:
                {
                alt84=7;
                }
                break;
            case 120:
                {
                alt84=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalSymboleo.g:7194:3: kw= 'Form'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getFormKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7200:3: kw= 'UnAssign'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnAssignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7206:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getInEffectKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7212:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuspensionKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7218:3: kw= 'Rescission'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getRescissionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:7224:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:7230:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnsuccessfulTerminationKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:7236:3: kw= 'Active'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getActiveKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractStateName"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA81 dfa81 = new DFA81(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\4\1\40\1\4\5\22\2\uffff";
    static final String dfa_3s = "\1\4\1\40\1\44\5\23\2\uffff";
    static final String dfa_4s = "\10\uffff\1\2\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\7\34\uffff\1\3\1\4\1\5\1\6",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 185:3: ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\4\uffff\5\12\2\uffff";
    static final String dfa_9s = "\2\4\1\40\1\4\5\14\2\uffff";
    static final String dfa_10s = "\1\50\1\4\1\40\1\44\5\22\2\uffff";
    static final String dfa_11s = "\11\uffff\1\1\1\2";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\43\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\10\34\uffff\1\4\1\5\1\6\1\7",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 768:5: ( ( (lv_attributes_5_0= ruleAttribute ) ) otherlv_6= ',' )*";
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 863:5: ( ( (lv_attributes_13_0= ruleAttribute ) ) otherlv_14= ',' )*";
        }
    }
    static final String dfa_14s = "\3\uffff\1\10\1\uffff\1\11\5\uffff";
    static final String dfa_15s = "\1\4\2\uffff\1\14\1\uffff\1\14\5\uffff";
    static final String dfa_16s = "\1\71\2\uffff\1\66\1\uffff\1\66\5\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\5\1\uffff\1\7\1\3\1\4\1\10\1\6";
    static final String[] dfa_18s = {
            "\1\5\1\3\1\6\34\uffff\1\4\24\uffff\1\1\1\2",
            "",
            "",
            "\1\10\5\uffff\2\10\26\uffff\1\7\14\10",
            "",
            "\1\11\4\uffff\1\12\2\11\26\uffff\15\11",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_7;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_12;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2374:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )";
        }
    }
    static final String dfa_19s = "\17\uffff";
    static final String dfa_20s = "\1\120\2\21\1\uffff\1\21\1\uffff\3\121\6\uffff";
    static final String dfa_21s = "\1\125\2\21\1\uffff\1\21\1\uffff\3\126\6\uffff";
    static final String dfa_22s = "\3\uffff\1\3\1\uffff\1\5\3\uffff\1\1\1\6\1\2\1\7\1\10\1\4";
    static final String dfa_23s = "\17\uffff}>";
    static final String[] dfa_24s = {
            "\1\1\1\uffff\1\2\1\3\1\4\1\5",
            "\1\6",
            "\1\7",
            "",
            "\1\10",
            "",
            "\1\11\4\uffff\1\12",
            "\1\13\4\uffff\1\14",
            "\1\16\4\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "3641:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )";
        }
    }
    static final String dfa_25s = "\5\uffff\1\14\2\uffff\1\16\6\uffff";
    static final String dfa_26s = "\1\4\4\uffff\1\14\2\uffff\1\14\6\uffff";
    static final String dfa_27s = "\1\143\4\uffff\1\113\2\uffff\1\113\6\uffff";
    static final String dfa_28s = "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\uffff\1\13\1\14\1\5\1\6\1\11\1\12";
    static final String[] dfa_29s = {
            "\1\5\1\10\1\11\12\uffff\1\1\21\uffff\1\12\23\uffff\1\2\1\6\1\7\35\uffff\12\3\3\4",
            "",
            "",
            "",
            "",
            "\1\14\4\uffff\1\13\2\14\26\uffff\11\14\30\uffff\1\14",
            "",
            "",
            "\1\16\5\uffff\2\16\26\uffff\1\15\10\16\30\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = dfa_19;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_23;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "4371:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )";
        }
    }
    static final String dfa_30s = "\15\uffff";
    static final String dfa_31s = "\1\4\1\uffff\4\21\1\uffff\2\21\2\uffff\2\121";
    static final String dfa_32s = "\1\155\1\uffff\4\21\1\uffff\2\21\2\uffff\2\144";
    static final String dfa_33s = "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3\1\4\2\uffff";
    static final String dfa_34s = "\15\uffff}>";
    static final String[] dfa_35s = {
            "\1\1\113\uffff\1\4\1\uffff\1\5\1\6\1\10\1\2\17\uffff\1\3\1\12\1\7\2\6\4\11",
            "",
            "\1\13",
            "\1\14",
            "\1\14",
            "\1\14",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "\1\6\22\uffff\1\12",
            "\1\6\4\uffff\1\11\15\uffff\1\12"
    };

    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = dfa_30;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "5730:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )";
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_30;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "6436:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )";
        }
    }
    static final String dfa_36s = "\1\166\1\21\1\uffff\4\21\1\uffff\1\21\2\121\1\126\1\uffff";
    static final String dfa_37s = "\1\u0081\1\21\1\uffff\4\21\1\uffff\1\21\3\144\1\uffff";
    static final String dfa_38s = "\2\uffff\1\1\4\uffff\1\2\4\uffff\1\3";
    static final String[] dfa_39s = {
            "\1\1\1\6\1\3\1\4\1\5\1\10\3\2\3\7",
            "\1\11",
            "",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "",
            "\1\13",
            "\1\2\22\uffff\1\14",
            "\1\2\4\uffff\1\7\15\uffff\1\14",
            "\1\7\15\uffff\1\14",
            ""
    };
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_30;
            this.eof = dfa_30;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_34;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "6852:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x001FC00000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000E00010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0380000800C20070L,0x0000000FFF800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0380000800820070L,0x0000000FFF800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000F800010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000E000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000C000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0380000808020070L,0x0000000FFF800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000E000010000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001E00000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0xFF80000800020070L,0x0000000FFF8007FFL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0007800000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0380000800020070L,0x0000000FFF803000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0380000800020070L,0x0000000FFF800000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0380000800020070L,0x0000000FFF80C000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x00000000003D0000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000010L,0x00003FE0003D0000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000010L,0x00003FE0003D0400L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0xFFE0000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000081000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000030L});

}