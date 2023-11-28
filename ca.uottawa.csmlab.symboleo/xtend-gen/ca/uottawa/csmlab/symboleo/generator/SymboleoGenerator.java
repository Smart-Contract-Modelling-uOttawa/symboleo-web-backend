package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.Helpers;
import ca.uottawa.csmlab.symboleo.symboleo.And;
import ca.uottawa.csmlab.symboleo.symboleo.AssignExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Assignment;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDate;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDouble;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionEnum;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionFalse;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionInt;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionString;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionTrue;
import ca.uottawa.csmlab.symboleo.symboleo.Attribute;
import ca.uottawa.csmlab.symboleo.symboleo.Comparison;
import ca.uottawa.csmlab.symboleo.symboleo.ContractEvent;
import ca.uottawa.csmlab.symboleo.symboleo.ContractState;
import ca.uottawa.csmlab.symboleo.symboleo.Div;
import ca.uottawa.csmlab.symboleo.symboleo.DomainType;
import ca.uottawa.csmlab.symboleo.symboleo.EnumItem;
import ca.uottawa.csmlab.symboleo.symboleo.Enumeration;
import ca.uottawa.csmlab.symboleo.symboleo.Equality;
import ca.uottawa.csmlab.symboleo.symboleo.Event;
import ca.uottawa.csmlab.symboleo.symboleo.Expression;
import ca.uottawa.csmlab.symboleo.symboleo.FunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalExpression;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Minus;
import ca.uottawa.csmlab.symboleo.symboleo.Model;
import ca.uottawa.csmlab.symboleo.symboleo.Multi;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPrimaryExpression;
import ca.uottawa.csmlab.symboleo.symboleo.OAssignExpression;
import ca.uottawa.csmlab.symboleo.symboleo.OAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.Obligation;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationState;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OntologyType;
import ca.uottawa.csmlab.symboleo.symboleo.Or;
import ca.uottawa.csmlab.symboleo.symboleo.PAnd;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomDateLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomDoubleLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomEnum;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomIntLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicate;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicateFalseLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicateTrueLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomStringLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomVariable;
import ca.uottawa.csmlab.symboleo.symboleo.PComparison;
import ca.uottawa.csmlab.symboleo.symboleo.PEquality;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractResumed;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractSuspended;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractTerminated;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationDischarged;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationResumed;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationSuspended;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationTerminated;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationTriggered;
import ca.uottawa.csmlab.symboleo.symboleo.POr;
import ca.uottawa.csmlab.symboleo.symboleo.Parameter;
import ca.uottawa.csmlab.symboleo.symboleo.Plus;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomContractEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomParameterDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomPowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Power;
import ca.uottawa.csmlab.symboleo.symboleo.PowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PowerFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PowerState;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignmentOnly;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappens;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensAfter;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensWithin;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionWHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionFunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.Proposition;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.RegularType;
import ca.uottawa.csmlab.symboleo.symboleo.Situation;
import ca.uottawa.csmlab.symboleo.symboleo.SituationExpression;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgDateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Timevalue;
import ca.uottawa.csmlab.symboleo.symboleo.TimevalueInt;
import ca.uottawa.csmlab.symboleo.symboleo.TimevalueVariable;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Variable;
import ca.uottawa.csmlab.symboleo.symboleo.VariableDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.VariableEvent;
import ca.uottawa.csmlab.symboleo.symboleo.VariableRef;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class SymboleoGenerator extends AbstractGenerator {
  private final String ASSET_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String EVENT_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String ROLE_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String POWER_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String OBLIGATION_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String CONTRACT_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String EVENTS_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String PREDICATES_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final String UTILS_CLASS_IMPORT_PATH = "\"symboleo-js-core\"";

  private final ArrayList<RegularType> assets = new ArrayList<RegularType>();

  private final ArrayList<RegularType> events = new ArrayList<RegularType>();

  private final ArrayList<RegularType> roles = new ArrayList<RegularType>();

  private final ArrayList<Enumeration> enumerations = new ArrayList<Enumeration>();

  private final ArrayList<Parameter> parameters = new ArrayList<Parameter>();

  private final ArrayList<Variable> variables = new ArrayList<Variable>();

  private final ArrayList<String> AssignVar = new ArrayList<String>();

  private final ArrayList<Obligation> conditionalObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> conditionalSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> conditionalPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> unconditionalObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> unconditionalSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> unconditionalPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> untriggeredObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> untriggeredSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> untriggeredPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> triggeredObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> triggeredSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> triggeredPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> allObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> allSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> allPowers = new ArrayList<Power>();

  private final ArrayList<String> arrays = new ArrayList<String>();

  private final ArrayList<Variable> eventVariables = new ArrayList<Variable>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerTriggerEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerAntecedentEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  public void generateHFSource(final IFileSystemAccess2 fsa, final Model model) {
    this.parse(model);
    this.compileDomainTypes(fsa, model);
    this.compileContract(fsa, model);
    this.compileEventsFile(fsa, model);
    this.compileTransactionFile(fsa, model);
    this.compileSerializerFile(fsa, model);
    this.generateNPMFile(fsa, model);
  }

  public void parse(final Model model) {
    this.parameters.addAll(model.getParameters());
    this.variables.addAll(model.getVariables());
    EList<DomainType> _domainTypes = model.getDomainTypes();
    for (final DomainType domainType : _domainTypes) {
      if ((domainType instanceof RegularType)) {
        RegularType base = Helpers.getBaseType(domainType);
        if ((base != null)) {
          String _name = base.getOntologyType().getName();
          if (_name != null) {
            switch (_name) {
              case "Asset":
                this.assets.add(((RegularType) domainType));
                break;
              case "Event":
                this.events.add(((RegularType) domainType));
                break;
              case "Role":
                this.roles.add(((RegularType) domainType));
                break;
            }
          }
        }
      } else {
        if ((domainType instanceof Enumeration)) {
          this.enumerations.add(((Enumeration) domainType));
        }
      }
    }
    EList<Variable> _variables = model.getVariables();
    for (final Variable variable : _variables) {
      int _indexOf = this.events.indexOf(variable.getType());
      boolean _notEquals = (_indexOf != (-1));
      if (_notEquals) {
        this.eventVariables.add(variable);
      }
    }
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        Proposition _trigger = obligation.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredObligations.add(obligation);
        } else {
          this.triggeredObligations.add(obligation);
        }
        Proposition _antecedent = obligation.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalObligations.add(obligation);
        } else {
          this.conditionalObligations.add(obligation);
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        Proposition _trigger = obligation_1.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredSurvivingObligations.add(obligation_1);
        } else {
          this.triggeredSurvivingObligations.add(obligation_1);
        }
        Proposition _antecedent = obligation_1.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalSurvivingObligations.add(obligation_1);
        } else {
          this.conditionalSurvivingObligations.add(obligation_1);
        }
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        Proposition _trigger = power.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredPowers.add(power);
        } else {
          this.triggeredPowers.add(power);
        }
        Proposition _antecedent = power.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalPowers.add(power);
        } else {
          this.conditionalPowers.add(power);
        }
      }
    }
    this.allObligations.addAll(this.untriggeredObligations);
    this.allObligations.addAll(this.triggeredObligations);
    this.allSurvivingObligations.addAll(this.untriggeredSurvivingObligations);
    this.allSurvivingObligations.addAll(this.triggeredSurvivingObligations);
    this.allPowers.addAll(this.untriggeredPowers);
    this.allPowers.addAll(this.triggeredPowers);
    for (final Obligation obligation_2 : this.untriggeredObligations) {
      {
        final Proposition proposition = obligation_2.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationTriggerEvents.put(obligation_2, list);
        }
      }
    }
    for (final Obligation obligation_3 : this.untriggeredSurvivingObligations) {
      {
        final Proposition proposition = obligation_3.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationTriggerEvents.put(obligation_3, list);
        }
      }
    }
    for (final Power power_1 : this.untriggeredPowers) {
      {
        final Proposition proposition = power_1.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.powerTriggerEvents.put(power_1, list);
        }
      }
    }
    for (final Obligation obligation_4 : this.allObligations) {
      {
        final Proposition proposition = obligation_4.getConsequent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationFullfilmentEvents.put(obligation_4, list);
        }
      }
    }
    for (final Obligation obligation_5 : this.allSurvivingObligations) {
      {
        final Proposition proposition = obligation_5.getConsequent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationFullfilmentEvents.put(obligation_5, list);
        }
      }
    }
    for (final Obligation obligation_6 : this.conditionalObligations) {
      {
        final Proposition proposition = obligation_6.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationAntecedentEvents.put(obligation_6, list);
        }
      }
    }
    for (final Obligation obligation_7 : this.conditionalSurvivingObligations) {
      {
        final Proposition proposition = obligation_7.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationAntecedentEvents.put(obligation_7, list);
        }
      }
    }
    for (final Power power_2 : this.conditionalPowers) {
      {
        final Proposition proposition = power_2.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.powerAntecedentEvents.put(power_2, list);
        }
      }
    }
  }

  public void generateNPMFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"name\": \"");
    String _lowerCase = model.getContractName().toLowerCase();
    _builder.append(_lowerCase, "  ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"version\": \"1.0.0\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"description\": \"\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"main\": \"index.js\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"engines\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"node\": \">=14\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"npm\": \">=5\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"scripts\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"lint\": \"eslint .\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"pretest\": \"npm run lint\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"test\": \"nyc mocha --recursive\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"start\": \"fabric-chaincode-node start\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"engineStrict\": true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"author\": \"Symboleo2SC\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"dependencies\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"fabric-contract-api\": \"^2.2.2\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"fabric-shim\": \"^2.2.2\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"symboleo-js-core\": \"^1.0.12\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"devDependencies\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"chai\": \"^4.1.2\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint\": \"^8.7.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint-config-airbnb-base\": \"^15.0.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint-plugin-import\": \"^2.25.4\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"mocha\": \"^8.0.1\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"nyc\": \"^14.1.1\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"sinon\": \"^6.0.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"sinon-chai\": \"^3.2.0\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String file = _builder.toString();
    String _contractName = model.getContractName();
    String _plus = ("./" + _contractName);
    String _plus_1 = (_plus + "/package.json");
    fsa.generateFile(_plus_1, file);
  }

  public String compileEventsMap() {
    Set<Obligation> _keySet = this.obligationTriggerEvents.keySet();
    for (final Obligation obligation : _keySet) {
      List<PAtomPredicate> _get = this.obligationTriggerEvents.get(obligation);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EventListeners.createObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      this.arrays.add(
        this.generateEventMapLineString(_get, _builder.toString()));
    }
    Set<Obligation> _keySet_1 = this.survivingObligationTriggerEvents.keySet();
    for (final Obligation obligation_1 : _keySet_1) {
      List<PAtomPredicate> _get_1 = this.survivingObligationTriggerEvents.get(obligation_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("EventListeners.createSurvivingObligation_");
      String _name_1 = obligation_1.getName();
      _builder_1.append(_name_1);
      this.arrays.add(
        this.generateEventMapLineString(_get_1, _builder_1.toString()));
    }
    Set<Power> _keySet_2 = this.powerTriggerEvents.keySet();
    for (final Power power : _keySet_2) {
      List<PAtomPredicate> _get_2 = this.powerTriggerEvents.get(power);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("EventListeners.createPower_");
      String _name_2 = power.getName();
      _builder_2.append(_name_2);
      this.arrays.add(
        this.generateEventMapLineString(_get_2, _builder_2.toString()));
    }
    Set<Obligation> _keySet_3 = this.obligationAntecedentEvents.keySet();
    for (final Obligation obligation_2 : _keySet_3) {
      List<PAtomPredicate> _get_3 = this.obligationAntecedentEvents.get(obligation_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("EventListeners.activateObligation_");
      String _name_3 = obligation_2.getName();
      _builder_3.append(_name_3);
      this.arrays.add(
        this.generateEventMapLineString(_get_3, _builder_3.toString()));
    }
    Set<Obligation> _keySet_4 = this.survivingObligationAntecedentEvents.keySet();
    for (final Obligation obligation_3 : _keySet_4) {
      List<PAtomPredicate> _get_4 = this.survivingObligationAntecedentEvents.get(obligation_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("EventListeners.activateSurvivingObligation_");
      String _name_4 = obligation_3.getName();
      _builder_4.append(_name_4);
      this.arrays.add(
        this.generateEventMapLineString(_get_4, _builder_4.toString()));
    }
    Set<Power> _keySet_5 = this.powerAntecedentEvents.keySet();
    for (final Power power_1 : _keySet_5) {
      List<PAtomPredicate> _get_5 = this.powerAntecedentEvents.get(power_1);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("EventListeners.activatePower_");
      String _name_5 = power_1.getName();
      _builder_5.append(_name_5);
      this.arrays.add(
        this.generateEventMapLineString(_get_5, _builder_5.toString()));
    }
    Set<Obligation> _keySet_6 = this.obligationFullfilmentEvents.keySet();
    for (final Obligation obligation_4 : _keySet_6) {
      List<PAtomPredicate> _get_6 = this.obligationFullfilmentEvents.get(obligation_4);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("EventListeners.fulfillObligation_");
      String _name_6 = obligation_4.getName();
      _builder_6.append(_name_6);
      this.arrays.add(
        this.generateEventMapLineString(_get_6, _builder_6.toString()));
    }
    Set<Obligation> _keySet_7 = this.survivingObligationFullfilmentEvents.keySet();
    for (final Obligation obligation_5 : _keySet_7) {
      List<PAtomPredicate> _get_7 = this.survivingObligationFullfilmentEvents.get(obligation_5);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("EventListeners.fulfillSurvivingObligation_");
      String _name_7 = obligation_5.getName();
      _builder_7.append(_name_7);
      this.arrays.add(
        this.generateEventMapLineString(_get_7, _builder_7.toString()));
    }
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("function getEventMap(contract) {");
    _builder_8.newLine();
    _builder_8.append("  ");
    _builder_8.append("return [");
    _builder_8.newLine();
    {
      for(final String line : this.arrays) {
        _builder_8.append("    ");
        _builder_8.append(line, "    ");
        _builder_8.newLineIfNotEmpty();
      }
    }
    _builder_8.append("  ");
    _builder_8.append("]");
    _builder_8.newLine();
    _builder_8.append("}");
    _builder_8.newLine();
    return _builder_8.toString();
  }

  public void compileSerializerFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const { ");
    String _contractName = model.getContractName();
    _builder.append(_contractName);
    _builder.append(" } = require(\"./domain/contract/");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1);
    _builder.append(".js\")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Obligation, ObligationActiveState, ObligationState } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { InternalEventType, InternalEvent, InternalEventSource} = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Event } = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { ContractState, ContractActiveState } = require(");
    _builder.append(this.CONTRACT_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Events } = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { EventListeners, getEventMap } = require(\"./events.js\")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function deserialize(data) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const object = JSON.parse(data)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contract = new ");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "  ");
    _builder.append("(");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      String _name = p.getName();
      return ("object." + _name);
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ", ");
    _builder.append(_join, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final String e : this.AssignVar) {
        _builder.append(" ");
        _builder.append("contract.");
        _builder.append(e, " ");
        _builder.append("= object.");
        _builder.append(e, " ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("contract.state = object.state");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contract.activeState = object.activeState");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const eventType of Object.keys(InternalEventType.contract)) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (object._events[eventType] != null) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const eventObject = new Event()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("eventObject._triggered = object._events[eventType]._triggered");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("eventObject._timestamp = object._events[eventType]._timestamp");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract._events[eventType] = eventObject");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of [");
    final Function1<Variable, String> _function_1 = (Variable v) -> {
      String _name = v.getName();
      String _plus = ("\'" + _name);
      return (_plus + "\'");
    };
    String _join_1 = IterableExtensions.join(ListExtensions.<Variable, String>map(this.eventVariables, _function_1), ", ");
    _builder.append(_join_1, "  ");
    _builder.append("]) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("for(const eKey of Object.keys(object[key])) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract[key][eKey] = object[key][eKey]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Obligation obligation : this.allObligations) {
        _builder.append("  ");
        _builder.append("if (object.obligations.");
        String _name = obligation.getName();
        _builder.append(_name, "  ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("const obligation = new Obligation(\'");
        String _name_1 = obligation.getName();
        _builder.append(_name_1, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString = this.generateDotExpressionString(obligation.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = this.generateDotExpressionString(obligation.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_1, "    ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation.state = object.obligations.");
        String _name_2 = obligation.getName();
        _builder.append(_name_2, "    ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation.activeState = object.obligations.");
        String _name_3 = obligation.getName();
        _builder.append(_name_3, "    ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation._createdPowerNames = object.obligations.");
        String _name_4 = obligation.getName();
        _builder.append(_name_4, "    ");
        _builder.append("._createdPowerNames");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation._suspendedByContractSuspension = object.obligations.");
        String _name_5 = obligation.getName();
        _builder.append(_name_5, "    ");
        _builder.append("._suspendedByContractSuspension");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.obligation)) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (object.obligations.");
        String _name_6 = obligation.getName();
        _builder.append(_name_6, "      ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._triggered = object.obligations.");
        String _name_7 = obligation.getName();
        _builder.append(_name_7, "        ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._timestamp = object.obligations.");
        String _name_8 = obligation.getName();
        _builder.append(_name_8, "        ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("obligation._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("contract.obligations.");
        String _name_9 = obligation.getName();
        _builder.append(_name_9, "    ");
        _builder.append(" = obligation");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      for(final Obligation obligation_1 : this.allSurvivingObligations) {
        _builder.append("  ");
        _builder.append("if (object.survivingObligations.");
        String _name_10 = obligation_1.getName();
        _builder.append(_name_10, "  ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("const obligation = new Obligation(\'");
        String _name_11 = obligation_1.getName();
        _builder.append(_name_11, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = this.generateDotExpressionString(obligation_1.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_2, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = this.generateDotExpressionString(obligation_1.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_3, "    ");
        _builder.append(", contract, true)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation.state = object.survivingObligations.");
        String _name_12 = obligation_1.getName();
        _builder.append(_name_12, "    ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation.activeState = object.survivingObligations.");
        String _name_13 = obligation_1.getName();
        _builder.append(_name_13, "    ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation._createdPowerNames = object.survivingObligations.");
        String _name_14 = obligation_1.getName();
        _builder.append(_name_14, "    ");
        _builder.append("._createdPowerNames");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("obligation._suspendedByContractSuspension = object.survivingObligations.");
        String _name_15 = obligation_1.getName();
        _builder.append(_name_15, "    ");
        _builder.append("._suspendedByContractSuspension");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.obligation)) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (object.survivingObligations.");
        String _name_16 = obligation_1.getName();
        _builder.append(_name_16, "      ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._triggered = object.survivingObligations.");
        String _name_17 = obligation_1.getName();
        _builder.append(_name_17, "        ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._timestamp = object.survivingObligations.");
        String _name_18 = obligation_1.getName();
        _builder.append(_name_18, "        ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("obligation._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("contract.survivingObligations.");
        String _name_19 = obligation_1.getName();
        _builder.append(_name_19, "    ");
        _builder.append(" = obligation");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    {
      for(final Power power : this.allPowers) {
        _builder.append("  ");
        _builder.append("if (object.powers.");
        String _name_20 = power.getName();
        _builder.append(_name_20, "  ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("const power = new Power(\'");
        String _name_21 = power.getName();
        _builder.append(_name_21, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = this.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_4, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = this.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_5, "    ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("power.state = object.powers.");
        String _name_22 = power.getName();
        _builder.append(_name_22, "    ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("power.activeState = object.powers.");
        String _name_23 = power.getName();
        _builder.append(_name_23, "    ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.power)) {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (object.powers.");
        String _name_24 = power.getName();
        _builder.append(_name_24, "      ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._triggered = object.powers.");
        String _name_25 = power.getName();
        _builder.append(_name_25, "        ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("eventObject._timestamp = object.powers.");
        String _name_26 = power.getName();
        _builder.append(_name_26, "        ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("power._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("contract.powers.");
        String _name_27 = power.getName();
        _builder.append(_name_27, "    ");
        _builder.append(" = power");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.append("return contract");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function serialize(contract) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of Object.keys(contract.obligations)){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.obligations[key].contract = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.obligations[key].creditor = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.obligations[key].debtor = undefined");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of Object.keys(contract.powers)){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.powers[key].contract = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.powers[key].creditor = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.powers[key].debtor = undefined");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of Object.keys(contract.survivingObligations)){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.survivingObligations[key].contract = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.survivingObligations[key].creditor = undefined");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.survivingObligations[key].debtor = undefined");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return JSON.stringify(contract)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("module.exports.deserialize = deserialize");
    _builder.newLine();
    _builder.append("module.exports.serialize = serialize");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName_3 = model.getContractName();
    String _plus = ("./" + _contractName_3);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + "serializer.js");
    fsa.generateFile(_plus_2, code);
  }

  public void compileEventsFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const { InternalEventSource, InternalEvent, InternalEventType } = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Obligation } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Predicates } = require(");
    _builder.append(this.PREDICATES_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Utils } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Str } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final Enumeration enumeration : this.enumerations) {
        _builder.append("const { ");
        String _name = enumeration.getName();
        _builder.append(_name);
        _builder.append(" } = require(\"./domain/types/");
        String _name_1 = enumeration.getName();
        _builder.append(_name_1);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("const EventListeners = {");
    _builder.newLine();
    {
      Set<Obligation> _keySet = this.obligationTriggerEvents.keySet();
      for(final Obligation obligation : _keySet) {
        _builder.append("  ");
        _builder.append("createObligation_");
        String _name_2 = obligation.getName();
        _builder.append(_name_2, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString = this.generatePropositionString(obligation.getTrigger());
        _builder.append(_generatePropositionString, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString = this.generatePropositionAssignString(obligation.getTrigger());
        String _plus = ("\n" + _generatePropositionAssignString);
        _builder.append(_plus, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.obligations.");
        String _name_3 = obligation.getName();
        _builder.append(_name_3, "      ");
        _builder.append(" == null || contract.obligations.");
        String _name_4 = obligation.getName();
        _builder.append(_name_4, "      ");
        _builder.append(".isFinished()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const isNewInstance =  contract.obligations.");
        String _name_5 = obligation.getName();
        _builder.append(_name_5, "        ");
        _builder.append(" != null && contract.obligations.");
        String _name_6 = obligation.getName();
        _builder.append(_name_6, "        ");
        _builder.append(".isFinished()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.obligations.");
        String _name_7 = obligation.getName();
        _builder.append(_name_7, "        ");
        _builder.append(" = new Obligation(\'");
        String _name_8 = obligation.getName();
        _builder.append(_name_8, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString = this.generateDotExpressionString(obligation.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = this.generateDotExpressionString(obligation.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_1, "        ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _xifexpression = null;
        Proposition _antecedent = obligation.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          _xifexpression = "true";
        } else {
          _xifexpression = "!isNewInstance ";
        }
        _builder.append(_xifexpression, "        ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(obligation.getAntecedent());
        String _plus_1 = ("\n" + _generatePropositionAssignString_1);
        _builder.append(_plus_1, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.obligations.");
        String _name_9 = obligation.getName();
        _builder.append(_name_9, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("if (!isNewInstance && ");
        String _generatePropositionString_1 = this.generatePropositionString(obligation.getConsequent());
        _builder.append(_generatePropositionString_1, "          ");
        _builder.append(") { ");
        String _generatePropositionAssignString_2 = this.generatePropositionAssignString(obligation.getConsequent());
        String _plus_2 = ("\n" + _generatePropositionAssignString_2);
        _builder.append(_plus_2, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("contract.obligations.");
        String _name_10 = obligation.getName();
        _builder.append(_name_10, "            ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.obligations.");
        String _name_11 = obligation.getName();
        _builder.append(_name_11, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_1 = this.survivingObligationTriggerEvents.keySet();
      for(final Obligation obligation_1 : _keySet_1) {
        _builder.append("  ");
        _builder.append("createSurvivingObligation_");
        String _name_12 = obligation_1.getName();
        _builder.append(_name_12, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString_2 = this.generatePropositionString(obligation_1.getTrigger());
        _builder.append(_generatePropositionString_2, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_3 = this.generatePropositionAssignString(obligation_1.getTrigger());
        String _plus_3 = ("\n" + _generatePropositionAssignString_3);
        _builder.append(_plus_3, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.survivingObligations.");
        String _name_13 = obligation_1.getName();
        _builder.append(_name_13, "      ");
        _builder.append(" == null || contract.survivingObligations.");
        String _name_14 = obligation_1.getName();
        _builder.append(_name_14, "      ");
        _builder.append(".isFinished()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.survivingObligations.");
        String _name_15 = obligation_1.getName();
        _builder.append(_name_15, "        ");
        _builder.append(" = new Obligation(\'");
        String _name_16 = obligation_1.getName();
        _builder.append(_name_16, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = this.generateDotExpressionString(obligation_1.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_2, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = this.generateDotExpressionString(obligation_1.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_3, "        ");
        _builder.append(", contract, true)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _generatePropositionString_3 = this.generatePropositionString(obligation_1.getAntecedent());
        _builder.append(_generatePropositionString_3, "        ");
        _builder.append(") { ");
        String _generatePropositionAssignString_4 = this.generatePropositionAssignString(obligation_1.getAntecedent());
        String _plus_4 = ("\n" + _generatePropositionAssignString_4);
        _builder.append(_plus_4, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.survivingObligations.");
        String _name_17 = obligation_1.getName();
        _builder.append(_name_17, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        String _xifexpression_1 = null;
        Proposition _consequent = obligation_1.getConsequent();
        if ((_consequent instanceof PAtomPredicate)) {
          _xifexpression_1 = "";
        } else {
          String _generatePropositionString_4 = this.generatePropositionString(obligation_1.getAntecedent());
          String _plus_5 = (" if ( !isNewInstance &&" + _generatePropositionString_4);
          _xifexpression_1 = (_plus_5 + ")");
        }
        _builder.append(_xifexpression_1, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("if (");
        String _generatePropositionString_5 = this.generatePropositionString(obligation_1.getConsequent());
        _builder.append(_generatePropositionString_5, "          ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_5 = this.generatePropositionAssignString(obligation_1.getConsequent());
        String _plus_6 = ("\n" + _generatePropositionAssignString_5);
        _builder.append(_plus_6, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("contract.survivingObligations.");
        String _name_18 = obligation_1.getName();
        _builder.append(_name_18, "            ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.survivingObligations.");
        String _name_19 = obligation_1.getName();
        _builder.append(_name_19, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Power> _keySet_2 = this.powerTriggerEvents.keySet();
      for(final Power power : _keySet_2) {
        _builder.append("  ");
        _builder.append("createPower_");
        String _name_20 = power.getName();
        _builder.append(_name_20, "  ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("const effects = { powerCreated: false } ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString_6 = this.generatePropositionString(power.getTrigger());
        _builder.append(_generatePropositionString_6, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_6 = this.generatePropositionAssignString(power.getTrigger());
        String _plus_7 = ("\n" + _generatePropositionAssignString_6);
        _builder.append(_plus_7, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.powers.");
        String _name_21 = power.getName();
        _builder.append(_name_21, "      ");
        _builder.append(" == null || contract.powers.");
        String _name_22 = power.getName();
        _builder.append(_name_22, "      ");
        _builder.append(".isFinished()){");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const isNewInstance =  contract.powers.");
        String _name_23 = power.getName();
        _builder.append(_name_23, "        ");
        _builder.append(" != null && contract.powers.");
        String _name_24 = power.getName();
        _builder.append(_name_24, "        ");
        _builder.append(".isFinished()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.powers.");
        String _name_25 = power.getName();
        _builder.append(_name_25, "        ");
        _builder.append(" = new Power(\'");
        String _name_26 = power.getName();
        _builder.append(_name_26, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = this.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_4, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = this.generateDotExpressionString(power.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_5, "        ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("effects.powerCreated = true");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("effects.powerName = \'");
        String _name_27 = power.getName();
        _builder.append(_name_27, "        ");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _xifexpression_2 = null;
        Proposition _antecedent_1 = power.getAntecedent();
        if ((_antecedent_1 instanceof PAtomPredicateTrueLiteral)) {
          _xifexpression_2 = "true";
        } else {
          String _generatePropositionString_7 = this.generatePropositionString(power.getAntecedent());
          _xifexpression_2 = ("!isNewInstance && " + _generatePropositionString_7);
        }
        _builder.append(_xifexpression_2, "        ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_7 = this.generatePropositionAssignString(power.getAntecedent());
        String _plus_8 = ("\n" + _generatePropositionAssignString_7);
        _builder.append(_plus_8, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.powers.");
        String _name_28 = power.getName();
        _builder.append(_name_28, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.powers.");
        String _name_29 = power.getName();
        _builder.append(_name_29, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("return effects");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_3 = this.obligationAntecedentEvents.keySet();
      for(final Obligation obligation_2 : _keySet_3) {
        _builder.append("  ");
        _builder.append("activateObligation_");
        String _name_30 = obligation_2.getName();
        _builder.append(_name_30, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.obligations.");
        String _name_31 = obligation_2.getName();
        _builder.append(_name_31, "    ");
        _builder.append(" != null && (");
        String _generatePropositionString_8 = this.generatePropositionString(obligation_2.getAntecedent());
        _builder.append(_generatePropositionString_8, "    ");
        _builder.append(")) { ");
        String _generatePropositionAssignString_8 = this.generatePropositionAssignString(obligation_2.getAntecedent());
        String _plus_9 = ("\n" + _generatePropositionAssignString_8);
        _builder.append(_plus_9, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.obligations.");
        String _name_32 = obligation_2.getName();
        _builder.append(_name_32, "      ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (");
        String _generatePropositionString_9 = this.generatePropositionString(obligation_2.getConsequent());
        _builder.append(_generatePropositionString_9, "      ");
        _builder.append(") { ");
        String _generatePropositionAssignString_9 = this.generatePropositionAssignString(obligation_2.getConsequent());
        String _plus_10 = ("\n" + _generatePropositionAssignString_9);
        _builder.append(_plus_10, "      ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.obligations.");
        String _name_33 = obligation_2.getName();
        _builder.append(_name_33, "        ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_4 = this.survivingObligationAntecedentEvents.keySet();
      for(final Obligation obligation_3 : _keySet_4) {
        _builder.append("  ");
        _builder.append("activateSurvivingObligation_");
        String _name_34 = obligation_3.getName();
        _builder.append(_name_34, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.survivingObligations.");
        String _name_35 = obligation_3.getName();
        _builder.append(_name_35, "    ");
        _builder.append(" != null  && (");
        String _generatePropositionString_10 = this.generatePropositionString(obligation_3.getAntecedent());
        _builder.append(_generatePropositionString_10, "    ");
        _builder.append(")  ) { ");
        String _generatePropositionAssignString_10 = this.generatePropositionAssignString(obligation_3.getAntecedent());
        String _plus_11 = ("\n" + _generatePropositionAssignString_10);
        _builder.append(_plus_11, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.survivingObligations.");
        String _name_36 = obligation_3.getName();
        _builder.append(_name_36, "      ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (");
        String _generatePropositionString_11 = this.generatePropositionString(obligation_3.getConsequent());
        _builder.append(_generatePropositionString_11, "      ");
        _builder.append(") { ");
        String _generatePropositionAssignString_11 = this.generatePropositionAssignString(obligation_3.getConsequent());
        String _plus_12 = ("\n" + _generatePropositionAssignString_11);
        _builder.append(_plus_12, "      ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.survivingObligations.");
        String _name_37 = obligation_3.getName();
        _builder.append(_name_37, "        ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Power> _keySet_5 = this.powerAntecedentEvents.keySet();
      for(final Power power_1 : _keySet_5) {
        _builder.append("  ");
        _builder.append("activatePower_");
        String _name_38 = power_1.getName();
        _builder.append(_name_38, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.powers.");
        String _name_39 = power_1.getName();
        _builder.append(_name_39, "    ");
        _builder.append(" != null && (");
        String _generatePropositionString_12 = this.generatePropositionString(power_1.getAntecedent());
        _builder.append(_generatePropositionString_12, "    ");
        _builder.append(")) {  ");
        String _generatePropositionAssignString_12 = this.generatePropositionAssignString(power_1.getAntecedent());
        String _plus_13 = ("\n" + _generatePropositionAssignString_12);
        _builder.append(_plus_13, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.powers.");
        String _name_40 = power_1.getName();
        _builder.append(_name_40, "      ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_6 = this.obligationFullfilmentEvents.keySet();
      for(final Obligation obligation_4 : _keySet_6) {
        _builder.append("  ");
        _builder.append("fulfillObligation_");
        String _name_41 = obligation_4.getName();
        _builder.append(_name_41, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.obligations.");
        String _name_42 = obligation_4.getName();
        _builder.append(_name_42, "    ");
        _builder.append(" != null && (");
        String _generatePropositionString_13 = this.generatePropositionString(obligation_4.getConsequent());
        _builder.append(_generatePropositionString_13, "    ");
        _builder.append(") ) { ");
        String _generatePropositionAssignString_13 = this.generatePropositionAssignString(obligation_4.getConsequent());
        String _plus_14 = ("\n" + _generatePropositionAssignString_13);
        _builder.append(_plus_14, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.obligations.");
        String _name_43 = obligation_4.getName();
        _builder.append(_name_43, "      ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_7 = this.survivingObligationFullfilmentEvents.keySet();
      for(final Obligation obligation_5 : _keySet_7) {
        _builder.append("  ");
        _builder.append("fulfillSurvivingObligation_");
        String _name_44 = obligation_5.getName();
        _builder.append(_name_44, "  ");
        _builder.append("(contract) { ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.survivingObligations.");
        String _name_45 = obligation_5.getName();
        _builder.append(_name_45, "    ");
        _builder.append(" != null && ");
        String _generatePropositionString_14 = this.generatePropositionString(obligation_5.getConsequent());
        _builder.append(_generatePropositionString_14, "    ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_14 = this.generatePropositionAssignString(obligation_5.getConsequent());
        String _plus_15 = ("\n" + _generatePropositionAssignString_14);
        _builder.append(_plus_15, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.survivingObligations.");
        String _name_46 = obligation_5.getName();
        _builder.append(_name_46, "      ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.append("successfullyTerminateContract(contract) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (const oblKey of Object.keys(contract.obligations)) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (contract.obligations[oblKey].isActive()) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (contract.obligations[oblKey].isViolated() && Array.isArray(contract.obligations[oblKey]._createdPowerNames)) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("for (const pKey of contract.obligations[oblKey]._createdPowerNames) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("if (!contract.powers[pKey].isSuccessfulTermination()) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.fulfilledActiveObligations()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("unsuccessfullyTerminateContract(contract) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.obligations) { ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.obligations[index].terminated({emitEvent: false})");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.powers) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.powers[index].terminated()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.terminated()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}     ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _compileEventsMap = this.compileEventsMap();
    _builder.append(_compileEventsMap);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("module.exports.EventListeners = EventListeners");
    _builder.newLine();
    _builder.append("module.exports.getEventMap = getEventMap");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName = model.getContractName();
    String _plus_16 = ("./" + _contractName);
    String _plus_17 = (_plus_16 + "/");
    String _plus_18 = (_plus_17 + "events.js");
    fsa.generateFile(_plus_18, code);
  }

  public String generateEventMapLineString(final List<PAtomPredicate> predicates, final String listenerName) {
    final StringBuilder line = new StringBuilder();
    line.append("[[");
    for (final PAtomPredicate predicate : predicates) {
      {
        final PredicateFunction pf = predicate.getPredicateFunction();
        boolean _matched = false;
        if (pf instanceof PredicateFunctionHappens) {
          _matched=true;
          String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappens)pf).getEvent());
          String _plus = (_generateInternalEventObjectString + ", ");
          line.append(_plus);
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionWHappensBefore) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionWHappensBefore)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionHappensAfter) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappensAfter)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionSHappensBefore) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionSHappensBefore)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
            final String res = this.generatePointInternalEventObjectString(((PredicateFunctionSHappensBefore)pf).getPoint().getPointExpression());
            if ((res != null)) {
              line.append((res + ", "));
            }
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionHappensWithin) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappensWithin)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
            final IntervalExpression interval = ((PredicateFunctionHappensWithin)pf).getInterval().getIntervalExpression();
            boolean _matched_1 = false;
            if (interval instanceof IntervalFunction) {
              _matched_1=true;
              final String res1 = this.generatePointInternalEventObjectString(((IntervalFunction)interval).getArg1());
              final String res2 = this.generatePointInternalEventObjectString(((IntervalFunction)interval).getArg2());
              if ((res1 != null)) {
                line.append((res1 + ", "));
              }
              if ((res2 != null)) {
                line.append((res2 + ", "));
              }
            }
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionAssignment) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionAssignment)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
      }
    }
    String _string = line.toString();
    boolean _notEquals = (!Objects.equal(_string, "[["));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("], ");
      _builder.append(listenerName);
      _builder.append("],");
      line.append(_builder);
      return line.toString();
    } else {
      return "";
    }
  }

  public String generateInternalEventObjectString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, ");
      String _generateDotExpressionString = this.generateDotExpressionString(((VariableEvent)event).getVariable(), "contract");
      _builder.append(_generateDotExpressionString);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.obligation, InternalEventType.obligation.");
        String _eventName = ((ObligationEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.contract, InternalEventType.contract.");
        String _eventName = ((ContractEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract)");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.power, InternalEventType.power.");
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.powers.");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  /**
   * def String generateAssignObjectString(Assignment a) {
   * var s = ""
   * 
   * if (a instanceof AssignExpression)
   * s= "contract."+ a.name + " = " + generateExpressionString(a.value, 'contract')
   * return s
   * 
   * }
   */
  public String generateOAssignObjectString(final List<OAssignment> a) {
    String s = "";
    String eName = "";
    boolean found = false;
    for (final OAssignment e : a) {
      {
        found = false;
        if ((e instanceof OAssignExpression)) {
          eName = this.generateDotExpressionString(((OAssignExpression)e).getName2(), "");
          boolean _contains = this.AssignVar.contains(eName);
          boolean _not = (!_contains);
          if (_not) {
            for (final Parameter p : this.parameters) {
              String _string = p.getName().toString();
              String _string_1 = eName.toString();
              boolean _equals = Objects.equal(_string, _string_1);
              if (_equals) {
                found = true;
              }
            }
            if ((!found)) {
              this.AssignVar.add(eName);
            }
          }
          String _generateDotExpressionString = this.generateDotExpressionString(((OAssignExpression)e).getName2(), "contract");
          String _plus = (s + _generateDotExpressionString);
          String _plus_1 = (_plus + " = ");
          String _generateExpressionString = this.generateExpressionString(((OAssignExpression)e).getValue(), "contract");
          String _plus_2 = (_plus_1 + _generateExpressionString);
          s = _plus_2;
          s = (s + " \n");
        }
      }
    }
    return s;
  }

  public String generatePointInternalEventObjectString(final PointExpression p) {
    boolean _matched = false;
    if (p instanceof PointFunction) {
      _matched=true;
      final String res = this.generatePointInternalEventObjectString(((PointFunction)p).getArg());
      if ((res != null)) {
        return res;
      } else {
        return null;
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomParameterDotExpression) {
        _matched=true;
        Boolean _isDotExpressionTypeOfEvent = Helpers.isDotExpressionTypeOfEvent(((PointAtomParameterDotExpression)p).getVariable(), this.variables, this.parameters);
        if ((_isDotExpressionTypeOfEvent).booleanValue()) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, ");
          String _generateDotExpressionString = this.generateDotExpressionString(((PointAtomParameterDotExpression)p).getVariable(), "contract");
          _builder.append(_generateDotExpressionString);
          _builder.append(")");
          return _builder.toString();
        } else {
          return null;
        }
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomObligationEvent) {
        _matched=true;
        Event _obligationEvent = ((PointAtomObligationEvent)p).getObligationEvent();
        final ObligationEvent e = ((ObligationEvent) _obligationEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.obligation, InternalEventType.obligation.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(e.getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = e.getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomContractEvent) {
        _matched=true;
        Event _contractEvent = ((PointAtomContractEvent)p).getContractEvent();
        final ContractEvent e = ((ContractEvent) _contractEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.contract, InternalEventType.contract.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract)");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomPowerEvent) {
        _matched=true;
        Event _powerEvent = ((PointAtomPowerEvent)p).getPowerEvent();
        final PowerEvent e = ((PowerEvent) _powerEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.power, InternalEventType.power.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.powers.");
        String _name = e.getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  private boolean isSurvivingObligation(final String name) {
    for (final Obligation obligation : this.allObligations) {
      boolean _equals = obligation.getName().equals(name);
      if (_equals) {
        return false;
      }
    }
    for (final Obligation obligation_1 : this.allSurvivingObligations) {
      boolean _equals_1 = obligation_1.getName().equals(name);
      if (_equals_1) {
        return true;
      }
    }
    return false;
  }

  public List<PAtomPredicate> collectPropositionEvents(final Proposition proposition) {
    final ArrayList<PAtomPredicate> list = new ArrayList<PAtomPredicate>();
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      list.addAll(this.collectPropositionEvents(((POr)proposition).getLeft()));
      list.addAll(this.collectPropositionEvents(((POr)proposition).getRight()));
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PAnd)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PAnd)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PEquality)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PEquality)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PComparison)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PComparison)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PAtomRecursive)proposition).getInner()));
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((NegatedPAtom)proposition).getNegated()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        PredicateFunction _predicateFunction = ((PAtomPredicate)proposition).getPredicateFunction();
        boolean _not = (!(_predicateFunction instanceof PredicateFunctionAssignmentOnly));
        if (_not) {
          list.add(((PAtomPredicate)proposition));
        }
      }
    }
    return list;
  }

  public String generatePropositionString(final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionString = this.generatePropositionString(((POr)proposition).getLeft());
      String _plus = (_generatePropositionString + " || ");
      String _generatePropositionString_1 = this.generatePropositionString(((POr)proposition).getRight());
      return (_plus + _generatePropositionString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAnd)proposition).getLeft());
        String _plus = (_generatePropositionString + " && ");
        String _generatePropositionString_1 = this.generatePropositionString(((PAnd)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PEquality)proposition).getLeft());
        String _equalityOperator = this.getEqualityOperator(((PEquality)proposition).getOp());
        String _plus = (_generatePropositionString + _equalityOperator);
        String _generatePropositionString_1 = this.generatePropositionString(((PEquality)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PComparison)proposition).getLeft());
        String _plus = (_generatePropositionString + " ");
        String _op = ((PComparison)proposition).getOp();
        String _plus_1 = (_plus + _op);
        String _plus_2 = (_plus_1 + " ");
        String _generatePropositionString_1 = this.generatePropositionString(((PComparison)proposition).getRight());
        return (_plus_2 + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAtomRecursive)proposition).getInner());
        String _plus = ("(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((NegatedPAtom)proposition).getNegated());
        String _plus = ("!(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateFunctionString(((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        String _name = ((PAtomEnum)proposition).getEnumeration().getName();
        String _plus = (_name + ".");
        String _name_1 = ((PAtomEnum)proposition).getEnumItem().getName();
        return (_plus + _name_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return this.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), "contract");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDoubleLiteral) {
        _matched=true;
        return Double.valueOf(((PAtomDoubleLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomIntLiteral) {
        _matched=true;
        return Integer.valueOf(((PAtomIntLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDateLiteral) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(new Date(\"");
        String _string = ((PAtomDateLiteral)proposition).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\").toISOString())");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    return null;
  }

  public String generatePropositionAssignString(final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionAssignString = this.generatePropositionAssignString(((POr)proposition).getLeft());
      String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((POr)proposition).getRight());
      return (_generatePropositionAssignString + _generatePropositionAssignString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PAnd)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PAnd)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PEquality)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PEquality)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PComparison)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PComparison)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        return this.generatePropositionAssignString(((PAtomRecursive)proposition).getInner());
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        return this.generatePropositionAssignString(((NegatedPAtom)proposition).getNegated());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateAssignString(((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    return " ";
  }

  public String generatePredicateFunctionString(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Predicates.happens(");
      String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
      _builder.append(_generateEventVariableString);
      _builder.append(") ");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happensAfter(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionHappensAfter)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.weakHappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionWHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.strongHappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionSHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happensWithin(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generateIntervalExpresionArgString = this.generateIntervalExpresionArgString(((PredicateFunctionHappensWithin)predicate).getInterval().getIntervalExpression());
        _builder.append(_generateIntervalExpresionArgString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignment) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happens(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionAssignment)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignmentOnly) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("true");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generatePredicateAssignString(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionAssignment) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      String _generateOAssignObjectString = this.generateOAssignObjectString(((PredicateFunctionAssignment)predicate).getAssignment());
      _builder.append(_generateOAssignObjectString, " ");
      _builder.append(" ");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignmentOnly) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        String _generateOAssignObjectString = this.generateOAssignObjectString(((PredicateFunctionAssignmentOnly)predicate).getAssignment());
        _builder.append(_generateOAssignObjectString, " ");
        _builder.append(" ");
        return _builder.toString();
      }
    }
    return " ";
  }

  public String generateEventVariableString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      return this.generateDotExpressionString(((VariableEvent)event).getVariable(), "contract");
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.powers.");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.powers.");
        String _name_1 = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.");
        String _xifexpression_1 = null;
        boolean _isSurvivingObligation_1 = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation_1) {
          _xifexpression_1 = "survivingObligations";
        } else {
          _xifexpression_1 = "obligations";
        }
        _builder.append(_xifexpression_1);
        _builder.append(".");
        String _name_1 = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = ((ObligationEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract._events.");
        String _eventName = ((ContractEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    return null;
  }

  public String generatePointExpresionString(final PointExpression point) {
    boolean _matched = false;
    if (point instanceof PointFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Utils.addTime(");
      String _generatePointExpresionString = this.generatePointExpresionString(((PointFunction)point).getArg());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generateTimeValueString = this.generateTimeValueString(((PointFunction)point).getValue());
      _builder.append(_generateTimeValueString);
      _builder.append(", \"");
      String _timeUnit = ((PointFunction)point).getTimeUnit();
      _builder.append(_timeUnit);
      _builder.append("\")");
      return _builder.toString();
    }
    if (!_matched) {
      if (point instanceof PointAtomParameterDotExpression) {
        _matched=true;
        Boolean _isDotExpressionTypeOfEvent = Helpers.isDotExpressionTypeOfEvent(((PointAtomParameterDotExpression)point).getVariable(), this.variables, this.parameters);
        if ((_isDotExpressionTypeOfEvent).booleanValue()) {
          StringConcatenation _builder = new StringConcatenation();
          String _generateDotExpressionString = this.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), "contract");
          _builder.append(_generateDotExpressionString);
          _builder.append("._timestamp");
          return _builder.toString();
        } else {
          return this.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), "contract");
        }
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomObligationEvent) {
        _matched=true;
        Event _obligationEvent = ((PointAtomObligationEvent)point).getObligationEvent();
        final ObligationEvent e = ((ObligationEvent) _obligationEvent);
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(e.getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        final String obligationRef = _xifexpression;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name = e.getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name_1 = e.getObligationVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name_2 = e.getObligationVariable().getName();
        _builder.append(_name_2);
        _builder.append("._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomPowerEvent) {
        _matched=true;
        Event _powerEvent = ((PointAtomPowerEvent)point).getPowerEvent();
        final PowerEvent e = ((PowerEvent) _powerEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.powers.");
        String _name = e.getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.powers.");
        String _name_1 = e.getPowerVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract.powers.");
        String _name_2 = e.getPowerVariable().getName();
        _builder.append(_name_2);
        _builder.append("._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomContractEvent) {
        _matched=true;
        Event _contractEvent = ((PointAtomContractEvent)point).getContractEvent();
        final ContractEvent e = ((ContractEvent) _contractEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateTimeValueString(final Timevalue tv) {
    boolean _matched = false;
    if (tv instanceof TimevalueInt) {
      _matched=true;
      return Integer.valueOf(((TimevalueInt)tv).getValue()).toString();
    }
    if (!_matched) {
      if (tv instanceof TimevalueVariable) {
        _matched=true;
        return this.generateDotExpressionString(((TimevalueVariable)tv).getVariable(), "contract");
      }
    }
    return null;
  }

  public String generateIntervalExpresionArgString(final IntervalExpression interval) {
    boolean _matched = false;
    if (interval instanceof IntervalFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _generatePointExpresionString = this.generatePointExpresionString(((IntervalFunction)interval).getArg1());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generatePointExpresionString_1 = this.generatePointExpresionString(((IntervalFunction)interval).getArg2());
      _builder.append(_generatePointExpresionString_1);
      return _builder.toString();
    }
    if (!_matched) {
      if (interval instanceof SituationExpression) {
        _matched=true;
        final Situation situation = ((SituationExpression)interval).getSituation();
        boolean _matched_1 = false;
        if (situation instanceof ObligationState) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("contract.");
          String _xifexpression = null;
          boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationState)situation).getObligationVariable().getName());
          if (_isSurvivingObligation) {
            _xifexpression = "survivingObligations";
          } else {
            _xifexpression = "obligations";
          }
          _builder.append(_xifexpression);
          _builder.append(".");
          String _name = ((ObligationState)situation).getObligationVariable().getName();
          _builder.append(_name);
          _builder.append(", \"Obligation.");
          String _stateName = ((ObligationState)situation).getStateName();
          _builder.append(_stateName);
          _builder.append("\"");
          return _builder.toString();
        }
        if (!_matched_1) {
          if (situation instanceof PowerState) {
            _matched_1=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("contract.powers.");
            String _name = ((PowerState)situation).getPowerVariable().getName();
            _builder.append(_name);
            _builder.append(", \"Power.");
            String _stateName = ((PowerState)situation).getStateName();
            _builder.append(_stateName);
            _builder.append("\"\"");
            return _builder.toString();
          }
        }
        if (!_matched_1) {
          if (situation instanceof ContractState) {
            _matched_1=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("contract, \"Contract.");
            String _stateName = ((ContractState)situation).getStateName();
            _builder.append(_stateName);
            _builder.append("\"");
            return _builder.toString();
          }
        }
      }
    }
    return null;
  }

  public void compileTransactionFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const { Contract } = require(\"fabric-contract-api\") ");
    _builder.newLine();
    _builder.append("const { ");
    String _contractName = model.getContractName();
    _builder.append(_contractName);
    _builder.append(" } = require(\"./domain/contract/");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1);
    _builder.append(".js\")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { deserialize, serialize } = require(\"./serializer.js\")");
    _builder.newLine();
    _builder.append("const { Events } = require(");
    _builder.append(this.EVENT_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { InternalEvent, InternalEventSource, InternalEventType } = require(");
    _builder.append(this.EVENT_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { getEventMap, EventListeners } = require(\"./events.js\")");
    _builder.newLine();
    _builder.append("class HFContract extends Contract {");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("super(\'");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "    ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("initialize(contract) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Events.init(getEventMap(contract), EventListeners)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    String _compileInitMethod = this.compileInitMethod(model);
    _builder.append(_compileInitMethod, "  ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<String> _compileEventTriggerMethods = this.compileEventTriggerMethods(model);
      for(final String method : _compileEventTriggerMethods) {
        _builder.append("  ");
        _builder.append(method, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.newLine();
      }
    }
    {
      List<String> _compilePowerTransactions = this.compilePowerTransactions(model);
      for(final String method_1 : _compilePowerTransactions) {
        _builder.append("  ");
        _builder.append(method_1, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.newLine();
      }
    }
    {
      List<String> _compileViolationEventsTransactions = this.compileViolationEventsTransactions(model);
      for(final String method_2 : _compileViolationEventsTransactions) {
        _builder.append("  ");
        _builder.append(method_2, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.newLine();
      }
    }
    {
      List<String> _compileExpirationTransactions = this.compileExpirationTransactions(model);
      for(final String method_3 : _compileExpirationTransactions) {
        _builder.append("  ");
        _builder.append(method_3, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.newLine();
      }
    }
    {
      List<String> _compilePowerExpirationTransactions = this.compilePowerExpirationTransactions(model);
      for(final String method_4 : _compilePowerExpirationTransactions) {
        _builder.append("  ");
        _builder.append(method_4, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("async getState(ctx, contractId) {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("let output = `Contract state: ${contract.state}-${contract.activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("output += \'Obligations:\\r\\n\'");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("for (const obligationKey of Object.keys(contract.obligations)) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("output += `  ${obligationKey}: ${contract.obligations[obligationKey].state}-${contract.obligations[obligationKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("output += \'Powers:\\r\\n\'");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (const powerKey of Object.keys(contract.powers)) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("output += `  ${powerKey}: ${contract.powers[powerKey].state}-${contract.powers[powerKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("output += \'Surviving Obligations:\\r\\n\'");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (const obligationKey of Object.keys(contract.survivingObligations)) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("output += `  ${obligationKey}: ${contract.survivingObligations[obligationKey].state}-${contract.survivingObligations[obligationKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("output += \'Events:\\r\\n\'");
    _builder.newLine();
    {
      for(final Variable event : this.eventVariables) {
        _builder.append("    ");
        _builder.append("if (contract.");
        String _name = event.getName();
        _builder.append(_name, "    ");
        _builder.append("._triggered) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("  ");
        _builder.append("output += `  Event \"");
        String _name_1 = event.getName();
        _builder.append(_name_1, "      ");
        _builder.append("\" happened at ${contract.");
        String _name_2 = event.getName();
        _builder.append(_name_2, "      ");
        _builder.append("._timestamp}\\r\\n`");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("  ");
        _builder.append("output += `  Event \"");
        String _name_3 = event.getName();
        _builder.append(_name_3, "      ");
        _builder.append("\" has not happened\\r\\n`");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return output");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("module.exports.contracts = [HFContract];");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName_3 = model.getContractName();
    String _plus = ("./" + _contractName_3);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + "index.js");
    fsa.generateFile(_plus_2, code);
  }

  public List<String> compileViolationEventsTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Obligation obligation : this.allObligations) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async violateObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("if (contract.obligations.");
      String _name_1 = obligation.getName();
      _builder.append(_name_1, "    ");
      _builder.append(" != null && contract.obligations.");
      String _name_2 = obligation.getName();
      _builder.append(_name_2, "    ");
      _builder.append(".violated()) {      ");
      _builder.newLineIfNotEmpty();
      _builder.append("      ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    for (final Obligation obligation_1 : this.allSurvivingObligations) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("async violateSurvivingObligations_");
      String _name_3 = obligation_1.getName();
      _builder_1.append(_name_3);
      _builder_1.append("(ctx, contractId) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  ");
      _builder_1.append("const contractState = await ctx.stub.getState(contractId)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contractState == null) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contract = deserialize(contractState.toString())");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("this.initialize(contract)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contract.isInEffect() || contract.isSuccessfulTermination()) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (contract.survivingObligations.");
      String _name_4 = obligation_1.getName();
      _builder_1.append(_name_4, "    ");
      _builder_1.append(" != null && contract.survivingObligations.");
      String _name_5 = obligation_1.getName();
      _builder_1.append(_name_5, "    ");
      _builder_1.append(".violated()) {      ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("      ");
      _builder_1.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: true}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      methods.add(_builder_1.toString());
    }
    return methods;
  }

  public List<String> compileExpirationTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Obligation obligation : this.conditionalObligations) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async expireObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("if (contract.obligations.");
      String _name_1 = obligation.getName();
      _builder.append(_name_1, "    ");
      _builder.append(" != null && contract.obligations.");
      String _name_2 = obligation.getName();
      _builder.append(_name_2, "    ");
      _builder.append(".expired()) {      ");
      _builder.newLineIfNotEmpty();
      _builder.append("      ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    for (final Obligation obligation_1 : this.conditionalSurvivingObligations) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("async expireSurvivingObligation_");
      String _name_3 = obligation_1.getName();
      _builder_1.append(_name_3);
      _builder_1.append("(ctx, contractId) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  ");
      _builder_1.append("const contractState = await ctx.stub.getState(contractId)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contractState == null) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contract = deserialize(contractState.toString())");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("this.initialize(contract)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contract.isInEffect() || contract.isSuccessfulTermination()) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (contract.survivingObligations.");
      String _name_4 = obligation_1.getName();
      _builder_1.append(_name_4, "    ");
      _builder_1.append(" != null && contract.survivingObligations.");
      String _name_5 = obligation_1.getName();
      _builder_1.append(_name_5, "    ");
      _builder_1.append(".expired()) {      ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("      ");
      _builder_1.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: true}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      methods.add(_builder_1.toString());
    }
    return methods;
  }

  public List<String> compilePowerExpirationTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Power power : this.allPowers) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async expirePower_");
      String _name = power.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("if (contract.powers.");
      String _name_1 = power.getName();
      _builder.append(_name_1, "    ");
      _builder.append(" != null && contract.powers.");
      String _name_2 = power.getName();
      _builder.append(_name_2, "    ");
      _builder.append(".expired()) {      ");
      _builder.newLineIfNotEmpty();
      _builder.append("      ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    return methods;
  }

  public List<String> compilePowerTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        final PowerFunction powerFunction = power.getConsequent();
        boolean _matched = false;
        if (powerFunction instanceof PFObligationSuspended) {
          _matched=true;
          methods.add(
            this.generatePowerTransactionForObligation(power.getName(), ((PFObligationSuspended)powerFunction).getNorm().getName(), "suspended"));
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationResumed) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationResumed)powerFunction).getNorm().getName(), "resumed"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationDischarged) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationDischarged)powerFunction).getNorm().getName(), "discharged"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationTerminated) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationTerminated)powerFunction).getNorm().getName(), "terminated"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationTriggered) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationTriggered)powerFunction).getNorm().getName(), "triggered"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractSuspended) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "suspended"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractResumed) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "resumed"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractTerminated) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "terminated"));
          }
        }
      }
    }
    return methods;
  }

  public String generatePowerTransactionForObligation(final String powerName, final String obligationName, final String stateMethod) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async p_");
    _builder.append(powerName);
    _builder.append("_");
    _builder.append(stateMethod);
    _builder.append("_o_");
    _builder.append(obligationName);
    _builder.append("(ctx, contractId) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contract.isInEffect() && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(" != null && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(".isInEffect()) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = stateMethod.equals("triggered");
      if (_equals) {
        _builder.append("    ");
        _builder.append("if (contract.powers.");
        _builder.append(powerName, "    ");
        _builder.append(".exerted()) {");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("    ");
        _builder.append("const obligation = contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(obligationName);
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression, "    ");
        _builder.append(".");
        _builder.append(obligationName, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("if (obligation != null && obligation.");
        _builder.append(stateMethod, "    ");
        _builder.append("() && contract.powers.");
        _builder.append(powerName, "    ");
        _builder.append(".exerted()) {");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("      ");
    _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: true}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }

  public String generatePowerTransactionForContract(final String powerName, final String stateMethod) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async p_");
    _builder.append(powerName);
    _builder.append("_");
    _builder.append(stateMethod);
    _builder.append("_contract(ctx, contractId) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contract.isInEffect() && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(" != null && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(".isInEffect()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("for (let index in contract.obligations) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const obligation = contract.obligations[index]");
    _builder.newLine();
    {
      boolean _equals = stateMethod.equals("suspended");
      if (_equals) {
        _builder.append("      ");
        _builder.append("obligation._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("obligation.suspended()");
        _builder.newLine();
      } else {
        boolean _equals_1 = stateMethod.equals("resumed");
        if (_equals_1) {
          _builder.append("      ");
          _builder.append("if (obligation._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("obligation.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_2 = stateMethod.equals("terminated");
          if (_equals_2) {
            _builder.append("      ");
            _builder.append("obligation.terminated({emitEvent: false})");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.survivingObligations) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const obligation = contract.survivingObligations[index]");
    _builder.newLine();
    {
      boolean _equals_3 = stateMethod.equals("suspended");
      if (_equals_3) {
        _builder.append("      ");
        _builder.append("obligation._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("obligation.suspended()");
        _builder.newLine();
      } else {
        boolean _equals_4 = stateMethod.equals("resumed");
        if (_equals_4) {
          _builder.append("      ");
          _builder.append("if (obligation._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("obligation.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_5 = stateMethod.equals("terminated");
          if (_equals_5) {
            _builder.append("      ");
            _builder.append("obligation.terminated()");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.powers) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const power = contract.powers[index]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (index === \'");
    _builder.append(powerName, "      ");
    _builder.append("\') {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _equals_6 = stateMethod.equals("suspended");
      if (_equals_6) {
        _builder.append("      ");
        _builder.append("power._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("power.suspended()");
        _builder.newLine();
      } else {
        boolean _equals_7 = stateMethod.equals("resumed");
        if (_equals_7) {
          _builder.append("      ");
          _builder.append("if (power._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("power.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_8 = stateMethod.equals("terminated");
          if (_equals_8) {
            _builder.append("      ");
            _builder.append("power.terminated()");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (contract.");
    _builder.append(stateMethod, "    ");
    _builder.append("() && contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(".exerted()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: true}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }

  public List<String> compileEventTriggerMethods(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Variable variable : this.eventVariables) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async trigger_");
      String _name = variable.getName();
      _builder.append(_name);
      _builder.append("(ctx, args) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("const inputs = JSON.parse(args);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("const contractId = inputs.contractId;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("const event = inputs.event;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect() ");
      String _survivEvent = this.survivEvent(variable.getName());
      _builder.append(_survivEvent, "  ");
      _builder.append(" ){");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("contract.");
      String _name_1 = variable.getName();
      _builder.append(_name_1, "    ");
      _builder.append(".happen(event)");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("Events.emitEvent(contract, new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, contract.");
      String _name_2 = variable.getName();
      _builder.append(_name_2, "    ");
      _builder.append("))");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    return methods;
  }

  public String compileInitMethod(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async init(ctx, args) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const inputs = JSON.parse(args);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contractInstance = new ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "  ");
    _builder.append(" (");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      String _name = p.getName();
      return ("inputs." + _name);
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ", ");
    _builder.append(_join, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("this.initialize(contractInstance)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractInstance.activated()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// call trigger transitions for legal positions");
    _builder.newLine();
    {
      for(final Obligation obligation : this.triggeredObligations) {
        {
          Proposition _antecedent = obligation.getAntecedent();
          if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.obligations.");
            String _name = obligation.getName();
            _builder.append(_name, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.obligations.");
            String _name_1 = obligation.getName();
            _builder.append(_name_1, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Obligation obligation_1 : this.triggeredSurvivingObligations) {
        {
          Proposition _antecedent_1 = obligation_1.getAntecedent();
          if ((_antecedent_1 instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.survivingObligations.");
            String _name_2 = obligation_1.getName();
            _builder.append(_name_2, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.survivingObligations.");
            String _name_3 = obligation_1.getName();
            _builder.append(_name_3, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Power power : this.triggeredPowers) {
        {
          Proposition _antecedent_2 = power.getAntecedent();
          if ((_antecedent_2 instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.powers.");
            String _name_4 = power.getName();
            _builder.append(_name_4, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.powers.");
            String _name_5 = power.getName();
            _builder.append(_name_5, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("await ctx.stub.putState(contractInstance.id, Buffer.from(serialize(contractInstance)))");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: true, contractId: contractInstance.id}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    return code;
  }

  public void compileContract(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final RegularType asset : this.assets) {
        _builder.append("const { ");
        String _name = asset.getName();
        _builder.append(_name);
        _builder.append(" } = require(\"../assets/");
        String _name_1 = asset.getName();
        _builder.append(_name_1);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final RegularType event : this.events) {
        _builder.append("const { ");
        String _name_2 = event.getName();
        _builder.append(_name_2);
        _builder.append(" } = require(\"../events/");
        String _name_3 = event.getName();
        _builder.append(_name_3);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final RegularType role : this.roles) {
        _builder.append("const { ");
        String _name_4 = role.getName();
        _builder.append(_name_4);
        _builder.append(" } = require(\"../roles/");
        String _name_5 = role.getName();
        _builder.append(_name_5);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Enumeration enumeration : this.enumerations) {
        _builder.append("const { ");
        String _name_6 = enumeration.getName();
        _builder.append(_name_6);
        _builder.append(" } = require(\"../types/");
        String _name_7 = enumeration.getName();
        _builder.append(_name_7);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("const { SymboleoContract } = require(");
    _builder.append(this.CONTRACT_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Obligation } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Utils } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Str } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _contractName = model.getContractName();
    _builder.append(_contractName);
    _builder.append(" extends SymboleoContract {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("constructor(");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      return p.getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ", ");
    _builder.append(_join, "  ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("super(\"");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1, "    ");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("this._name = \"");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "    ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Parameter> _parameters = model.getParameters();
      for(final Parameter parameter : _parameters) {
        _builder.append("    ");
        _builder.append("this.");
        String _name_8 = parameter.getName();
        _builder.append(_name_8, "    ");
        _builder.append(" = ");
        String _name_9 = parameter.getName();
        _builder.append(_name_9, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.obligations = {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.survivingObligations = {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.powers = {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// assign varaibles of the contract");
    _builder.newLine();
    {
      EList<Variable> _variables = model.getVariables();
      for(final Variable variable : _variables) {
        {
          RegularType _type = variable.getType();
          if ((_type instanceof RegularType)) {
            _builder.append("    ");
            _builder.append("this.");
            String _name_10 = variable.getName();
            _builder.append(_name_10, "    ");
            _builder.append(" = new ");
            String _name_11 = variable.getType().getName();
            _builder.append(_name_11, "    ");
            _builder.append("(\"");
            String _name_12 = variable.getName();
            _builder.append(_name_12, "    ");
            _builder.append("\")");
            _builder.newLineIfNotEmpty();
            {
              EList<Assignment> _attributes = variable.getAttributes();
              for(final Assignment assignment : _attributes) {
                {
                  if ((assignment instanceof AssignExpression)) {
                    _builder.append("    ");
                    _builder.append("this.");
                    String _name_13 = variable.getName();
                    _builder.append(_name_13, "    ");
                    _builder.append(".");
                    String _name_14 = ((AssignExpression)assignment).getName();
                    _builder.append(_name_14, "    ");
                    _builder.append(" = ");
                    String _generateExpressionString = this.generateExpressionString(((AssignExpression)assignment).getValue(), "this");
                    _builder.append(_generateExpressionString, "    ");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// create instance of triggered obligations");
    _builder.newLine();
    {
      for(final Obligation obligation : this.triggeredObligations) {
        _builder.append("    ");
        _builder.append("this.obligations.");
        String _name_15 = obligation.getName();
        _builder.append(_name_15, "    ");
        _builder.append(" = new Obligation(\'");
        String _name_16 = obligation.getName();
        _builder.append(_name_16, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString = this.generateDotExpressionString(obligation.getCreditor(), "this");
        _builder.append(_generateDotExpressionString, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = this.generateDotExpressionString(obligation.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_1, "    ");
        _builder.append(", this)");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Obligation obligation_1 : this.triggeredSurvivingObligations) {
        _builder.append("    ");
        _builder.append("this.survivingObligations.");
        String _name_17 = obligation_1.getName();
        _builder.append(_name_17, "    ");
        _builder.append(" = new Obligation(\'");
        String _name_18 = obligation_1.getName();
        _builder.append(_name_18, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = this.generateDotExpressionString(obligation_1.getCreditor(), "this");
        _builder.append(_generateDotExpressionString_2, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = this.generateDotExpressionString(obligation_1.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_3, "    ");
        _builder.append(", this, true)");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Power power : this.triggeredPowers) {
        _builder.append("    ");
        _builder.append("this.powers.");
        String _name_19 = power.getName();
        _builder.append(_name_19, "    ");
        _builder.append(" = new Power(\'");
        String _name_20 = power.getName();
        _builder.append(_name_20, "    ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = this.generateDotExpressionString(power.getCreditor(), "this");
        _builder.append(_generateDotExpressionString_4, "    ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = this.generateDotExpressionString(power.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_5, "    ");
        _builder.append(", this)");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("module.exports.");
    String _contractName_3 = model.getContractName();
    _builder.append(_contractName_3);
    _builder.append(" = ");
    String _contractName_4 = model.getContractName();
    _builder.append(_contractName_4);
    _builder.newLineIfNotEmpty();
    final String code = _builder.toString();
    String _contractName_5 = model.getContractName();
    String _plus = ("./" + _contractName_5);
    String _plus_1 = (_plus + "/domain/contract/");
    String _contractName_6 = model.getContractName();
    String _plus_2 = (_plus_1 + _contractName_6);
    String _plus_3 = (_plus_2 + ".js");
    fsa.generateFile(_plus_3, code);
  }

  public String generateExpressionString(final Expression argExpression, final String thisString) {
    boolean _matched = false;
    if (argExpression instanceof Or) {
      _matched=true;
      String _generateExpressionString = this.generateExpressionString(((Or)argExpression).getLeft(), thisString);
      String _plus = (_generateExpressionString + " || ");
      String _generateExpressionString_1 = this.generateExpressionString(((Or)argExpression).getRight(), thisString);
      return (_plus + _generateExpressionString_1);
    }
    if (!_matched) {
      if (argExpression instanceof And) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((And)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " && ");
        String _generateExpressionString_1 = this.generateExpressionString(((And)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Equality) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Equality)argExpression).getLeft(), thisString);
        String _equalityOperator = this.getEqualityOperator(((Equality)argExpression).getOp());
        String _plus = (_generateExpressionString + _equalityOperator);
        String _generateExpressionString_1 = this.generateExpressionString(((Equality)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Comparison) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Comparison)argExpression).getLeft(), thisString);
        String _op = ((Comparison)argExpression).getOp();
        String _plus = (_generateExpressionString + _op);
        String _generateExpressionString_1 = this.generateExpressionString(((Comparison)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Plus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Plus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " + ");
        String _generateExpressionString_1 = this.generateExpressionString(((Plus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Minus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Minus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " - ");
        String _generateExpressionString_1 = this.generateExpressionString(((Minus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Multi) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Multi)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " * ");
        String _generateExpressionString_1 = this.generateExpressionString(((Multi)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Div) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Div)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " / ");
        String _generateExpressionString_1 = this.generateExpressionString(((Div)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionRecursive) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((PrimaryExpressionRecursive)argExpression).getInner(), thisString);
        String _plus = ("(" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionFunctionCall) {
        _matched=true;
        return this.generateFunctionCall(((PrimaryExpressionFunctionCall)argExpression), thisString);
      }
    }
    if (!_matched) {
      if (argExpression instanceof NegatedPrimaryExpression) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((NegatedPrimaryExpression)argExpression).getExpression(), thisString);
        String _plus = ("!(" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionTrue) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionFalse) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDouble) {
        _matched=true;
        return Double.valueOf(((AtomicExpressionDouble)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionInt) {
        _matched=true;
        return Integer.valueOf(((AtomicExpressionInt)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDate) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(new Date(\"");
        String _string = ((AtomicExpressionDate)argExpression).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\").toISOString())");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionEnum) {
        _matched=true;
        Enumeration _enumeration = ((AtomicExpressionEnum)argExpression).getEnumeration();
        String _plus = (_enumeration + ".");
        EnumItem _enumItem = ((AtomicExpressionEnum)argExpression).getEnumItem();
        return (_plus + _enumItem);
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionString) {
        _matched=true;
        String _value = ((AtomicExpressionString)argExpression).getValue();
        String _plus = ("\"" + _value);
        return (_plus + "\"");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionParameter) {
        _matched=true;
        return this.generateDotExpressionString(((AtomicExpressionParameter)argExpression).getValue(), thisString);
      }
    }
    return null;
  }

  public String generateDotExpressionString(final Ref argRef, final String thisString) {
    final ArrayList<String> ids = new ArrayList<String>();
    Ref ref = argRef;
    while ((ref instanceof VariableDotExpression)) {
      {
        ids.add(((VariableDotExpression)ref).getTail().getName());
        ref = ((VariableDotExpression)ref).getRef();
      }
    }
    if ((ref instanceof VariableRef)) {
      ids.add(((VariableRef) ref).getVariable());
    }
    if ((!(thisString == ""))) {
      ids.add(thisString);
    }
    return IterableExtensions.join(ListExtensions.<String>reverse(ids), ".");
  }

  public String generateFunctionCall(final PrimaryExpressionFunctionCall argFunctionCallExp, final String thisString) {
    final FunctionCall functionCall = argFunctionCallExp.getFunction();
    boolean _matched = false;
    if (functionCall instanceof TwoArgMathFunction) {
      _matched=true;
      String _name = ((TwoArgMathFunction)functionCall).getName();
      String _plus = (_name + "(");
      String _generateExpressionString = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg1(), thisString);
      String _plus_1 = (_plus + _generateExpressionString);
      String _plus_2 = (_plus_1 + ",");
      String _generateExpressionString_1 = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg2(), thisString);
      String _plus_3 = (_plus_2 + _generateExpressionString_1);
      return (_plus_3 + ")");
    }
    if (!_matched) {
      if (functionCall instanceof OneArgMathFunction) {
        _matched=true;
        String _name = ((OneArgMathFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgMathFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgStringFunction) {
        _matched=true;
        String _replace = ((ThreeArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        String _plus_4 = (_plus_3 + ",");
        String _generateExpressionString_2 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg3(), thisString);
        String _plus_5 = (_plus_4 + _generateExpressionString_2);
        return (_plus_5 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof TwoArgStringFunction) {
        _matched=true;
        String _replace = ((TwoArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        return (_plus_3 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof OneArgStringFunction) {
        _matched=true;
        String _replace = ((OneArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgDateFunction) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Utils.addTime(");
        String _generateExpressionString = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getArg1(), thisString);
        _builder.append(_generateExpressionString);
        _builder.append(", ");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getValue(), thisString);
        _builder.append(_generateExpressionString_1);
        _builder.append(", \"");
        String _timeUnit = ((ThreeArgDateFunction)functionCall).getTimeUnit();
        _builder.append(_timeUnit);
        _builder.append("\")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String getEqualityOperator(final String op) {
    if (op != null) {
      switch (op) {
        case "!=":
          return " !== ";
        case "==":
          return " === ";
      }
    }
    return null;
  }

  public void compileDomainTypes(final IFileSystemAccess2 fsa, final Model model) {
    for (final RegularType asset : this.assets) {
      this.generateAsset(fsa, model, asset);
    }
    for (final RegularType event : this.events) {
      this.generateEvent(fsa, model, event);
    }
    for (final RegularType role : this.roles) {
      this.generateRole(fsa, model, role);
    }
    for (final Enumeration enumeration : this.enumerations) {
      this.generateEnumeration(fsa, model, enumeration);
    }
  }

  public void generateEnumeration(final IFileSystemAccess2 fsa, final Model model, final Enumeration enumeration) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module.exports.");
    String _name = enumeration.getName();
    _builder.append(_name);
    _builder.append(" = {");
    _builder.newLineIfNotEmpty();
    {
      EList<EnumItem> _enumerationItems = enumeration.getEnumerationItems();
      for(final EnumItem item : _enumerationItems) {
        _builder.append("  ");
        String _name_1 = item.getName();
        _builder.append(_name_1, "  ");
        _builder.append(": ");
        int _indexOf = enumeration.getEnumerationItems().indexOf(item);
        _builder.append(_indexOf, "  ");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName = model.getContractName();
    String _plus = ("./" + _contractName);
    String _plus_1 = (_plus + "/domain/types/");
    String _name_2 = enumeration.getName();
    String _plus_2 = (_plus_1 + _name_2);
    String _plus_3 = (_plus_2 + ".js");
    fsa.generateFile(_plus_3, code);
  }

  public void generateAsset(final IFileSystemAccess2 fsa, final Model model, final RegularType asset) {
    OntologyType _ontologyType = asset.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { Asset } = require(");
      _builder.append(this.ASSET_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name = asset.getName();
      _builder.append(_name);
      _builder.append(" extends Asset {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("constructor(_name,");
      final Function1<Attribute, String> _function = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(asset.getAttributes(), _function), ", ");
      _builder.append(_join, "  ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      {
        EList<Attribute> _attributes = asset.getAttributes();
        for(final Attribute attribute : _attributes) {
          _builder.append("    ");
          _builder.append("this.");
          String _name_1 = attribute.getName();
          _builder.append(_name_1, "    ");
          _builder.append(" = ");
          String _name_2 = attribute.getName();
          _builder.append(_name_2, "    ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_3 = asset.getName();
      _builder.append(_name_3);
      _builder.append(" = ");
      String _name_4 = asset.getName();
      _builder.append(_name_4);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/assets/");
      String _name_5 = asset.getName();
      String _plus_2 = (_plus_1 + _name_5);
      String _plus_3 = (_plus_2 + ".js");
      fsa.generateFile(_plus_3, code);
    } else {
      RegularType _regularType = asset.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = asset.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(asset);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(asset.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_6 = parentType.getName();
        _builder_1.append(_name_6);
        _builder_1.append(" } = require(\"./");
        String _name_7 = parentType.getName();
        _builder_1.append(_name_7);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_8 = asset.getName();
        _builder_1.append(_name_8);
        _builder_1.append(" extends ");
        String _name_9 = parentType.getName();
        _builder_1.append(_name_9);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_1 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_1), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_2), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = asset.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            _builder_1.append("    ");
            _builder_1.append("this.");
            String _name_10 = attribute_1.getName();
            _builder_1.append(_name_10, "    ");
            _builder_1.append(" = ");
            String _name_11 = attribute_1.getName();
            _builder_1.append(_name_11, "    ");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_12 = asset.getName();
        _builder_1.append(_name_12);
        _builder_1.append(" = ");
        String _name_13 = asset.getName();
        _builder_1.append(_name_13);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_4 = ("./" + _contractName_1);
        String _plus_5 = (_plus_4 + "/domain/assets/");
        String _name_14 = asset.getName();
        String _plus_6 = (_plus_5 + _name_14);
        String _plus_7 = (_plus_6 + ".js");
        fsa.generateFile(_plus_7, code_1);
      }
    }
  }

  public void generateEvent(final IFileSystemAccess2 fsa, final Model model, final RegularType event) {
    OntologyType _ontologyType = event.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { Event } = require(");
      _builder.append(this.EVENT_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name = event.getName();
      _builder.append(_name);
      _builder.append(" extends Event {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("constructor(_name,");
      final Function1<Attribute, String> _function = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(event.getAttributes(), _function), ", ");
      _builder.append(_join, "  ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      {
        EList<Attribute> _attributes = event.getAttributes();
        for(final Attribute attribute : _attributes) {
          _builder.append("    ");
          _builder.append("this.");
          String _name_1 = attribute.getName();
          _builder.append(_name_1, "    ");
          _builder.append(" = ");
          String _name_2 = attribute.getName();
          _builder.append(_name_2, "    ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_3 = event.getName();
      _builder.append(_name_3);
      _builder.append(" = ");
      String _name_4 = event.getName();
      _builder.append(_name_4);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/events/");
      String _name_5 = event.getName();
      String _plus_2 = (_plus_1 + _name_5);
      String _plus_3 = (_plus_2 + ".js");
      fsa.generateFile(_plus_3, code);
    } else {
      RegularType _regularType = event.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = event.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(event);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(event.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_6 = parentType.getName();
        _builder_1.append(_name_6);
        _builder_1.append(" } = require(\"./");
        String _name_7 = parentType.getName();
        _builder_1.append(_name_7);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_8 = event.getName();
        _builder_1.append(_name_8);
        _builder_1.append(" extends ");
        String _name_9 = parentType.getName();
        _builder_1.append(_name_9);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_1 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_1), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_2), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = event.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            _builder_1.append("    ");
            _builder_1.append("this.");
            String _name_10 = attribute_1.getName();
            _builder_1.append(_name_10, "    ");
            _builder_1.append(" = ");
            String _name_11 = attribute_1.getName();
            _builder_1.append(_name_11, "    ");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_12 = event.getName();
        _builder_1.append(_name_12);
        _builder_1.append(" = ");
        String _name_13 = event.getName();
        _builder_1.append(_name_13);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_4 = ("./" + _contractName_1);
        String _plus_5 = (_plus_4 + "/domain/events/");
        String _name_14 = event.getName();
        String _plus_6 = (_plus_5 + _name_14);
        String _plus_7 = (_plus_6 + ".js");
        fsa.generateFile(_plus_7, code_1);
      }
    }
  }

  public void generateRole(final IFileSystemAccess2 fsa, final Model model, final RegularType role) {
    OntologyType _ontologyType = role.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { Role } = require(");
      _builder.append(this.ROLE_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name = role.getName();
      _builder.append(_name);
      _builder.append(" extends Role {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("constructor(_name,");
      final Function1<Attribute, String> _function = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(role.getAttributes(), _function), ", ");
      _builder.append(_join, "  ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      {
        EList<Attribute> _attributes = role.getAttributes();
        for(final Attribute attribute : _attributes) {
          _builder.append("    ");
          _builder.append("this.");
          String _name_1 = attribute.getName();
          _builder.append(_name_1, "    ");
          _builder.append(" = ");
          String _name_2 = attribute.getName();
          _builder.append(_name_2, "    ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_3 = role.getName();
      _builder.append(_name_3);
      _builder.append(" = ");
      String _name_4 = role.getName();
      _builder.append(_name_4);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/roles/");
      String _name_5 = role.getName();
      String _plus_2 = (_plus_1 + _name_5);
      String _plus_3 = (_plus_2 + ".js");
      fsa.generateFile(_plus_3, code);
    } else {
      RegularType _regularType = role.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = role.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(role);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(role.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_6 = parentType.getName();
        _builder_1.append(_name_6);
        _builder_1.append(" } = require(\"./");
        String _name_7 = parentType.getName();
        _builder_1.append(_name_7);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_8 = role.getName();
        _builder_1.append(_name_8);
        _builder_1.append(" extends ");
        String _name_9 = parentType.getName();
        _builder_1.append(_name_9);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_1 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_1), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_2), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = role.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            _builder_1.append("    ");
            _builder_1.append("this.");
            String _name_10 = attribute_1.getName();
            _builder_1.append(_name_10, "    ");
            _builder_1.append(" = ");
            String _name_11 = attribute_1.getName();
            _builder_1.append(_name_11, "    ");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_12 = role.getName();
        _builder_1.append(_name_12);
        _builder_1.append(" = ");
        String _name_13 = role.getName();
        _builder_1.append(_name_13);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_4 = ("./" + _contractName_1);
        String _plus_5 = (_plus_4 + "/domain/roles/");
        String _name_14 = role.getName();
        String _plus_6 = (_plus_5 + _name_14);
        String _plus_7 = (_plus_6 + ".js");
        fsa.generateFile(_plus_7, code_1);
      }
    }
  }

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Model> _filter = Iterables.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class);
    for (final Model e : _filter) {
      {
        this.assets.clear();
        this.events.clear();
        this.roles.clear();
        this.enumerations.clear();
        this.parameters.clear();
        this.arrays.clear();
        this.conditionalObligations.clear();
        this.conditionalSurvivingObligations.clear();
        this.conditionalPowers.clear();
        this.unconditionalObligations.clear();
        this.unconditionalSurvivingObligations.clear();
        this.unconditionalPowers.clear();
        this.untriggeredObligations.clear();
        this.untriggeredSurvivingObligations.clear();
        this.untriggeredPowers.clear();
        this.triggeredObligations.clear();
        this.triggeredSurvivingObligations.clear();
        this.triggeredPowers.clear();
        this.allObligations.clear();
        this.allSurvivingObligations.clear();
        this.allPowers.clear();
        this.eventVariables.clear();
        this.AssignVar.clear();
        this.obligationTriggerEvents.clear();
        this.survivingObligationTriggerEvents.clear();
        this.powerTriggerEvents.clear();
        this.obligationAntecedentEvents.clear();
        this.survivingObligationAntecedentEvents.clear();
        this.powerAntecedentEvents.clear();
        this.obligationFullfilmentEvents.clear();
        this.survivingObligationFullfilmentEvents.clear();
        String _contractName = e.getContractName();
        String _plus = ("generateHFSource: " + _contractName);
        System.out.println(_plus);
        this.generateHFSource(fsa, e);
      }
    }
  }

  @Override
  public void afterGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.assets.clear();
    this.events.clear();
    this.roles.clear();
    this.enumerations.clear();
    this.parameters.clear();
    this.AssignVar.clear();
    this.conditionalObligations.clear();
    this.conditionalSurvivingObligations.clear();
    this.conditionalPowers.clear();
    this.unconditionalObligations.clear();
    this.unconditionalSurvivingObligations.clear();
    this.unconditionalPowers.clear();
    this.untriggeredObligations.clear();
    this.untriggeredSurvivingObligations.clear();
    this.untriggeredPowers.clear();
    this.triggeredObligations.clear();
    this.triggeredSurvivingObligations.clear();
    this.triggeredPowers.clear();
    this.allObligations.clear();
    this.allSurvivingObligations.clear();
    this.allPowers.clear();
    this.eventVariables.clear();
    this.obligationTriggerEvents.clear();
    this.survivingObligationTriggerEvents.clear();
    this.powerTriggerEvents.clear();
    this.obligationAntecedentEvents.clear();
    this.survivingObligationAntecedentEvents.clear();
    this.powerAntecedentEvents.clear();
    this.obligationFullfilmentEvents.clear();
    this.survivingObligationFullfilmentEvents.clear();
  }

  public String OpString(final String op) {
    if (op != null) {
      switch (op) {
        case ":=":
          return " = ";
        case "+:=":
          return " += ";
        case "-:=":
          return " -= ";
        case "*:=":
          return " *= ";
        case "/:=":
          return " /= ";
      }
    }
    return null;
  }

  public String survivEvent(final String e) {
    boolean survive = false;
    boolean related = false;
    for (final String line : this.arrays) {
      {
        if ((line.contains(("contract." + e)) && ((line.contains("EventListeners.fulfillSurvivingObligation") || 
          line.contains("EventListeners.createSurvivingObligation")) || 
          line.contains("EventListeners.activateSurvivingObligation")))) {
          survive = true;
        }
        if ((line.contains(("contract." + e)) && (((((line.contains("EventListeners.fulfillObligation") || 
          line.contains("EventListeners.createObligation")) || 
          line.contains("EventListeners.activateObligation")) || 
          line.contains("EventListeners.createPower")) || 
          line.contains("EventListeners.activatePower")) || 
          line.contains("EventListeners.fulfillPower")))) {
          related = true;
        }
      }
    }
    if ((survive && (!related))) {
      return " || contract.isSuccessfulTermination() || contract.isUnsuccessfulTermination()";
    } else {
      return "";
    }
  }
}
