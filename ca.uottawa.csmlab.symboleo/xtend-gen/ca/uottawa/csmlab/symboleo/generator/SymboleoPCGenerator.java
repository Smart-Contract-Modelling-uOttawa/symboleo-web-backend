package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.generator.Tpoint;
import ca.uottawa.csmlab.symboleo.symboleo.And;
import ca.uottawa.csmlab.symboleo.symboleo.AssignExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Assignment;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDouble;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionEnum;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionFalse;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionInt;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionString;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionTrue;
import ca.uottawa.csmlab.symboleo.symboleo.Attribute;
import ca.uottawa.csmlab.symboleo.symboleo.BaseType;
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
import ca.uottawa.csmlab.symboleo.symboleo.Interval;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalExpression;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Minus;
import ca.uottawa.csmlab.symboleo.symboleo.Model;
import ca.uottawa.csmlab.symboleo.symboleo.Multi;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPrimaryExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Obligation;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationState;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OntologyType;
import ca.uottawa.csmlab.symboleo.symboleo.Or;
import ca.uottawa.csmlab.symboleo.symboleo.PAnd;
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
import ca.uottawa.csmlab.symboleo.symboleo.POr;
import ca.uottawa.csmlab.symboleo.symboleo.Parameter;
import ca.uottawa.csmlab.symboleo.symboleo.ParameterType;
import ca.uottawa.csmlab.symboleo.symboleo.Plus;
import ca.uottawa.csmlab.symboleo.symboleo.Point;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomContractEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomParameterDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomPowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Power;
import ca.uottawa.csmlab.symboleo.symboleo.PowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PowerFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PowerState;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionCannotBeAssigned;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappens;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensAfter;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensWithin;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionIsEqual;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionIsOwner;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionWHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionWHappensBeforeEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionFunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.Proposition;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.RegularType;
import ca.uottawa.csmlab.symboleo.symboleo.Situation;
import ca.uottawa.csmlab.symboleo.symboleo.SituationExpression;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Variable;
import ca.uottawa.csmlab.symboleo.symboleo.VariableDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.VariableEvent;
import ca.uottawa.csmlab.symboleo.symboleo.VariableRef;
import ca.uottawa.csmlab.symboleo.symboleo.impl.RegularTypeImpl;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class SymboleoPCGenerator {
  public enum propositionType {
    TRIGGER,

    ANTECEDENT,

    CONSEQUENT;
  }

  public enum normType {
    OBLIGATION,

    POWER;
  }

  private final ArrayList<RegularType> assets = new ArrayList<RegularType>();

  private final ArrayList<RegularType> events = new ArrayList<RegularType>();

  private final ArrayList<RegularType> roles = new ArrayList<RegularType>();

  private final HashMap<String, Pair<String, String>> roleInstances = new HashMap<String, Pair<String, String>>();

  private final ArrayList<Enumeration> enumerations = new ArrayList<Enumeration>();

  private final ArrayList<Parameter> parameters = new ArrayList<Parameter>();

  private final ArrayList<Obligation> obligations = new ArrayList<Obligation>();

  private final ArrayList<Power> powers = new ArrayList<Power>();

  private final ArrayList<Proposition> constraints = new ArrayList<Proposition>();

  private final ArrayList<SymboleoPredicate> predicates = new ArrayList<SymboleoPredicate>();

  private final ArrayList<Variable> eventVariables = new ArrayList<Variable>();

  private final ArrayList<Variable> roleVariables = new ArrayList<Variable>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerTriggerEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationConsequentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerAntecedentEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final ArrayList<List<PAtomPredicate>> constraintEvents = new ArrayList<List<PAtomPredicate>>();

  private final ArrayList<String> pcSurvivingObligations = new ArrayList<String>();

  private final ArrayList<DeclarationVariable> pcVariables = new ArrayList<DeclarationVariable>();

  private final ArrayList<String> pcSituations = new ArrayList<String>();

  private final ArrayList<String> pcRoles = new ArrayList<String>();

  private final ArrayList<String> pcAssets = new ArrayList<String>();

  private final ArrayList<String> pcDomEvents = new ArrayList<String>();

  private final ArrayList<String> pcEnumerations = new ArrayList<String>();

  private final ArrayList<String> pcParameters = new ArrayList<String>();

  private final ArrayList<String> pcConstraints = new ArrayList<String>();

  private final ArrayList<String> pcAssignProhibitedNorms = new ArrayList<String>();

  public void parse(final Model model) {
    this.parameters.addAll(model.getParameters());
    EList<DomainType> _domainTypes = model.getDomainTypes();
    for (final DomainType domainType : _domainTypes) {
      if ((domainType instanceof RegularType)) {
        RegularType base = this.getBaseType(domainType);
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
    for (final Parameter param : this.parameters) {
      DomainType _domainType = param.getType().getDomainType();
      if ((_domainType instanceof RegularTypeImpl)) {
        DomainType domainType_1 = param.getType().getDomainType();
        RegularType base_1 = this.getBaseType(domainType_1);
        if ((base_1 != null)) {
          String _name_1 = base_1.getOntologyType().getName();
          boolean _equals = Objects.equal(_name_1, "Role");
          if (_equals) {
          } else {
            this.pcParameters.add(param.getName());
          }
        }
      } else {
        this.pcParameters.add(param.getName());
      }
    }
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        this.obligations.add(obligation);
        final Proposition proposition = obligation.getAntecedent();
        this.obligationAntecedentEvents.put(obligation, this.collectPropositionEvents(proposition));
        final Proposition proposition2 = obligation.getConsequent();
        this.obligationConsequentEvents.put(obligation, this.collectPropositionEvents(proposition2));
        Proposition _trigger = obligation.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          final Proposition proposition3 = obligation.getTrigger();
          this.obligationTriggerEvents.put(obligation, this.collectPropositionEvents(proposition3));
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        this.obligations.add(obligation_1);
        final Proposition proposition = obligation_1.getAntecedent();
        this.obligationAntecedentEvents.put(obligation_1, this.collectPropositionEvents(proposition));
        final Proposition proposition2 = obligation_1.getConsequent();
        this.obligationConsequentEvents.put(obligation_1, this.collectPropositionEvents(proposition2));
        Proposition _trigger = obligation_1.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          final Proposition proposition3 = obligation_1.getTrigger();
          this.obligationTriggerEvents.put(obligation_1, this.collectPropositionEvents(proposition3));
        }
        this.pcSurvivingObligations.add(obligation_1.getName());
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        this.powers.add(power);
        final Proposition proposition = power.getAntecedent();
        this.powerAntecedentEvents.put(power, this.collectPropositionEvents(proposition));
        Proposition _trigger = power.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          final Proposition proposition2 = power.getTrigger();
          this.powerTriggerEvents.put(power, this.collectPropositionEvents(proposition2));
        }
      }
    }
    EList<Variable> _variables = model.getVariables();
    for (final Variable variable : _variables) {
      {
        int _indexOf = this.events.indexOf(variable.getType());
        boolean _notEquals = (_indexOf != (-1));
        if (_notEquals) {
          this.eventVariables.add(variable);
        }
        int _indexOf_1 = this.roles.indexOf(variable.getType());
        boolean _notEquals_1 = (_indexOf_1 != (-1));
        if (_notEquals_1) {
          this.roleVariables.add(variable);
        }
      }
    }
    EList<Proposition> _constraints = model.getConstraints();
    for (final Proposition constr : _constraints) {
      {
        this.constraintEvents.add(this.collectPropositionEvents(constr));
        this.constraints.add(constr);
      }
    }
    this.generateHappenVariables();
  }

  public RegularType getBaseType(final DomainType domainType) {
    Object _switchResult = null;
    boolean _matched = false;
    if (domainType instanceof RegularType) {
      _matched=true;
      OntologyType _ontologyType = ((RegularType)domainType).getOntologyType();
      boolean _tripleNotEquals = (_ontologyType != null);
      if (_tripleNotEquals) {
        return ((RegularType)domainType);
      } else {
        return this.getBaseType(((RegularType)domainType).getRegularType());
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return ((RegularType)_switchResult);
  }

  public String getEvent(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
      _builder.append(_extractEventVariableString);
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionWHappensBefore)predicate).getEvent());
        _builder.append(_extractEventVariableString);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionSHappensBefore)predicate).getEvent());
        _builder.append(_extractEventVariableString);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionHappensAfter)predicate).getEvent());
        _builder.append(_extractEventVariableString);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
        _builder.append(_extractEventVariableString);
        return _builder.toString();
      }
    }
    return null;
  }

  public String getSituations() {
    String situations = "";
    for (final String situation : this.pcSituations) {
      String _situations = situations;
      situations = (_situations + (situation + "\n\n"));
    }
    return situations;
  }

  public static String eventToSituation(final String event) {
    if (event != null) {
      switch (event) {
        case "violated":
          return "violation";
        case "suspended":
          return "suspension";
        case "resumed":
          return "resumption";
        case "discharged":
          return "dischargment";
        case "expired":
          return "expirtion";
        case "fulfilled":
          return "fulfillment";
        case "terminated":
          return "termination";
        case "revokedParty":
          return "unassign";
      }
    }
    return null;
  }

  public String generateEventVariableString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      return SymboleoPCGenerator.generateDotExpressionString(((VariableEvent)event).getVariable(), null);
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(".state=");
        String _eventToSituation = SymboleoPCGenerator.eventToSituation(((PowerEvent)event).getEventName().toLowerCase());
        _builder.append(_eventToSituation);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(".state=");
        String _eventToSituation = SymboleoPCGenerator.eventToSituation(((ObligationEvent)event).getEventName().toLowerCase());
        _builder.append(_eventToSituation);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("cnt.state=");
        String _eventToSituation = SymboleoPCGenerator.eventToSituation(((ContractEvent)event).getEventName().toLowerCase());
        _builder.append(_eventToSituation);
        return _builder.toString();
      }
    }
    return null;
  }

  public boolean isDuplicate(final String event1, final String event2, final String happenClass) {
    for (final DeclarationVariable variable : this.pcVariables) {
      if (((variable.type.equals(happenClass) && variable.parameters.get(0).getValue().equals(event1)) && variable.parameters.get(1).getValue().equals(event2))) {
        return true;
      }
    }
    return false;
  }

  public void generateHappenVariables() {
    ArrayList<PredicateFunction> atoms = new ArrayList<PredicateFunction>();
    Collection<List<PAtomPredicate>> valueLists = this.powerAntecedentEvents.values();
    for (final List<PAtomPredicate> list : valueLists) {
      for (final PAtomPredicate v : list) {
        atoms.add(v.getPredicateFunction());
      }
    }
    valueLists = this.powerTriggerEvents.values();
    for (final List<PAtomPredicate> list_1 : valueLists) {
      for (final PAtomPredicate v_1 : list_1) {
        atoms.add(v_1.getPredicateFunction());
      }
    }
    valueLists = this.obligationAntecedentEvents.values();
    for (final List<PAtomPredicate> list_2 : valueLists) {
      for (final PAtomPredicate v_2 : list_2) {
        atoms.add(v_2.getPredicateFunction());
      }
    }
    valueLists = this.obligationConsequentEvents.values();
    for (final List<PAtomPredicate> list_3 : valueLists) {
      for (final PAtomPredicate v_3 : list_3) {
        atoms.add(v_3.getPredicateFunction());
      }
    }
    valueLists = this.obligationTriggerEvents.values();
    for (final List<PAtomPredicate> list_4 : valueLists) {
      for (final PAtomPredicate v_4 : list_4) {
        atoms.add(v_4.getPredicateFunction());
      }
    }
    for (final PredicateFunction it : atoms) {
      {
        if ((it instanceof PredicateFunctionWHappensBefore)) {
          final Point point = ((PredicateFunctionWHappensBefore)it).getPoint();
          final PointExpression pexp = point.getPointExpression();
          boolean _matched = false;
          if (pexp instanceof PointAtomParameterDotExpression) {
            _matched=true;
            String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
            final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
            String _generateDotExpressionString = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp).getVariable(), null);
            final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateDotExpressionString);
            boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBefore");
            boolean _not = (!_isDuplicate);
            if (_not) {
              ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
              pairs.add(pair1);
              pairs.add(pair2);
              String _value = pair1.getValue();
              String _plus = ("hbefore_" + _value);
              String _plus_1 = (_plus + "_");
              String _value_1 = pair2.getValue();
              String _plus_2 = (_plus_1 + _value_1);
              this.addVariable(_plus_2, null, "WhappensBefore", pairs);
            }
          }
          if (!_matched) {
            if (pexp instanceof PointAtomObligationEvent) {
              _matched=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomObligationEvent)pexp).getObligationEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBefore", pairs);
              }
            }
          }
          if (!_matched) {
            if (pexp instanceof PointAtomPowerEvent) {
              _matched=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomPowerEvent)pexp).getPowerEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBefore", pairs);
              }
              boolean _isDuplicate_1 = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBefore");
              boolean _not_1 = (!_isDuplicate_1);
              if (_not_1) {
                ArrayList<Pair<String, String>> pairs_1 = new ArrayList<Pair<String, String>>();
                pairs_1.add(pair1);
                pairs_1.add(pair2);
                String _value_2 = pair1.getValue();
                String _plus_3 = ("hbefore_" + _value_2);
                String _plus_4 = (_plus_3 + "_");
                String _value_3 = pair2.getValue();
                String _plus_5 = (_plus_4 + _value_3);
                this.addVariable(_plus_5, null, "WhappensBefore", pairs_1);
              }
            }
          }
          if (!_matched) {
            if (pexp instanceof PointAtomContractEvent) {
              _matched=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomContractEvent)pexp).getContractEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBefore", pairs);
              }
            }
          }
        }
        if ((it instanceof PredicateFunctionWHappensBeforeEvent)) {
          final Event event = ((PredicateFunctionWHappensBeforeEvent)it).getEvent2();
          boolean _matched_1 = false;
          if (event instanceof VariableEvent) {
            _matched_1=true;
            String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent1());
            final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
            String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent2());
            final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
            boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WHappensBeforeE");
            boolean _not = (!_isDuplicate);
            if (_not) {
              ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
              pairs.add(pair1);
              pairs.add(pair2);
              String _value = pair1.getValue();
              String _plus = ("hbeforeE_" + _value);
              String _plus_1 = (_plus + "_");
              String _value_1 = pair2.getValue();
              String _plus_2 = (_plus_1 + _value_1);
              this.addVariable(_plus_2, null, "WhappensBeforeE", pairs);
            }
          }
          if (!_matched_1) {
            if (event instanceof ObligationEvent) {
              _matched_1=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent1());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent2());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBeforeE");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbeforeE_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBeforeE", pairs);
              }
            }
          }
          if (!_matched_1) {
            if (event instanceof PowerEvent) {
              _matched_1=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent1());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent2());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBeforeE");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbeforeE_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBeforeE", pairs);
              }
              boolean _isDuplicate_1 = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBeforeE");
              boolean _not_1 = (!_isDuplicate_1);
              if (_not_1) {
                ArrayList<Pair<String, String>> pairs_1 = new ArrayList<Pair<String, String>>();
                pairs_1.add(pair1);
                pairs_1.add(pair2);
                String _value_2 = pair1.getValue();
                String _plus_3 = ("hbeforeE_" + _value_2);
                String _plus_4 = (_plus_3 + "_");
                String _value_3 = pair2.getValue();
                String _plus_5 = (_plus_4 + _value_3);
                this.addVariable(_plus_5, null, "WhappensBeforeE", pairs_1);
              }
            }
          }
          if (!_matched_1) {
            if (event instanceof ContractEvent) {
              _matched_1=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent1());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)it).getEvent2());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "WhappensBeforeE");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbeforeE_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "WhappensBeforeE", pairs);
              }
            }
          }
        }
        if ((it instanceof PredicateFunctionSHappensBefore)) {
          final Point point_1 = ((PredicateFunctionSHappensBefore)it).getPoint();
          final PointExpression pexp_1 = point_1.getPointExpression();
          boolean _matched_2 = false;
          if (pexp_1 instanceof PointAtomParameterDotExpression) {
            _matched_2=true;
            String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
            final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
            String _generateDotExpressionString = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp_1).getVariable(), null);
            final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateDotExpressionString);
            boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "ShappensBefore");
            boolean _not = (!_isDuplicate);
            if (_not) {
              ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
              pairs.add(pair1);
              pairs.add(pair2);
              String _value = pair1.getValue();
              String _plus = ("hbefore_" + _value);
              String _plus_1 = (_plus + "_");
              String _value_1 = pair2.getValue();
              String _plus_2 = (_plus_1 + _value_1);
              this.addVariable(_plus_2, null, "ShappensBefore", pairs);
            }
          }
          if (!_matched_2) {
            if (pexp_1 instanceof PointAtomObligationEvent) {
              _matched_2=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomObligationEvent)pexp_1).getObligationEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "ShappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "ShappensBefore", pairs);
              }
            }
          }
          if (!_matched_2) {
            if (pexp_1 instanceof PointAtomPowerEvent) {
              _matched_2=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomPowerEvent)pexp_1).getPowerEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "ShappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "ShappensBefore", pairs);
              }
            }
          }
          if (!_matched_2) {
            if (pexp_1 instanceof PointAtomContractEvent) {
              _matched_2=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomContractEvent)pexp_1).getContractEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "ShappensBefore");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hbefore_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "ShappensBefore", pairs);
              }
            }
          }
        }
        if ((it instanceof PredicateFunctionHappensAfter)) {
          final Point point_2 = ((PredicateFunctionHappensAfter)it).getPoint();
          final PointExpression pexp_2 = point_2.getPointExpression();
          boolean _matched_3 = false;
          if (pexp_2 instanceof PointAtomParameterDotExpression) {
            _matched_3=true;
            String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
            final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
            String _generateDotExpressionString = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp_2).getVariable(), null);
            final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateDotExpressionString);
            boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "HappensAfter");
            boolean _not = (!_isDuplicate);
            if (_not) {
              ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
              pairs.add(pair1);
              pairs.add(pair2);
              String _value = pair1.getValue();
              String _plus = ("hafter_" + _value);
              String _plus_1 = (_plus + "_");
              String _value_1 = pair2.getValue();
              String _plus_2 = (_plus_1 + _value_1);
              this.addVariable(_plus_2, null, "HappensAfter", pairs);
            }
          }
          if (!_matched_3) {
            if (pexp_2 instanceof PointAtomObligationEvent) {
              _matched_3=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomObligationEvent)pexp_2).getObligationEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "HappensAfter");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hafter_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "HappensAfter", pairs);
              }
            }
          }
          if (!_matched_3) {
            if (pexp_2 instanceof PointAtomPowerEvent) {
              _matched_3=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomPowerEvent)pexp_2).getPowerEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "HappensAfter");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hafter_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "HappensAfter", pairs);
              }
            }
          }
          if (!_matched_3) {
            if (pexp_2 instanceof PointAtomContractEvent) {
              _matched_3=true;
              String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
              final Pair<String, String> pair1 = new Pair<String, String>("event1", _generateEventVariableString);
              String _generateEventVariableString_1 = this.generateEventVariableString(((PointAtomContractEvent)pexp_2).getContractEvent());
              final Pair<String, String> pair2 = new Pair<String, String>("event2", _generateEventVariableString_1);
              boolean _isDuplicate = this.isDuplicate(pair1.getValue(), pair2.getValue(), "HappensAfter");
              boolean _not = (!_isDuplicate);
              if (_not) {
                ArrayList<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
                pairs.add(pair1);
                pairs.add(pair2);
                String _value = pair1.getValue();
                String _plus = ("hafter_" + _value);
                String _plus_1 = (_plus + "_");
                String _value_1 = pair2.getValue();
                String _plus_2 = (_plus_1 + _value_1);
                this.addVariable(_plus_2, null, "HappensAfter", pairs);
              }
            }
          }
        }
      }
    }
  }

  public String generateVEProposition(final String normName, final String ev) {
    return (((((((((("(" + ev) + ".event._expired | (") + ev) + ".event._happened & !(") + ev) + ".event.performer = ") + normName) + "_debtor._name & ") + normName) + "_debtor._is_performer)))");
  }

  public String generateVEFunctionString(final String normName, final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      Event _event = ((PredicateFunctionHappens)predicate).getEvent();
      boolean _matched_1 = false;
      if (_event instanceof VariableEvent) {
        _matched_1=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateVEProposition = this.generateVEProposition(normName, this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent()));
        _builder.append(_generateVEProposition);
        return _builder.toString();
      }
      if (!_matched_1) {
        if (_event instanceof PowerEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
      if (!_matched_1) {
        if (_event instanceof ObligationEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
      if (!_matched_1) {
        if (_event instanceof ContractEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateVEProposition = this.generateVEProposition(normName, this.generateEventVariableString(((PredicateFunctionWHappensBefore)predicate).getEvent()));
        _builder.append(_generateVEProposition);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateVEProposition = this.generateVEProposition(normName, this.generateEventVariableString(((PredicateFunctionSHappensBefore)predicate).getEvent()));
        _builder.append(_generateVEProposition);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateVEProposition = this.generateVEProposition(normName, this.generateEventVariableString(((PredicateFunctionHappensAfter)predicate).getEvent()));
        _builder.append(_generateVEProposition);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        Interval _interval = ((PredicateFunctionHappensWithin)predicate).getInterval();
        if ((_interval instanceof IntervalFunction)) {
          StringConcatenation _builder = new StringConcatenation();
          String _generateVEProposition = this.generateVEProposition(normName, this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent()));
          _builder.append(_generateVEProposition);
          return _builder.toString();
        }
      }
    }
    return null;
  }

  public String generateViolateExpireString(final String normName, final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generateViolateExpireString = this.generateViolateExpireString(normName, ((POr)proposition).getLeft());
      String _plus = (_generateViolateExpireString + "&");
      String _generateViolateExpireString_1 = this.generateViolateExpireString(normName, ((POr)proposition).getRight());
      return (_plus + _generateViolateExpireString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generateViolateExpireString = this.generateViolateExpireString(normName, ((PAnd)proposition).getLeft());
        String _plus = (_generateViolateExpireString + "|");
        String _generateViolateExpireString_1 = this.generateViolateExpireString(normName, ((PAnd)proposition).getRight());
        return (_plus + _generateViolateExpireString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        String _generateViolateExpireString = this.generateViolateExpireString(normName, ((PAtomRecursive)proposition).getInner());
        String _plus = ("(" + _generateViolateExpireString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generateViolateExpireString = this.generateViolateExpireString(normName, ((PComparison)proposition).getLeft());
        String _inverseOperator = this.inverseOperator(((PComparison)proposition).getOp());
        String _plus = (_generateViolateExpireString + _inverseOperator);
        String _generateViolateExpireString_1 = this.generateViolateExpireString(normName, ((PComparison)proposition).getRight());
        return (_plus + _generateViolateExpireString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        String _generateViolateExpireString = this.generateViolateExpireString(normName, ((NegatedPAtom)proposition).getNegated());
        String _plus = ("(" + _generateViolateExpireString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generateViolateExpireString = this.generateViolateExpireString(normName, ((PEquality)proposition).getLeft());
        String _inverseOperator = this.inverseOperator(((PEquality)proposition).getOp());
        String _plus = (_generateViolateExpireString + _inverseOperator);
        String _generateViolateExpireString_1 = this.generateViolateExpireString(normName, ((PEquality)proposition).getRight());
        return (_plus + _generateViolateExpireString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return SymboleoPCGenerator.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), null);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generateVEFunctionString(normName, ((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "FALSE";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "TRUE";
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
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        Enumeration _enumeration = ((PAtomEnum)proposition).getEnumeration();
        String _plus = (_enumeration + ".");
        EnumItem _enumItem = ((PAtomEnum)proposition).getEnumItem();
        return (_plus + _enumItem);
      }
    }
    return null;
  }

  public void addVariable(final String name, final String starterProposition, final String variableClass, final ArrayList<Pair<String, String>> attributes) {
    final DeclarationVariable p = new DeclarationVariable(name, starterProposition, variableClass, attributes);
    this.pcVariables.add(p);
  }

  public void addSituation(final String name, final String proposition) {
    this.pcSituations.add((((name + " : Situation (") + proposition) + ");"));
  }

  public String addHappensWith(final String evname, final String situation) {
    String _string = UUID.randomUUID().toString();
    final String name = ("hsituation" + _string);
    this.pcSituations.add((((((name + " : HappensWith (") + evname) + ",") + situation) + ");"));
    return (name + "._holds");
  }

  public String generatePowerProposition(final String powerName, final String exertedEventName) {
    return (((((((((("(" + powerName) + "._active & ") + exertedEventName) + "._happened & ") + exertedEventName) + ".performer = ") + powerName) + "_creditor._name & ") + powerName) + "_creditor._is_performer )");
  }

  public String generateProposition(final String normName, final SymboleoPCGenerator.normType ntype, final SymboleoPCGenerator.propositionType ptype, final String exertedEventName) {
    if (ptype != null) {
      switch (ptype) {
        case ANTECEDENT:
          return ((("(" + exertedEventName) + ".event._happened") + ")");
        case TRIGGER:
          return ((("(" + exertedEventName) + ".event._happened") + ")");
        case CONSEQUENT:
          if (ntype != null) {
            switch (ntype) {
              case OBLIGATION:
                return ((((((((("(" + exertedEventName) + ".event._happened & ") + exertedEventName) + ".event.performer = ") + normName) + "_debtor._name & ") + normName) + "_debtor._is_performer") + ")");
              case POWER:
                return ((((((((("(" + exertedEventName) + ".event._happened & ") + exertedEventName) + ".event.performer = ") + normName) + "_creditor._name & ") + normName) + "_creditor._is_performer") + ")");
              default:
                break;
            }
          }
          break;
        default:
          return ((("(" + exertedEventName) + ".event._happened") + ")");
      }
    } else {
      return ((("(" + exertedEventName) + ".event._happened") + ")");
    }
    return null;
  }

  public String generateContractPreconditionSituation(final Model model) {
    String precondition = "";
    EList<Proposition> _preconditions = model.getPreconditions();
    for (final Proposition cond : _preconditions) {
      int _length = precondition.length();
      boolean _equals = (_length == 0);
      if (_equals) {
        String _precondition = precondition;
        String _generatePropositionString = this.generatePropositionString(null, null, null, cond);
        precondition = (_precondition + _generatePropositionString);
      } else {
        String _precondition_1 = precondition;
        String _generatePropositionString_1 = this.generatePropositionString(null, null, null, cond);
        String _plus = (" & " + _generatePropositionString_1);
        precondition = (_precondition_1 + _plus);
      }
    }
    int _length_1 = precondition.length();
    boolean _greaterThan = (_length_1 > 0);
    if (_greaterThan) {
      String _contractName = model.getContractName();
      String situationName = (_contractName + "_precondition");
      this.addSituation(situationName, ("cnt.state = not_created -> " + precondition));
      return (situationName + "._holds");
    }
    return "";
  }

  public String generateContractTerminationSituation(final Model model) {
    boolean isFirst = true;
    String cntTermPowers = new String("");
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PFContractTerminated)) {
        String _name = power.getName();
        final String eventName = (_name + "_exerted");
        String _name_1 = power.getName();
        String _plus = (_name_1 + ".state=inEffect");
        this.addVariable(eventName, _plus, "Event", null);
        String _name_2 = power.getName();
        String _plus_1 = (_name_2 + "_exertion");
        this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
        if (isFirst) {
          String _cntTermPowers = cntTermPowers;
          String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
          cntTermPowers = (_cntTermPowers + _generatePowerProposition);
          isFirst = false;
        } else {
          String _cntTermPowers_1 = cntTermPowers;
          String _generatePowerProposition_1 = this.generatePowerProposition(power.getName(), eventName);
          String _plus_2 = ("|" + _generatePowerProposition_1);
          cntTermPowers = (_cntTermPowers_1 + _plus_2);
        }
      }
    }
    int _length = cntTermPowers.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      String _contractName = model.getContractName();
      String situationName = (_contractName + "_termination");
      this.addSituation(situationName, cntTermPowers);
      return (situationName + "._holds");
    }
    return "FALSE";
  }

  public String generateContractSuspensionSituation(final Model model) {
    boolean isFirst = true;
    String cntSusPowers = new String("");
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PFContractSuspended)) {
        String _name = power.getName();
        final String eventName = (_name + "_exerted");
        String _name_1 = power.getName();
        String _plus = (_name_1 + ".state=inEffect");
        this.addVariable(eventName, _plus, "Event", null);
        String _name_2 = power.getName();
        String _plus_1 = (_name_2 + "_exertion");
        this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
        if (isFirst) {
          String _cntSusPowers = cntSusPowers;
          String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
          cntSusPowers = (_cntSusPowers + _generatePowerProposition);
          isFirst = false;
        } else {
          String _cntSusPowers_1 = cntSusPowers;
          String _generatePowerProposition_1 = this.generatePowerProposition(power.getName(), eventName);
          String _plus_2 = ("|" + _generatePowerProposition_1);
          cntSusPowers = (_cntSusPowers_1 + _plus_2);
        }
      }
    }
    int _length = cntSusPowers.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      String _contractName = model.getContractName();
      String situationName = (_contractName + "_suspension");
      this.addSituation(situationName, cntSusPowers);
      return (situationName + "._holds");
    }
    return "FALSE";
  }

  public String generateContractResumptionSituation(final Model model) {
    boolean isFirst = true;
    String cntResPowers = new String("");
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PFContractResumed)) {
        String _name = power.getName();
        final String eventName = (_name + "_exerted");
        String _name_1 = power.getName();
        String _plus = (_name_1 + ".state=inEffect");
        this.addVariable(eventName, _plus, "Event", null);
        String _name_2 = power.getName();
        String _plus_1 = (_name_2 + "_exertion");
        this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
        if (isFirst) {
          String _cntResPowers = cntResPowers;
          String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
          cntResPowers = (_cntResPowers + _generatePowerProposition);
          isFirst = false;
        } else {
          String _cntResPowers_1 = cntResPowers;
          String _generatePowerProposition_1 = this.generatePowerProposition(power.getName(), eventName);
          String _plus_2 = ("|" + _generatePowerProposition_1);
          cntResPowers = (_cntResPowers_1 + _plus_2);
        }
      }
    }
    int _length = cntResPowers.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      String _contractName = model.getContractName();
      String situationName = (_contractName + "_resumption");
      this.addSituation(situationName, cntResPowers);
      return (situationName + "._holds");
    }
    return "FALSE";
  }

  public Map<String, String> generateObligationsSuspensionSituation(final Model model) {
    Map<String, String> propositions = new HashMap<String, String>();
    Map<String, String> situations = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PowerFunction)) {
        PowerFunction cons = power.getConsequent();
        if ((cons instanceof PFObligationSuspended)) {
          String oblName = ((PFObligationSuspended)cons).getNorm().getName();
          String _name = power.getName();
          String eventName = (_name + "_exerted");
          String _name_1 = power.getName();
          String _plus = (_name_1 + ".state=inEffect");
          this.addVariable(eventName, _plus, "Event", null);
          String _name_2 = power.getName();
          String _plus_1 = (_name_2 + "_exertion");
          this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
          String _get = situations.get(oblName);
          boolean _tripleEquals = (_get == null);
          if (_tripleEquals) {
            propositions.put(oblName, this.generatePowerProposition(power.getName(), eventName));
          } else {
            String _get_1 = propositions.get(oblName);
            String _plus_2 = (_get_1 + "|");
            String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
            String _plus_3 = (_plus_2 + _generatePowerProposition);
            propositions.put(oblName, _plus_3);
          }
        }
      }
    }
    Set<Map.Entry<String, String>> _entrySet = propositions.entrySet();
    for (final Map.Entry<String, String> entry : _entrySet) {
      int _length = entry.getValue().length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _key = entry.getKey();
        String situationName = (_key + "_suspension");
        this.addSituation(situationName, entry.getValue());
        situations.put(entry.getKey(), (situationName + "._holds"));
      }
    }
    return situations;
  }

  public Map<String, String> generateObligationsResumptionSituation(final Model model) {
    Map<String, String> propositions = new HashMap<String, String>();
    Map<String, String> situations = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PowerFunction)) {
        PowerFunction cons = power.getConsequent();
        if ((cons instanceof PFObligationResumed)) {
          String oblName = ((PFObligationResumed)cons).getNorm().getName();
          String _name = power.getName();
          String eventName = (_name + "_exerted");
          String _name_1 = power.getName();
          String _plus = (_name_1 + ".state=inEffect");
          this.addVariable(eventName, _plus, "Event", null);
          String _name_2 = power.getName();
          String _plus_1 = (_name_2 + "_exertion");
          this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
          String _get = situations.get(oblName);
          boolean _tripleEquals = (_get == null);
          if (_tripleEquals) {
            propositions.put(oblName, this.generatePowerProposition(power.getName(), eventName));
          } else {
            String _get_1 = propositions.get(oblName);
            String _plus_2 = (_get_1 + "|");
            String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
            String _plus_3 = (_plus_2 + _generatePowerProposition);
            propositions.put(oblName, _plus_3);
          }
        }
      }
    }
    Set<Map.Entry<String, String>> _entrySet = propositions.entrySet();
    for (final Map.Entry<String, String> entry : _entrySet) {
      int _length = entry.getValue().length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _key = entry.getKey();
        String situationName = (_key + "_resumption");
        this.addSituation(situationName, entry.getValue());
        situations.put(entry.getKey(), (situationName + "._holds"));
      }
    }
    return situations;
  }

  public Map<String, String> generateObligationsDischargeSituation(final Model model) {
    Map<String, String> propositions = new HashMap<String, String>();
    Map<String, String> situations = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PowerFunction)) {
        PowerFunction cons = power.getConsequent();
        if ((cons instanceof PFObligationDischarged)) {
          String oblName = ((PFObligationDischarged)cons).getNorm().getName();
          String _name = power.getName();
          String eventName = (_name + "_exerted");
          String _name_1 = power.getName();
          String _plus = (_name_1 + ".state=inEffect");
          this.addVariable(eventName, _plus, "Event", null);
          String _name_2 = power.getName();
          String _plus_1 = (_name_2 + "_exertion");
          this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
          String _get = situations.get(oblName);
          boolean _tripleEquals = (_get == null);
          if (_tripleEquals) {
            propositions.put(oblName, this.generatePowerProposition(power.getName(), eventName));
          } else {
            String _get_1 = propositions.get(oblName);
            String _plus_2 = (_get_1 + "|");
            String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
            String _plus_3 = (_plus_2 + _generatePowerProposition);
            propositions.put(oblName, _plus_3);
          }
        }
      }
    }
    Set<Map.Entry<String, String>> _entrySet = propositions.entrySet();
    for (final Map.Entry<String, String> entry : _entrySet) {
      int _length = entry.getValue().length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _key = entry.getKey();
        String situationName = (_key + "_discard");
        this.addSituation(situationName, entry.getValue());
        situations.put(entry.getKey(), (situationName + "._holds"));
      }
    }
    return situations;
  }

  public Map<String, String> generateObligationsTerminationSituation(final Model model) {
    Map<String, String> propositions = new HashMap<String, String>();
    Map<String, String> situations = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      PowerFunction _consequent = power.getConsequent();
      if ((_consequent instanceof PowerFunction)) {
        PowerFunction cons = power.getConsequent();
        if ((cons instanceof PFObligationTerminated)) {
          String oblName = ((PFObligationTerminated)cons).getNorm().getName();
          String _name = power.getName();
          String eventName = (_name + "_exerted");
          String _name_1 = power.getName();
          String _plus = (_name_1 + ".state=inEffect");
          this.addVariable(eventName, _plus, "Event", null);
          String _name_2 = power.getName();
          String _plus_1 = (_name_2 + "_exertion");
          this.addSituation(_plus_1, this.generatePowerProposition(power.getName(), eventName));
          String _get = situations.get(oblName);
          boolean _tripleEquals = (_get == null);
          if (_tripleEquals) {
            propositions.put(oblName, this.generatePowerProposition(power.getName(), eventName));
          } else {
            String _get_1 = propositions.get(oblName);
            String _plus_2 = (_get_1 + "|");
            String _generatePowerProposition = this.generatePowerProposition(power.getName(), eventName);
            String _plus_3 = (_plus_2 + _generatePowerProposition);
            propositions.put(oblName, _plus_3);
          }
        }
      }
    }
    Set<Map.Entry<String, String>> _entrySet = propositions.entrySet();
    for (final Map.Entry<String, String> entry : _entrySet) {
      int _length = entry.getValue().length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _key = entry.getKey();
        String situationName = (_key + "_termination");
        this.addSituation(situationName, entry.getValue());
        situations.put(entry.getKey(), (situationName + "._holds"));
      }
    }
    return situations;
  }

  public Map<String, String> generateObligationViolatedSituation(final Model model) {
    Map<String, String> violations = new HashMap<String, String>();
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        final String violation = this.generateViolateExpireString(obligation.getName(), obligation.getConsequent());
        if ((violation != null)) {
          String _name = obligation.getName();
          String situationName = (_name + "_violated");
          this.addSituation(situationName, violation);
          violations.put(obligation.getName(), (situationName + "._holds"));
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        final String violation = this.generateViolateExpireString(obligation_1.getName(), obligation_1.getConsequent());
        if ((violation != null)) {
          String _name = obligation_1.getName();
          String situationName = (_name + "_violated");
          this.addSituation(situationName, violation);
          violations.put(obligation_1.getName(), (situationName + "._holds"));
        }
      }
    }
    return violations;
  }

  public Map<String, String> generateObligationExpiredSituation(final Model model) {
    Map<String, String> expirations = new HashMap<String, String>();
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        final String expiration = this.generateViolateExpireString(obligation.getName(), obligation.getAntecedent());
        if ((expiration != null)) {
          String _name = obligation.getName();
          String situationName = (_name + "_expired");
          this.addSituation(situationName, expiration);
          expirations.put(obligation.getName(), (situationName + "._holds"));
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        final String expiration = this.generateViolateExpireString(obligation_1.getName(), obligation_1.getAntecedent());
        if ((expiration != null)) {
          String _name = obligation_1.getName();
          String situationName = (_name + "_expired");
          this.addSituation(situationName, expiration);
          expirations.put(obligation_1.getName(), (situationName + "._holds"));
        }
      }
    }
    return expirations;
  }

  public Map<String, String> generatePowerExpiredSituation(final Model model) {
    Map<String, String> expirations = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        final String expiration = this.generateViolateExpireString(power.getName(), power.getAntecedent());
        if ((expiration != null)) {
          String _name = power.getName();
          String situationName = (_name + "_expired");
          this.addSituation(situationName, expiration);
          expirations.put(power.getName(), (situationName + "._holds"));
        }
      }
    }
    return expirations;
  }

  public Map<String, String> generatePowerExertedSituation(final Model model) {
    Map<String, String> exertion = new HashMap<String, String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        String _name = power.getName();
        String situationName = (_name + "_exertion._holds");
        exertion.put(power.getName(), situationName);
      }
    }
    return exertion;
  }

  public Map<String, String> generateAntecedentsSituation(final Model model) {
    Map<String, String> situations = new HashMap<String, String>();
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        final String antecedent = this.generatePropositionString(obligation.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.ANTECEDENT, obligation.getAntecedent());
        if (((antecedent != null) && (!Objects.equal(antecedent, "TRUE")))) {
          String _name = obligation.getName();
          final String sname = (_name + "_antecedent");
          this.addSituation(sname, antecedent);
          situations.put(obligation.getName(), (sname + "._holds"));
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        final String antecedent = this.generatePropositionString(obligation_1.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.ANTECEDENT, obligation_1.getAntecedent());
        if (((antecedent != null) && (!Objects.equal(antecedent, "TRUE")))) {
          String _name = obligation_1.getName();
          final String sname = (_name + "_antecedent");
          this.addSituation(sname, antecedent);
          situations.put(obligation_1.getName(), (sname + "._holds"));
        }
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        final String antecedent = this.generatePropositionString(power.getName(), SymboleoPCGenerator.normType.POWER, SymboleoPCGenerator.propositionType.ANTECEDENT, power.getAntecedent());
        if (((antecedent != null) && (!Objects.equal(antecedent, "TRUE")))) {
          String _name = power.getName();
          final String sname = (_name + "_antecedent");
          this.addSituation(sname, antecedent);
          situations.put(power.getName(), (sname + "._holds"));
        }
      }
    }
    return situations;
  }

  public Map<String, String> generateConsequentsSituation(final Model model) {
    Map<String, String> situations = new HashMap<String, String>();
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        String _name = obligation.getName();
        final String sname = (_name + "_consequent");
        this.addSituation(sname, this.generatePropositionString(obligation.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.CONSEQUENT, obligation.getConsequent()));
        situations.put(obligation.getName(), (sname + "._holds"));
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        String _name = obligation_1.getName();
        final String sname = (_name + "_consequent");
        this.addSituation(sname, this.generatePropositionString(obligation_1.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.CONSEQUENT, obligation_1.getConsequent()));
        situations.put(obligation_1.getName(), (sname + "._holds"));
      }
    }
    return situations;
  }

  public Map<String, String> generateTriggersSituation(final Model model) {
    Map<String, String> situations = new HashMap<String, String>();
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        final String trigger = this.generatePropositionString(obligation.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.TRIGGER, obligation.getTrigger());
        if (((trigger != null) && (!Objects.equal(trigger, "TRUE")))) {
          String _name = obligation.getName();
          final String sname = (_name + "_trigger");
          this.addSituation(sname, trigger);
          situations.put(obligation.getName(), (sname + "._holds"));
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        final String trigger = this.generatePropositionString(obligation_1.getName(), SymboleoPCGenerator.normType.OBLIGATION, SymboleoPCGenerator.propositionType.TRIGGER, obligation_1.getTrigger());
        if (((trigger != null) && (!Objects.equal(trigger, "TRUE")))) {
          String _name = obligation_1.getName();
          final String sname = (_name + "_trigger");
          this.addSituation(sname, trigger);
          situations.put(obligation_1.getName(), (sname + "._holds"));
        }
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        final String trigger = this.generatePropositionString(power.getName(), SymboleoPCGenerator.normType.POWER, SymboleoPCGenerator.propositionType.TRIGGER, power.getTrigger());
        String _name = power.getName();
        final String sname = (_name + "_trigger");
        if (((trigger != null) && (!Objects.equal(trigger, "TRUE")))) {
          this.addSituation(sname, trigger);
          situations.put(power.getName(), (sname + "._holds"));
        }
      }
    }
    return situations;
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
        list.add(((PAtomPredicate)proposition));
      }
    }
    return list;
  }

  public static String generateDotExpressionString(final Ref argRef, final String thisString) {
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
    if ((thisString != null)) {
      ids.add(thisString);
    }
    List<String> revIds = ListExtensions.<String>reverse(ids);
    String expression = "";
    for (final String id : revIds) {
      if ((expression == "")) {
        expression = id;
      } else {
        String _expression = expression;
        expression = (_expression + ("." + id));
      }
    }
    return expression;
  }

  public String extractEventVariableString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      return SymboleoPCGenerator.generateDotExpressionString(((VariableEvent)event).getVariable(), null);
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _lowerCase = ((PowerEvent)event).getEventName().toLowerCase();
        _builder.append(_lowerCase);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _lowerCase = ((ObligationEvent)event).getEventName().toLowerCase();
        _builder.append(_lowerCase);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _lowerCase = ((ContractEvent)event).getEventName().toLowerCase();
        _builder.append(_lowerCase);
        return _builder.toString();
      }
    }
    return null;
  }

  public String getEqualityOperator(final String op) {
    if (op != null) {
      switch (op) {
        case "!=":
          return "!=";
        case "==":
          return "=";
      }
    }
    return null;
  }

  public String inverseOperator(final String op) {
    if (op != null) {
      switch (op) {
        case "!=":
          return "=";
        case "==":
          return "!=";
        case ">":
          return "<=";
        case "<":
          return ">=";
        case ">=":
          return "<";
        case "<=":
          return ">";
      }
    }
    return null;
  }

  public String getHappensPredicateVarName(final PredicateFunction it) {
    if ((it instanceof PredicateFunctionWHappensBefore)) {
      final Point point = ((PredicateFunctionWHappensBefore)it).getPoint();
      final PointExpression pexp = point.getPointExpression();
      boolean _matched = false;
      if (pexp instanceof PointAtomParameterDotExpression) {
        _matched=true;
        final String eventN1 = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
        final String eventN2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp).getVariable(), null);
        return ((("hbefore_" + eventN1) + "_") + eventN2);
      }
      if (!_matched) {
        if (pexp instanceof PointAtomObligationEvent) {
          _matched=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomObligationEvent)pexp).getObligationEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched) {
        if (pexp instanceof PointAtomPowerEvent) {
          _matched=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomPowerEvent)pexp).getPowerEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched) {
        if (pexp instanceof PointAtomContractEvent) {
          _matched=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionWHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomContractEvent)pexp).getContractEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
    }
    if ((it instanceof PredicateFunctionSHappensBefore)) {
      final Point point_1 = ((PredicateFunctionSHappensBefore)it).getPoint();
      final PointExpression pexp_1 = point_1.getPointExpression();
      boolean _matched_1 = false;
      if (pexp_1 instanceof PointAtomParameterDotExpression) {
        _matched_1=true;
        final String eventN1 = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
        final String eventN2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp_1).getVariable(), null);
        return ((("hbefore_" + eventN1) + "_") + eventN2);
      }
      if (!_matched_1) {
        if (pexp_1 instanceof PointAtomObligationEvent) {
          _matched_1=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomObligationEvent)pexp_1).getObligationEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched_1) {
        if (pexp_1 instanceof PointAtomPowerEvent) {
          _matched_1=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomPowerEvent)pexp_1).getPowerEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched_1) {
        if (pexp_1 instanceof PointAtomContractEvent) {
          _matched_1=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionSHappensBefore)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomContractEvent)pexp_1).getContractEvent());
          return ((("hbefore_" + eventN1) + "_") + eventN2);
        }
      }
    }
    if ((it instanceof PredicateFunctionHappensAfter)) {
      final Point point_2 = ((PredicateFunctionHappensAfter)it).getPoint();
      final PointExpression pexp_2 = point_2.getPointExpression();
      boolean _matched_2 = false;
      if (pexp_2 instanceof PointAtomParameterDotExpression) {
        _matched_2=true;
        final String eventN1 = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
        final String eventN2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)pexp_2).getVariable(), null);
        return ((("hafter_" + eventN1) + "_") + eventN2);
      }
      if (!_matched_2) {
        if (pexp_2 instanceof PointAtomObligationEvent) {
          _matched_2=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomObligationEvent)pexp_2).getObligationEvent());
          return ((("hafter_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched_2) {
        if (pexp_2 instanceof PointAtomPowerEvent) {
          _matched_2=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomPowerEvent)pexp_2).getPowerEvent());
          return ((("hafter_" + eventN1) + "_") + eventN2);
        }
      }
      if (!_matched_2) {
        if (pexp_2 instanceof PointAtomContractEvent) {
          _matched_2=true;
          final String eventN1 = this.generateEventVariableString(((PredicateFunctionHappensAfter)it).getEvent());
          final String eventN2 = this.generateEventVariableString(((PointAtomContractEvent)pexp_2).getContractEvent());
          return ((("hafter_" + eventN1) + "_") + eventN2);
        }
      }
    }
    return null;
  }

  public String generatePredicateFunctionString(final String normName, final SymboleoPCGenerator.normType nType, final SymboleoPCGenerator.propositionType pType, final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
      SymboleoPredicate _symboleoPredicate = new SymboleoPredicate(predicateType.HAPPENS, _extractEventVariableString);
      this.predicates.add(_symboleoPredicate);
      Event _event = ((PredicateFunctionHappens)predicate).getEvent();
      boolean _matched_1 = false;
      if (_event instanceof VariableEvent) {
        _matched_1=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateProposition = this.generateProposition(normName, nType, pType, this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent()));
        _builder.append(_generateProposition);
        return _builder.toString();
      }
      if (!_matched_1) {
        if (_event instanceof PowerEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
      if (!_matched_1) {
        if (_event instanceof ObligationEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
      if (!_matched_1) {
        if (_event instanceof ContractEvent) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
          _builder.append(_generateEventVariableString);
          return _builder.toString();
        }
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        String _happensPredicateVarName = this.getHappensPredicateVarName(predicate);
        return (_happensPredicateVarName + "._true");
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        String _happensPredicateVarName = this.getHappensPredicateVarName(predicate);
        return (_happensPredicateVarName + "._true");
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        String _happensPredicateVarName = this.getHappensPredicateVarName(predicate);
        return (_happensPredicateVarName + "._true");
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        Interval _interval = ((PredicateFunctionHappensWithin)predicate).getInterval();
        if ((_interval instanceof IntervalFunction)) {
          final Interval pi = ((PredicateFunctionHappensWithin)predicate).getInterval();
          final IntervalExpression pe = pi.getIntervalExpression();
          if ((pe instanceof IntervalFunction)) {
            final PointExpression pa1 = ((IntervalFunction)pe).getArg1();
            final PointExpression pa2 = ((IntervalFunction)pe).getArg2();
            String _extractEventVariableString = this.extractEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
            SymboleoPredicate _symboleoPredicate = new SymboleoPredicate(predicateType.HAPPENSWITHIN, _extractEventVariableString, pa1, pa2);
            this.predicates.add(_symboleoPredicate);
          }
          StringConcatenation _builder = new StringConcatenation();
          String _generateProposition = this.generateProposition(normName, nType, pType, this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent()));
          _builder.append(_generateProposition);
          return _builder.toString();
        } else {
          Interval _interval_1 = ((PredicateFunctionHappensWithin)predicate).getInterval();
          if ((_interval_1 instanceof SituationExpression)) {
            final IntervalExpression ie = ((PredicateFunctionHappensWithin)predicate).getInterval().getIntervalExpression();
            if ((ie instanceof SituationExpression)) {
              final Situation situation = ((SituationExpression)ie).getSituation();
              boolean _matched_1 = false;
              if (situation instanceof ObligationState) {
                _matched_1=true;
                StringConcatenation _builder_1 = new StringConcatenation();
                String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
                String _name = ((ObligationState)situation).getObligationVariable().getName();
                String _plus = (_name + ".state = ");
                String _stateName = ((ObligationState)situation).getStateName();
                String _plus_1 = (_plus + _stateName);
                String _addHappensWith = this.addHappensWith(_generateEventVariableString, _plus_1);
                _builder_1.append(_addHappensWith);
                return _builder_1.toString();
              }
              if (!_matched_1) {
                if (situation instanceof PowerState) {
                  _matched_1=true;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
                  String _name = ((PowerState)situation).getPowerVariable().getName();
                  String _plus = (_name + ".state = ");
                  String _stateName = ((PowerState)situation).getStateName();
                  String _plus_1 = (_plus + _stateName);
                  String _addHappensWith = this.addHappensWith(_generateEventVariableString, _plus_1);
                  _builder_1.append(_addHappensWith);
                  return _builder_1.toString();
                }
              }
              if (!_matched_1) {
                if (situation instanceof ContractState) {
                  _matched_1=true;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
                  String _stateName = ((ContractState)situation).getStateName();
                  String _plus = ("cnt.state = " + _stateName);
                  String _addHappensWith = this.addHappensWith(_generateEventVariableString, _plus);
                  _builder_1.append(_addHappensWith);
                  return _builder_1.toString();
                }
              }
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("HappensWithin(");
              Event _event = ((PredicateFunctionHappensWithin)predicate).getEvent();
              _builder_1.append(_event);
              _builder_1.append(", ");
              Interval _interval_2 = ((PredicateFunctionHappensWithin)predicate).getInterval();
              _builder_1.append(_interval_2);
              _builder_1.append(")");
              return _builder_1.toString();
            }
          }
        }
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionIsEqual) {
        _matched=true;
        String _arg1 = ((PredicateFunctionIsEqual)predicate).getArg1();
        String _plus = (_arg1 + ".party = ");
        String _arg2 = ((PredicateFunctionIsEqual)predicate).getArg2();
        String _plus_1 = (_plus + _arg2);
        return (_plus_1 + ".party");
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionIsOwner) {
        _matched=true;
        String _arg1 = ((PredicateFunctionIsOwner)predicate).getArg1();
        String _plus = (_arg1 + ".owner = ");
        String _arg2 = ((PredicateFunctionIsOwner)predicate).getArg2();
        String _plus_1 = (_plus + _arg2);
        return (_plus_1 + ".party");
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionCannotBeAssigned) {
        _matched=true;
        this.pcAssignProhibitedNorms.add(((PredicateFunctionCannotBeAssigned)predicate).getArg1());
        return null;
      }
    }
    return null;
  }

  public String generatePropositionString(final String normName, final SymboleoPCGenerator.normType nType, final SymboleoPCGenerator.propositionType pType, final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((POr)proposition).getLeft());
      String _plus = (_generatePropositionString + " | ");
      String _generatePropositionString_1 = this.generatePropositionString(normName, nType, pType, ((POr)proposition).getRight());
      return (_plus + _generatePropositionString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((PAnd)proposition).getLeft());
        String _plus = (_generatePropositionString + " & ");
        String _generatePropositionString_1 = this.generatePropositionString(normName, nType, pType, ((PAnd)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((PEquality)proposition).getLeft());
        String _equalityOperator = this.getEqualityOperator(((PEquality)proposition).getOp());
        String _plus = (_generatePropositionString + _equalityOperator);
        String _generatePropositionString_1 = this.generatePropositionString(normName, nType, pType, ((PEquality)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((PComparison)proposition).getLeft());
        String _op = ((PComparison)proposition).getOp();
        String _plus = (_generatePropositionString + _op);
        String _generatePropositionString_1 = this.generatePropositionString(normName, nType, pType, ((PComparison)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((PAtomRecursive)proposition).getInner());
        String _plus = ("(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(normName, nType, pType, ((NegatedPAtom)proposition).getNegated());
        String _plus = ("!(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateFunctionString(normName, nType, pType, ((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        Enumeration _enumeration = ((PAtomEnum)proposition).getEnumeration();
        String _plus = (_enumeration + ".");
        EnumItem _enumItem = ((PAtomEnum)proposition).getEnumItem();
        return (_plus + _enumItem);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return SymboleoPCGenerator.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), null);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "TRUE";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "FALSE";
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
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    return null;
  }

  public Boolean isEvent(final String ev) {
    for (final Variable e : this.eventVariables) {
      boolean _equals = e.getName().equals(ev);
      if (_equals) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }

  public String generateConstraint(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      return null;
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        final PointExpression expression = ((PredicateFunctionSHappensBefore)predicate).getPoint().getPointExpression();
        if ((expression instanceof PointAtomParameterDotExpression)) {
          final String event2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)expression).getVariable(), null);
          Boolean _isEvent = this.isEvent(event2);
          if ((_isEvent).booleanValue()) {
            return ((("!(" + event2) + ".event._happened") + ")");
          }
        }
        return null;
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        final PointExpression expression = ((PredicateFunctionWHappensBefore)predicate).getPoint().getPointExpression();
        if ((expression instanceof PointAtomParameterDotExpression)) {
          final String event2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)expression).getVariable(), null);
          Boolean _isEvent = this.isEvent(event2);
          if ((_isEvent).booleanValue()) {
            return ((("!(" + event2) + ".event._happened") + ")");
          }
        }
        return null;
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        final PointExpression expression = ((PredicateFunctionHappensAfter)predicate).getPoint().getPointExpression();
        if ((expression instanceof PointAtomParameterDotExpression)) {
          final String event2 = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)expression).getVariable(), null);
          Boolean _isEvent = this.isEvent(event2);
          if ((_isEvent).booleanValue()) {
            return ((("(" + event2) + ".event._happened") + ")");
          }
        }
        return null;
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        return null;
      }
    }
    return null;
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
        return ((AtomicExpressionString)argExpression).getValue();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionParameter) {
        _matched=true;
        return SymboleoPCGenerator.generateDotExpressionString(((AtomicExpressionParameter)argExpression).getValue(), null);
      }
    }
    return null;
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
      if (functionCall instanceof TwoArgStringFunction) {
        _matched=true;
        String _name = ((TwoArgStringFunction)functionCall).getName();
        String _plus = (_name + "(");
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
        String _name = ((OneArgStringFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    return null;
  }

  public String generateStaticModules() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MODULE Timer(start)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR active1  : boolean;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("expired1 : boolean;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("init(active1) := start;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("next(active1) := (active1 | start) ? TRUE : active1;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("init(expired1) :=  active1 ? {TRUE,FALSE} : FALSE;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("next(expired1) :=  case");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("active1 & !expired1 : {TRUE,FALSE};");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("expired1           : TRUE;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("TRUE              : FALSE;");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MODULE Event(start)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE ");
    _builder.newLine();
    _builder.append(" \t\t");
    _builder.append("_active := (state = active);");
    _builder.newLine();
    _builder.append(" \t\t");
    _builder.append("_inactive := (state = inactive);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_happened := (state = happened);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_expired  := (state = expired);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR triggered : boolean;");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("timer : Timer(start & !_happened & !_expired);");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("state : {inactive, active, happened, expired};");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("performer\t: {\"CBEEF\", \"COSTCO\"};");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(performer)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state=active & start\t: {\"CBEEF\", \"COSTCO\"};");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t \t\t\t\t: performer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("init(triggered) := FALSE;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("next(triggered) := (state=active & start) ? {FALSE,TRUE} : FALSE;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("init(state)     := inactive;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("next(state)     := case");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("state=inactive & start                          : active;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("state=active & start & triggered &");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("timer.active1 : happened;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("state=active & start & timer.expired1 : expired;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("TRUE                                            : state;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- \'name\' is party name");
    _builder.newLine();
    _builder.append("-- \'removeL/R/P\' releases liability, righHolder or performer position of a party");
    _builder.newLine();
    _builder.append("-- \'addL/R/P\' adds liability, righHolder or performer position to a party");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE Party(norm, name, removeL, addL, removeR, addR, removeP, addP)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("DEFINE");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_name \t\t\t:= name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_norm\t\t\t:= norm;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_is_performer\t:= p_state=P;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_is_liable\t\t:= l_state=L;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_is_rightHolder\t:= r_state=R;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("l_state\t: {Init, L};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("r_state\t: {Init, R};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("p_state\t: {Init, P};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(l_state) := Init;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(l_state)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("l_state=Init & addL\t: L;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("l_state=L &removeL\t: Init;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t\t\t\t: l_state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(r_state) := Init;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(r_state)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r_state=Init & addR\t: R;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("r_state=R & removeR : Init;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t\t\t\t: r_state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(p_state) := Init;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(p_state)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p_state=Init & addP : P;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p_state=P & removeP\t: Init;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t\t\t\t: p_state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("INVAR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(addL & removeL) &");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(addR & removeR) &");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(addP & removeP) &");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(_is_rightHolder & _is_liable);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- \'cnt_in_effect\'    indicates if the contract is in inEffect state");
    _builder.newLine();
    _builder.append("-- \'power_suspended\'  indicates if a power suspends the obligation");
    _builder.newLine();
    _builder.append("-- \'cnt_suspended\'    indicates if the contract suspension suspends the obligation");
    _builder.newLine();
    _builder.append("-- \'power_resumed\'    indicates if a power resumption resumes the obligation");
    _builder.newLine();
    _builder.append("-- \'cnt_resumed\'      indicates if the contract resumption resumes the obligation");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE Obligation(name, surviving, cnt_in_effect, cnt_untermination,");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("fulfilled, triggered, violated, activated,");
    _builder.newLine();
    _builder.append("\t\t\t\t  ");
    _builder.append("expired1, power_suspended, cnt_suspended, terminated, power_resumed,");
    _builder.newLine();
    _builder.append("\t\t\t\t  ");
    _builder.append("cnt_resumed, discharged, antecedent)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("DEFINE");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_name \t\t:= name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_surviving\t:= surviving;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_suspended \t:= (power_suspended | (cnt_suspended & !surviving));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_active \t:= (state = inEffect | state = suspension);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("state \t\t: {not_created, create, inEffect, suspension, discharge,");
    _builder.newLine();
    _builder.append("\t\t\t\t   ");
    _builder.append("fulfillment, violation, unsTermination};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sus_state\t: {not_suspended, sus_by_contract, sus_by_power};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("--NEW: update axioms(surviving obligations are not suspended! informally mentioned)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(sus_state) := not_suspended;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(sus_state)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=not_suspended & !surviving & cnt_suspended \t: sus_by_contract;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_contract & !surviving & cnt_resumed\t: not_suspended;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=not_suspended & !surviving & power_suspended \t: sus_by_power;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_power & !surviving & power_resumed\t\t: not_suspended;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t\t\t\t\t\t\t\t\t\t\t\t\t: sus_state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init(state) := not_created;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=not_created   & triggered & !antecedent : create;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=not_created   & triggered & antecedent  : inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=create        & antecedent              : inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=create        & (expired1 | discharged)  : discharge;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=inEffect      & fulfilled               : fulfillment;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=inEffect      & _suspended              : suspension;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & state=inEffect      & violated                : violation;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_in_effect & _active            \t& terminated              : unsTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_untermination & !surviving  \t& _active           \t  : unsTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_contract & state=suspension  & cnt_resumed   : inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_power\t  & state=suspension  & power_resumed   : inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE                                                          : state;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- \'cnt_in_effect\'   indicates if the contract is in inEffect state");
    _builder.newLine();
    _builder.append("-- \'power_suspended\' indicates if a power suspends the power");
    _builder.newLine();
    _builder.append("-- \'cnt_suspended\'   indicates if the contract suspension suspends the power");
    _builder.newLine();
    _builder.append("-- \'power_resumed\'   indicates if a power resumption resumes the power");
    _builder.newLine();
    _builder.append("-- \'cnt_resumed\'     indicates if the contract resumption resumes the power");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE Power(name, cnt_in_effect, triggered, activated, expired1, power_suspended, cnt_suspended,");
    _builder.newLine();
    _builder.append("       \t     ");
    _builder.append("terminated, exerted, power_resumed, cnt_resumed, antecedent)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("DEFINE");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_name\t\t := name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_active \t := (state = inEffect | state = suspension);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_suspended \t := (power_suspended | cnt_suspended);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("state \t\t: {not_created, create, inEffect, suspension, sTermination, unsTermination};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sus_state\t: {not_suspended, sus_by_contract, sus_by_power};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(sus_state) := not_suspended;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("next(sus_state)\t:= case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=not_suspended & cnt_suspended \t: sus_by_contract;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_contract & cnt_resumed\t\t: not_suspended;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=not_suspended & power_suspended \t: sus_by_power;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sus_state=sus_by_power & power_resumed\t\t: not_suspended;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE\t\t\t\t\t\t\t\t\t\t: sus_state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("init(state) := not_created;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = not_created \t& triggered & !antecedent : create;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = not_created \t& triggered & antecedent  : inEffect;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = create      \t& antecedent              : inEffect;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = create      \t& expired1                : unsTermination;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = inEffect    \t& exerted                 : sTermination;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = inEffect   \t& _suspended              : suspension;");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("cnt_in_effect & state = inEffect    \t& expired1                : unsTermination;");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("cnt_in_effect & _active  \t\t\t \t& terminated              : unsTermination;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("sus_state=sus_by_contract & state=suspension  & cnt_resumed \t  : inEffect;");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("sus_state=sus_by_power\t   & state=suspension  & power_resumed      : inEffect;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("     ");
    _builder.append("TRUE                                          \t\t\t\t   \t  : state;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- \'assigned_party\'\t\t\t\t indicates if a party is assigned to a role");
    _builder.newLine();
    _builder.append("-- \'revoked_party\'\t\t\t\t indicates if a party is unassigned from a role");
    _builder.newLine();
    _builder.append("-- \'fulfilled_active_obligation\' indicates if all active obligations are fulfilled");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE Contract(triggered, activated, terminated, suspended, resumed,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("revoked_party, assigned_party, fulfilled_active_obligation)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("DEFINE");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_active \t := (state = unassign | state = inEffect | state = suspension);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_termination := (state = sTermination | state = unsTermination);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("-- obligations/powers\' status changes once the contract goes to inEffect state");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_o_activated := (state = form & activated) |");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("(state = suspension & resumed) |");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("(state = unassign & assigned_party) |");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("(state = inEffect);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("state \t\t : { not_created, form, inEffect, suspension, unassign, sTermination, unsTermination};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init(state) := not_created;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = not_created & triggered  \t\t\t\t\t: form;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = form        & activated  \t\t\t\t\t: inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = inEffect    & fulfilled_active_obligation  \t: sTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = inEffect    & suspended  \t\t\t\t\t: suspension;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = inEffect    & revoked_party  \t\t\t\t: unassign;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = inEffect    & terminated \t\t\t\t\t: unsTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = suspension  & resumed    \t\t\t\t\t: inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = suspension  & terminated \t\t\t\t\t: unsTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = unassign    & assigned_party \t\t\t\t: inEffect;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("state = unassign    & terminated \t\t\t\t\t: unsTermination;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TRUE                             \t\t\t\t\t: state;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- CONTRACT INDEPENDENT CONCEPTS");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE Role(party)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _party := party;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MODULE Asset(owner)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _owner := owner;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("MODULE Situation(proposition)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _holds := proposition;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("-- WhappensBefore(e,t), ShappensBefore(e,t) are HappensAfter(e,t) are simulated as Happens(e,t) \t\t ");
    _builder.newLine();
    _builder.append("MODULE WhappensBefore(event, time)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("_true := (state = happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, happened};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event.event._active & next(event.event._happened) : happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("MODULE ShappensBefore(event, time)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("_true := (state = happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, happened};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event.event._active & next(event.event._happened) : happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MODULE HappensAfter(event, time)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("_true := (state = happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, happened};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event.event._active & next(event.event._happened) : happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("MODULE WhappensBeforeE(event1, event2)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("_true := (state = happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, happened};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event1.event._active & next(event1.event._happened) & !(next(event2_happened)) : happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("MODULE ShappensBeforeE(event1, event2)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_true \t:= (state = ev1_ev2_happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, ev1_happened, ev1_ev2_happened};");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("   \t\t");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event1.event._active & next(event1.event._happened) & !(next(event2_happened)) : ev1_happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = ev1_happened & event2.event._active & next(event2.event._happened) : ev1_ev2_happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("MODULE HappensWithin(event, situation)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_true \t:= (state = happened);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {happened, not_happened};");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & event.event._active & next(event.event._happened) & situation._holds : happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("esac;\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MODULE HappensAfterE(event1, event2)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("DEFINE _false  := (state = not_happened);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_true := (state = ev2_ev1_happened);");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("VAR state: {not_happened, ev2_happened, ev2_ev1_happened};");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("ASSIGN");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("init(state) := not_happened;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("next(state) := case");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = not_happened & !(next(event1_happened)) & event2.event._active & next(event2.event._happened) : ev2_happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("state = ev2_happened & event1.event._active & next(event1.event._happened) : ev2_ev1_happened;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TRUE : state;\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    final String code = _builder.toString();
    return code;
  }

  /**
   * Generate domain modules
   */
  public String getEnumItems(final Enumeration enumeration) {
    String enums = "";
    EList<EnumItem> _enumerationItems = enumeration.getEnumerationItems();
    for (final EnumItem item : _enumerationItems) {
      int _length = enums.length();
      boolean _equals = (_length == 0);
      if (_equals) {
        String _enums = enums;
        String _name = item.getName();
        String _plus = ("\"" + _name);
        String _plus_1 = (_plus + "\"");
        enums = (_enums + _plus_1);
      } else {
        String _enums_1 = enums;
        String _name_1 = item.getName();
        String _plus_2 = (("," + "\"") + _name_1);
        String _plus_3 = (_plus_2 + "\"");
        enums = (_enums_1 + _plus_3);
      }
    }
    return enums;
  }

  public void generateEnumeration(final Enumeration enumeration) {
    this.pcEnumerations.add(this.getEnumItems(enumeration));
  }

  public void generateEvent(final IFileSystemAccess2 fsa, final RegularType event) {
    OntologyType _ontologyType = event.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<Attribute> _attributes = event.getAttributes();
        for(final Attribute att : _attributes) {
          String _name = att.getName();
          _builder.append(_name);
          _builder.append(", ");
          _builder.newLineIfNotEmpty();
        }
      }
      String parameters = _builder.toString();
      parameters = parameters.replace("\r\n", "");
      int _length = parameters.length();
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        int _length_1 = parameters.length();
        int _minus = (_length_1 - 2);
        parameters = parameters.substring(0, _minus);
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _size = event.getAttributes().size();
        boolean _greaterThan_1 = (_size > 0);
        if (_greaterThan_1) {
          _builder_1.append("MODULE ");
          String _name_1 = event.getName();
          _builder_1.append(_name_1);
          _builder_1.append("(start, ");
          _builder_1.append(parameters);
          _builder_1.append(")");
          _builder_1.newLineIfNotEmpty();
        } else {
          _builder_1.append("MODULE ");
          String _name_2 = event.getName();
          _builder_1.append(_name_2);
          _builder_1.append("(start)");
          _builder_1.newLineIfNotEmpty();
        }
      }
      _builder_1.append("\t ");
      _builder_1.append("VAR");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("event : Event(start);");
      _builder_1.newLine();
      final String code = _builder_1.toString();
      this.pcDomEvents.add(code);
    } else {
      RegularType _regularType = event.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = event.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(event);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(event.getAttributes());
        StringConcatenation _builder_2 = new StringConcatenation();
        {
          EList<Attribute> _attributes_1 = event.getAttributes();
          for(final Attribute att_1 : _attributes_1) {
            String _generateAssetParameters = this.generateAssetParameters(att_1);
            _builder_2.append(_generateAssetParameters);
            _builder_2.newLineIfNotEmpty();
          }
        }
        {
          for(final Attribute att_2 : parentAttributes) {
            String _generateAssetParameters_1 = this.generateAssetParameters(att_2);
            _builder_2.append(_generateAssetParameters_1);
            _builder_2.newLineIfNotEmpty();
          }
        }
        String parameters_1 = _builder_2.toString();
        parameters_1 = parameters_1.replace("\r\n", "");
        int _length_2 = parameters_1.length();
        int _minus_1 = (_length_2 - 2);
        parameters_1 = parameters_1.substring(0, _minus_1);
        StringConcatenation _builder_3 = new StringConcatenation();
        {
          int _size_1 = allAttributes.size();
          boolean _greaterThan_2 = (_size_1 > 0);
          if (_greaterThan_2) {
            _builder_3.append("MODULE ");
            String _name_3 = event.getName();
            _builder_3.append(_name_3);
            _builder_3.append("(start, ");
            _builder_3.append(parameters_1);
            _builder_3.append(")");
            _builder_3.newLineIfNotEmpty();
            _builder_3.append(" ");
            _builder_3.append("DEFINE");
            _builder_3.newLine();
            {
              EList<Attribute> _attributes_2 = event.getAttributes();
              for(final Attribute attribute : _attributes_2) {
                _builder_3.append("\t\t");
                String _generateAssetAttributes = this.generateAssetAttributes(attribute);
                _builder_3.append(_generateAssetAttributes, "\t\t");
                _builder_3.newLineIfNotEmpty();
              }
            }
          } else {
            _builder_3.append("MODULE ");
            String _name_4 = event.getName();
            _builder_3.append(_name_4);
            _builder_3.append("(start)");
            _builder_3.newLineIfNotEmpty();
          }
        }
        _builder_3.append("\t ");
        _builder_3.append("VAR");
        _builder_3.newLine();
        _builder_3.append("\t\t\t");
        _builder_3.append("event : ");
        String _name_5 = parentType.getName();
        _builder_3.append(_name_5, "\t\t\t");
        _builder_3.append("(start, ");
        final Function1<Attribute, String> _function = (Attribute a) -> {
          return a.getName();
        };
        String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function), ",");
        _builder_3.append(_join, "\t\t\t");
        _builder_3.append(");");
        _builder_3.newLineIfNotEmpty();
        final String code_1 = _builder_3.toString();
        this.pcDomEvents.add(code_1);
      }
    }
  }

  public void generateRole(final IFileSystemAccess2 fsa, final RegularType role) {
    OntologyType _ontologyType = role.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<Attribute, String> _function = (Attribute a) -> {
          return a.getName();
        };
        int _length = ((Object[])Conversions.unwrapArray(ListExtensions.<Attribute, String>map(role.getAttributes(), _function), Object.class)).length;
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("MODULE ");
          String _name = role.getName();
          _builder.append(_name);
          _builder.append("(party, ");
          final Function1<Attribute, String> _function_1 = (Attribute a) -> {
            return a.getName();
          };
          String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(role.getAttributes(), _function_1), ",");
          _builder.append(_join);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("MODULE ");
          String _name_1 = role.getName();
          _builder.append(_name_1);
          _builder.append("(party)");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        int _length_1 = ((Object[])Conversions.unwrapArray(role.getAttributes(), Object.class)).length;
        boolean _greaterThan_1 = (_length_1 > 0);
        if (_greaterThan_1) {
          _builder.append("DEFINE");
          _builder.newLine();
          {
            EList<Attribute> _attributes = role.getAttributes();
            for(final Attribute attribute : _attributes) {
              _builder.append("\t\t\t\t\t\t");
              _builder.append("_");
              String _name_2 = attribute.getName();
              _builder.append(_name_2, "\t\t\t\t\t\t");
              _builder.append(" := ");
              String _name_3 = attribute.getName();
              _builder.append(_name_3, "\t\t\t\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t ");
      _builder.append("VAR");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("role : Role(party);");
      _builder.newLine();
      final String code = _builder.toString();
      this.pcRoles.add(code);
    } else {
      RegularType _regularType = role.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = role.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(role);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(role.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          final Function1<Attribute, String> _function_2 = (Attribute a) -> {
            return a.getName();
          };
          int _length_2 = ((Object[])Conversions.unwrapArray(ListExtensions.<Attribute, String>map(allAttributes, _function_2), Object.class)).length;
          boolean _greaterThan_2 = (_length_2 > 0);
          if (_greaterThan_2) {
            _builder_1.append("MODULE ");
            String _name_4 = role.getName();
            _builder_1.append(_name_4);
            _builder_1.append("(party, ");
            final Function1<Attribute, String> _function_3 = (Attribute a) -> {
              return a.getName();
            };
            String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_3), ",");
            _builder_1.append(_join_1);
            _builder_1.append(")");
            _builder_1.newLineIfNotEmpty();
          } else {
            _builder_1.append("MODULE ");
            String _name_5 = role.getName();
            _builder_1.append(_name_5);
            _builder_1.append("(party)");
            _builder_1.newLineIfNotEmpty();
          }
        }
        {
          int _length_3 = ((Object[])Conversions.unwrapArray(role.getAttributes(), Object.class)).length;
          boolean _greaterThan_3 = (_length_3 > 0);
          if (_greaterThan_3) {
            _builder_1.append("DEFINE");
            _builder_1.newLine();
            {
              EList<Attribute> _attributes_1 = role.getAttributes();
              for(final Attribute attribute_1 : _attributes_1) {
                _builder_1.append("\t\t\t\t\t\t");
                _builder_1.append("_");
                String _name_6 = attribute_1.getName();
                _builder_1.append(_name_6, "\t\t\t\t\t\t");
                _builder_1.append(" := ");
                String _name_7 = attribute_1.getName();
                _builder_1.append(_name_7, "\t\t\t\t\t\t");
                _builder_1.append(";");
                _builder_1.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder_1.append("\t\t");
        _builder_1.append("VAR");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("role : ");
        String _name_8 = parentType.getName();
        _builder_1.append(_name_8, "\t\t\t");
        _builder_1.append("(party, ");
        final Function1<Attribute, String> _function_4 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_4), ",");
        _builder_1.append(_join_2, "\t\t\t");
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        this.pcRoles.add(code_1);
      }
    }
  }

  public String generateDomainModules() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      for(final String role : this.pcRoles) {
        _builder.append(role);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      for(final String asset : this.pcAssets) {
        _builder.append(asset);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      for(final String event : this.pcDomEvents) {
        _builder.append(event);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    final String code = _builder.toString();
    return code;
  }

  public String generateConstants() {
    final ArrayList<String> norms = new ArrayList<String>();
    for (final Obligation obligation : this.obligations) {
      String _name = obligation.getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      norms.add(_plus_1);
    }
    for (final Power power : this.powers) {
      String _name_1 = power.getName();
      String _plus_2 = ("\"" + _name_1);
      String _plus_3 = (_plus_2 + "\"");
      norms.add(_plus_3);
    }
    int _size = this.pcEnumerations.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      String _join = IterableExtensions.join(this.pcEnumerations, ",");
      String _plus_4 = (_join + ",");
      String _join_1 = String.join(",", norms);
      String _plus_5 = (_plus_4 + _join_1);
      return (_plus_5 + ";");
    } else {
      String _join_2 = String.join(",", norms);
      return (_join_2 + ";");
    }
  }

  public String generateRoleInstances() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Set<Map.Entry<String, Pair<String, String>>> _entrySet = this.roleInstances.entrySet();
      for(final Map.Entry<String, Pair<String, String>> entry : _entrySet) {
        String _key = entry.getKey();
        _builder.append(_key);
        _builder.append(" : ");
        String _key_1 = entry.getValue().getKey();
        _builder.append(_key_1);
        _builder.append("(");
        String _value = entry.getValue().getValue();
        _builder.append(_value);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    final String code = _builder.toString();
    return code;
  }

  /**
   * Description: convert Symboleos contract concept to SymboleoPCs module
   * Principle: 2
   */
  public void compileContract(final IFileSystemAccess2 fsa, final Model model) {
    String cntPrecondition = this.generateContractPreconditionSituation(model);
    String cntTermination = this.generateContractTerminationSituation(model);
    String cntSuspension = this.generateContractSuspensionSituation(model);
    String cntResumption = this.generateContractResumptionSituation(model);
    Map<String, String> oblsTermination = this.generateObligationsTerminationSituation(model);
    Map<String, String> oblsSuspension = this.generateObligationsSuspensionSituation(model);
    Map<String, String> oblsResumption = this.generateObligationsResumptionSituation(model);
    Map<String, String> oblsDiscard = this.generateObligationsDischargeSituation(model);
    Map<String, String> oblsViolated = this.generateObligationViolatedSituation(model);
    Map<String, String> oblsExpired = this.generateObligationExpiredSituation(model);
    Map<String, String> powsExpired = this.generatePowerExpiredSituation(model);
    Map<String, String> powsExerted = this.generatePowerExertedSituation(model);
    Map<String, String> antecedents = this.generateAntecedentsSituation(model);
    Map<String, String> consequents = this.generateConsequentsSituation(model);
    Map<String, String> triggers = this.generateTriggersSituation(model);
    StringConcatenation _builder = new StringConcatenation();
    String _generateStaticModules = this.generateStaticModules();
    _builder.append(_generateStaticModules);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- CONTRACT DEPENDENT CONCEPTS");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    String _generateDomainModules = this.generateDomainModules();
    _builder.append(_generateDomainModules);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("-- CONTRACT");
    _builder.newLine();
    _builder.append("--------------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("MODULE ");
    String _contractName = model.getContractName();
    _builder.append(_contractName);
    _builder.append(" (");
    String _join = IterableExtensions.join(this.pcParameters, ", ");
    _builder.append(_join);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CONSTANTS");
    _builder.newLine();
    _builder.append("\t");
    String _generateConstants = this.generateConstants();
    _builder.append(_generateConstants, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("\t\t");
    String _compileDeclarationVariables = this.compileDeclarationVariables(model);
    _builder.append(_compileDeclarationVariables, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt_succ_Termination : Situation((cnt.state=inEffect)");
    _builder.newLine();
    {
      for(final Obligation obligation : this.obligations) {
        {
          boolean _contains = this.pcSurvivingObligations.contains(obligation.getName());
          boolean _not = (!_contains);
          if (_not) {
            _builder.append("\t\t");
            _builder.append("& !(");
            String _name = obligation.getName();
            _builder.append(_name, "\t\t");
            _builder.append("._active)");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-- SITUATIONS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    String _situations = this.getSituations();
    _builder.append(_situations, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cnt: Contract(TRUE, TRUE, ");
    _builder.append(cntTermination, "\t\t");
    _builder.append(", ");
    _builder.append(cntSuspension, "\t\t");
    _builder.append(", ");
    _builder.append(cntResumption, "\t\t");
    _builder.append(", FALSE, FALSE, cnt_succ_Termination._holds);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-- OBLIGATIONS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------\t\t");
    _builder.newLine();
    {
      for(final Obligation obligation_1 : this.obligations) {
        _builder.append("\t\t");
        String _xifexpression = null;
        String _get = antecedents.get(obligation_1.getName());
        boolean _tripleNotEquals = (_get != null);
        if (_tripleNotEquals) {
          _xifexpression = antecedents.get(obligation_1.getName());
        } else {
          _xifexpression = "TRUE";
        }
        final String antecedent = _xifexpression;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String consequent = consequents.get(obligation_1.getName());
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_1 = null;
        String _get_1 = triggers.get(obligation_1.getName());
        boolean _tripleNotEquals_1 = (_get_1 != null);
        if (_tripleNotEquals_1) {
          _xifexpression_1 = triggers.get(obligation_1.getName());
        } else {
          _xifexpression_1 = "TRUE";
        }
        final String trigger = _xifexpression_1;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_2 = null;
        String _get_2 = oblsTermination.get(obligation_1.getName());
        boolean _tripleNotEquals_2 = (_get_2 != null);
        if (_tripleNotEquals_2) {
          _xifexpression_2 = oblsTermination.get(obligation_1.getName());
        } else {
          _xifexpression_2 = "FALSE";
        }
        final String oblTerm = _xifexpression_2;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_3 = null;
        String _get_3 = oblsSuspension.get(obligation_1.getName());
        boolean _tripleNotEquals_3 = (_get_3 != null);
        if (_tripleNotEquals_3) {
          _xifexpression_3 = oblsSuspension.get(obligation_1.getName());
        } else {
          _xifexpression_3 = "FALSE";
        }
        final String oblSus = _xifexpression_3;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_4 = null;
        String _get_4 = oblsResumption.get(obligation_1.getName());
        boolean _tripleNotEquals_4 = (_get_4 != null);
        if (_tripleNotEquals_4) {
          _xifexpression_4 = oblsResumption.get(obligation_1.getName());
        } else {
          _xifexpression_4 = "FALSE";
        }
        final String oblRes = _xifexpression_4;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_5 = null;
        String _get_5 = oblsDiscard.get(obligation_1.getName());
        boolean _tripleNotEquals_5 = (_get_5 != null);
        if (_tripleNotEquals_5) {
          _xifexpression_5 = oblsDiscard.get(obligation_1.getName());
        } else {
          _xifexpression_5 = "FALSE";
        }
        final String oblDisc = _xifexpression_5;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_6 = null;
        String _get_6 = oblsViolated.get(obligation_1.getName());
        boolean _tripleNotEquals_6 = (_get_6 != null);
        if (_tripleNotEquals_6) {
          _xifexpression_6 = oblsViolated.get(obligation_1.getName());
        } else {
          _xifexpression_6 = "FALSE";
        }
        final String oblViol = _xifexpression_6;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_7 = null;
        String _get_7 = oblsExpired.get(obligation_1.getName());
        boolean _tripleNotEquals_7 = (_get_7 != null);
        if (_tripleNotEquals_7) {
          _xifexpression_7 = oblsExpired.get(obligation_1.getName());
        } else {
          _xifexpression_7 = "FALSE";
        }
        final String oblExp = _xifexpression_7;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String oblAct = "FALSE";
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_8 = null;
        boolean _contains_1 = this.pcSurvivingObligations.contains(obligation_1.getName());
        if (_contains_1) {
          _xifexpression_8 = "TRUE";
        } else {
          _xifexpression_8 = "FALSE";
        }
        final String isSurviving = _xifexpression_8;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String oblName = obligation_1.getName();
        _builder.append("\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(oblName, "\t\t");
        _builder.append(" : Obligation(\"");
        _builder.append(oblName, "\t\t");
        _builder.append("\", ");
        _builder.append(isSurviving, "\t\t");
        _builder.append(", cnt._o_activated, ");
        _builder.append(cntTermination, "\t\t");
        _builder.append(", ");
        _builder.append(consequent, "\t\t");
        _builder.append(", ");
        _builder.append(trigger, "\t\t");
        _builder.append(", ");
        _builder.append(oblViol, "\t\t");
        _builder.append(", ");
        _builder.append(oblAct, "\t\t");
        _builder.append(", ");
        _builder.append(oblExp, "\t\t");
        _builder.append(", ");
        _builder.append(oblSus, "\t\t");
        _builder.append(", ");
        _builder.append(cntSuspension, "\t\t");
        _builder.append(", ");
        _builder.append(oblTerm, "\t\t");
        _builder.append(", ");
        _builder.append(oblRes, "\t\t");
        _builder.append(", ");
        _builder.append(cntResumption, "\t\t");
        _builder.append(", ");
        _builder.append(oblDisc, "\t\t");
        _builder.append(", ");
        _builder.append(antecedent, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-- POWERS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    {
      for(final Power power : this.powers) {
        _builder.append("\t\t");
        String _xifexpression_9 = null;
        String _get_8 = antecedents.get(power.getName());
        boolean _tripleNotEquals_8 = (_get_8 != null);
        if (_tripleNotEquals_8) {
          _xifexpression_9 = antecedents.get(power.getName());
        } else {
          _xifexpression_9 = "TRUE";
        }
        final String antecedent_1 = _xifexpression_9;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_10 = null;
        String _get_9 = triggers.get(power.getName());
        boolean _tripleNotEquals_9 = (_get_9 != null);
        if (_tripleNotEquals_9) {
          _xifexpression_10 = triggers.get(power.getName());
        } else {
          _xifexpression_10 = "TRUE";
        }
        final String trigger_1 = _xifexpression_10;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String powAct = "FALSE";
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String powSus = "FALSE";
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String powTerm = "FALSE";
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String powRes = "FALSE";
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        final String powName = power.getName();
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_11 = null;
        String _get_10 = powsExerted.get(power.getName());
        boolean _tripleNotEquals_10 = (_get_10 != null);
        if (_tripleNotEquals_10) {
          _xifexpression_11 = powsExerted.get(power.getName());
        } else {
          _xifexpression_11 = "FALSE";
        }
        final String powExe = _xifexpression_11;
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _xifexpression_12 = null;
        String _get_11 = powsExpired.get(power.getName());
        boolean _tripleNotEquals_11 = (_get_11 != null);
        if (_tripleNotEquals_11) {
          _xifexpression_12 = powsExpired.get(power.getName());
        } else {
          _xifexpression_12 = "FALSE";
        }
        final String powExp = _xifexpression_12;
        _builder.append("\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _name_1 = power.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" : Power(\"");
        _builder.append(powName, "\t\t");
        _builder.append("\", cnt._o_activated, ");
        _builder.append(trigger_1, "\t\t");
        _builder.append(", ");
        _builder.append(powAct, "\t\t");
        _builder.append(", ");
        _builder.append(powExp, "\t\t");
        _builder.append(", ");
        _builder.append(powSus, "\t\t");
        _builder.append(", ");
        _builder.append(cntSuspension, "\t\t");
        _builder.append(", ");
        _builder.append(powTerm, "\t\t");
        _builder.append(", ");
        _builder.append(powExe, "\t\t");
        _builder.append(", ");
        _builder.append(powRes, "\t\t");
        _builder.append(", ");
        _builder.append(cntResumption, "\t\t");
        _builder.append(", ");
        _builder.append(antecedent_1, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-- PARTIES");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    String _compileParties = this.compileParties();
    _builder.append(_compileParties, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-- CONSTRAINTS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("--------------");
    _builder.newLine();
    _builder.append("\t\t");
    String _compileConstraints = this.compileConstraints(cntPrecondition);
    _builder.append(_compileConstraints, "\t\t");
    _builder.newLineIfNotEmpty();
    final String code = _builder.toString();
    String _contractName_1 = model.getContractName();
    String _plus = ("./domain/contracts/" + _contractName_1);
    String _plus_1 = (_plus + ".smv");
    fsa.generateFile(_plus_1, code);
  }

  public void compileDomainTypes(final IFileSystemAccess2 fsa, final List<DomainType> domainTypes) {
    for (final RegularType asset : this.assets) {
      this.generateAsset(fsa, asset);
    }
    for (final RegularType event : this.events) {
      this.generateEvent(fsa, event);
    }
    for (final RegularType role : this.roles) {
      this.generateRole(fsa, role);
    }
    for (final Enumeration enumeration : this.enumerations) {
      this.generateEnumeration(enumeration);
    }
  }

  public String generateAssetAttributes(final Attribute att) {
    StringConcatenation _builder = new StringConcatenation();
    boolean done = false;
    _builder.newLineIfNotEmpty();
    {
      DomainType _domainType = att.getDomainType();
      if ((_domainType instanceof RegularType)) {
        final RegularType base = this.getBaseType(att.getDomainType());
        _builder.newLineIfNotEmpty();
        {
          if ((base != null)) {
            {
              String _name = base.getOntologyType().getName();
              boolean _equals = Objects.equal(_name, "Asset");
              if (_equals) {
                final String astname = base.getName();
                _builder.newLineIfNotEmpty();
                {
                  for(final RegularType asset : this.assets) {
                    {
                      String _name_1 = asset.getName();
                      boolean _equals_1 = Objects.equal(_name_1, astname);
                      if (_equals_1) {
                        Object _xblockexpression = null;
                        {
                          done = true;
                          _xblockexpression = null;
                        }
                        _builder.append(_xblockexpression);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      if ((!done)) {
        _builder.append("_");
        String _name_2 = att.getName();
        _builder.append(_name_2);
        _builder.append(" := ");
        String _name_3 = att.getName();
        _builder.append(_name_3);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    final String code = _builder.toString();
    return code;
  }

  public String generateAssetParameters(final Attribute att) {
    StringConcatenation _builder = new StringConcatenation();
    boolean done = false;
    _builder.newLineIfNotEmpty();
    {
      DomainType _domainType = att.getDomainType();
      if ((_domainType instanceof RegularType)) {
        final RegularType base = this.getBaseType(att.getDomainType());
        _builder.newLineIfNotEmpty();
        {
          if ((base != null)) {
            {
              String _name = base.getOntologyType().getName();
              boolean _equals = Objects.equal(_name, "Asset");
              if (_equals) {
                final String astname = base.getName();
                _builder.newLineIfNotEmpty();
                {
                  for(final RegularType asset : this.assets) {
                    {
                      String _name_1 = asset.getName();
                      boolean _equals_1 = Objects.equal(_name_1, astname);
                      if (_equals_1) {
                        {
                          EList<Attribute> _attributes = asset.getAttributes();
                          for(final Attribute embatt : _attributes) {
                            String parentAst = this.generateAssetParameters(embatt);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        Object _xblockexpression = null;
                        {
                          done = true;
                          _xblockexpression = null;
                        }
                        _builder.append(_xblockexpression);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      if ((!done)) {
        String _name_2 = att.getName();
        _builder.append(_name_2);
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    final String code = _builder.toString();
    return code;
  }

  public void generateAsset(final IFileSystemAccess2 fsa, final RegularType asset) {
    OntologyType _ontologyType = asset.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<Attribute> _attributes = asset.getAttributes();
        for(final Attribute att : _attributes) {
          String _name = att.getName();
          _builder.append(_name);
          _builder.append(", ");
          _builder.newLineIfNotEmpty();
        }
      }
      String parameters = _builder.toString();
      parameters = parameters.replace("\r\n", "");
      int _length = parameters.length();
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        int _length_1 = parameters.length();
        int _minus = (_length_1 - 2);
        parameters = parameters.substring(0, _minus);
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        int _size = asset.getAttributes().size();
        boolean _greaterThan_1 = (_size > 0);
        if (_greaterThan_1) {
          _builder_1.append("MODULE ");
          String _name_1 = asset.getName();
          _builder_1.append(_name_1);
          _builder_1.append(" (");
          _builder_1.append(parameters);
          _builder_1.append(")");
          _builder_1.newLineIfNotEmpty();
        } else {
          _builder_1.append("MODULE ");
          String _name_2 = asset.getName();
          _builder_1.append(_name_2);
          _builder_1.append(" ()\t");
          _builder_1.newLineIfNotEmpty();
        }
      }
      _builder_1.append("\t ");
      _builder_1.append("VAR");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("asset:Asset(owner);");
      _builder_1.newLine();
      final String code = _builder_1.toString();
      this.pcAssets.add(code);
    } else {
      RegularType _regularType = asset.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = asset.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(asset);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(asset.getAttributes());
        String parameters_1 = "";
        EList<Attribute> _attributes_1 = asset.getAttributes();
        for (final Attribute att_1 : _attributes_1) {
          {
            String param = this.generateAssetParameters(att_1);
            param = param.replace("\r\n", "");
            int _length_2 = param.length();
            boolean _greaterThan_2 = (_length_2 > 1);
            if (_greaterThan_2) {
              int _length_3 = param.length();
              int _minus_1 = (_length_3 - 2);
              param = param.substring(0, _minus_1);
              String _parameters = parameters_1;
              parameters_1 = (_parameters + param);
            }
          }
        }
        String parentParams = "";
        for (final Attribute att_2 : parentAttributes) {
          {
            String param = this.generateAssetParameters(att_2);
            param = param.replace("\r\n", "");
            int _length_2 = param.length();
            boolean _greaterThan_2 = (_length_2 > 1);
            if (_greaterThan_2) {
              int _length_3 = param.length();
              int _minus_1 = (_length_3 - 2);
              param = param.substring(0, _minus_1);
              int _length_4 = parameters_1.length();
              boolean _equals = (_length_4 == 0);
              if (_equals) {
                String _parameters = parameters_1;
                parameters_1 = (_parameters + param);
              } else {
                String _parameters_1 = parameters_1;
                parameters_1 = (_parameters_1 + (", " + param));
              }
              int _length_5 = parentParams.length();
              boolean _equals_1 = (_length_5 == 0);
              if (_equals_1) {
                String _parentParams = parentParams;
                parentParams = (_parentParams + param);
              } else {
                String _parentParams_1 = parentParams;
                parentParams = (_parentParams_1 + (", " + param));
              }
            }
          }
        }
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("MODULE ");
        String _name_3 = asset.getName();
        _builder_2.append(_name_3);
        _builder_2.append(" (");
        _builder_2.append(parameters_1);
        _builder_2.append(")");
        _builder_2.newLineIfNotEmpty();
        {
          int _size_1 = asset.getAttributes().size();
          boolean _greaterThan_2 = (_size_1 > 0);
          if (_greaterThan_2) {
            _builder_2.append("DEFINE ");
            _builder_2.newLine();
            {
              EList<Attribute> _attributes_2 = asset.getAttributes();
              for(final Attribute attribute : _attributes_2) {
                _builder_2.append("\t\t\t\t\t\t");
                String _generateAssetAttributes = this.generateAssetAttributes(attribute);
                _builder_2.append(_generateAssetAttributes, "\t\t\t\t\t\t");
                _builder_2.newLineIfNotEmpty();
              }
            }
            {
              for(final Attribute attribute_1 : parentAttributes) {
                {
                  boolean _equals = attribute_1.getName().equals("owner");
                  boolean _not = (!_equals);
                  if (_not) {
                    _builder_2.append("\t\t\t\t\t\t");
                    String _generateAssetAttributes_1 = this.generateAssetAttributes(attribute_1);
                    _builder_2.append(_generateAssetAttributes_1, "\t\t\t\t\t\t");
                    _builder_2.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder_2.append(" ");
        _builder_2.append("VAR");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("asset:");
        String _name_4 = parentType.getName();
        _builder_2.append(_name_4, "\t\t");
        _builder_2.append("(");
        _builder_2.append(parentParams, "\t\t");
        _builder_2.append(");");
        _builder_2.newLineIfNotEmpty();
        final String code_1 = _builder_2.toString();
        this.pcAssets.add(code_1);
      }
    }
  }

  public String generateEventInitSituation(final Model model, final String eventName) {
    List<String> situations = new ArrayList<String>();
    String situation = "";
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        List<PAtomPredicate> propositions = this.obligationAntecedentEvents.get(obligation);
        if ((propositions != null)) {
          for (final PAtomPredicate p : propositions) {
            {
              String ev = this.getEvent(p.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                String _name = obligation.getName();
                String _plus = (_name + ".state=create");
                situations.add(_plus);
              }
            }
          }
        }
        propositions = this.obligationConsequentEvents.get(obligation);
        if ((propositions != null)) {
          for (final PAtomPredicate p_1 : propositions) {
            {
              String ev = this.getEvent(p_1.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                String _name = obligation.getName();
                String _plus = (_name + ".state=inEffect");
                situations.add(_plus);
              }
            }
          }
        }
        propositions = this.obligationTriggerEvents.get(obligation);
        if ((propositions != null)) {
          for (final PAtomPredicate p_2 : propositions) {
            {
              String ev = this.getEvent(p_2.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                situations.add("cnt.state=inEffect");
              }
            }
          }
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        List<PAtomPredicate> propositions = this.obligationAntecedentEvents.get(obligation_1);
        if ((propositions != null)) {
          for (final PAtomPredicate p : propositions) {
            {
              String ev = this.getEvent(p.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                String _name = obligation_1.getName();
                String _plus = (_name + ".state=create");
                situations.add(_plus);
              }
            }
          }
        }
        propositions = this.obligationConsequentEvents.get(obligation_1);
        if ((propositions != null)) {
          for (final PAtomPredicate p_1 : propositions) {
            {
              String ev = this.getEvent(p_1.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                String _name = obligation_1.getName();
                String _plus = (_name + ".state=inEffect");
                situations.add(_plus);
              }
            }
          }
        }
        propositions = this.obligationTriggerEvents.get(obligation_1);
        if ((propositions != null)) {
          for (final PAtomPredicate p_2 : propositions) {
            {
              String ev = this.getEvent(p_2.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                situations.add("cnt.state=inEffect");
              }
            }
          }
        }
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        List<PAtomPredicate> propositions = this.powerAntecedentEvents.get(power);
        if ((propositions != null)) {
          for (final PAtomPredicate p : propositions) {
            {
              String ev = this.getEvent(p.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                String _name = power.getName();
                String _plus = (_name + ".state=create");
                situations.add(_plus);
              }
            }
          }
        }
        propositions = this.powerTriggerEvents.get(power);
        if ((propositions != null)) {
          for (final PAtomPredicate p_1 : propositions) {
            {
              String ev = this.getEvent(p_1.getPredicateFunction());
              boolean _equals = ev.equals(eventName);
              if (_equals) {
                situations.add("cnt.state=inEffect");
              }
            }
          }
        }
      }
    }
    for (final String s : situations) {
      if ((situation == "")) {
        situation = s;
      } else {
        String _situation = situation;
        situation = (_situation + (" | " + s));
      }
    }
    return situation;
  }

  public void addDeclarationVariables(final Model model) {
    EList<Variable> _variables = model.getVariables();
    for (final Variable variable : _variables) {
      {
        String situation = this.generateEventInitSituation(model, variable.getName());
        ArrayList<Pair<String, String>> assgs = new ArrayList<Pair<String, String>>();
        RegularType _type = variable.getType();
        if ((_type instanceof RegularType)) {
          EList<Assignment> _attributes = variable.getAttributes();
          for (final Assignment assignment : _attributes) {
            if ((assignment instanceof AssignExpression)) {
              String _name = ((AssignExpression)assignment).getName();
              String _generateExpressionString = this.generateExpressionString(((AssignExpression)assignment).getValue(), null);
              Pair<String, String> _pair = new Pair<String, String>(_name, _generateExpressionString);
              assgs.add(_pair);
            }
          }
        }
        this.addVariable(variable.getName(), situation, variable.getType().getName(), assgs);
      }
    }
  }

  public String compileDeclarationVariables(final Model model) {
    this.addDeclarationVariables(model);
    String code = "";
    for (final DeclarationVariable variable : this.pcVariables) {
      {
        String params = "";
        if ((variable.starter != null)) {
          String _params = params;
          params = (_params + variable.starter);
        }
        if ((variable.parameters != null)) {
          for (final Pair<String, String> param : variable.parameters) {
            int _length = params.length();
            boolean _greaterThan = (_length > 0);
            if (_greaterThan) {
              String _params_1 = params;
              String _value = param.getValue();
              String _plus = (", " + _value);
              params = (_params_1 + _plus);
            } else {
              String _params_2 = params;
              String _value_1 = param.getValue();
              params = (_params_2 + _value_1);
            }
          }
        }
        String _code = code;
        code = (_code + (((((variable.name + " :") + variable.type) + "(") + params) + ");\n\n"));
      }
    }
    return code;
  }

  public String compileConstraints(final String cntPrecondition) {
    for (int i = 0; (i < this.predicates.size()); i++) {
      {
        for (int j = (i + 1); (j < this.predicates.size()); j++) {
          {
            if (((((Objects.equal(this.predicates.get(i).predicate, predicateType.SHAPPENSBEFORE) || Objects.equal(this.predicates.get(i).predicate, predicateType.WHAPPENSBEFORE)) && Objects.equal(this.predicates.get(j).predicate, predicateType.HAPPENSAFTER)) && 
              Objects.equal(this.predicates.get(i).time1.type, Tpoint.Type.VARIABLE)) && Objects.equal(this.predicates.get(j).time1.type, Tpoint.Type.VARIABLE))) {
              this.pcConstraints.add(((((((((((("(" + this.predicates.get(i).time1.time) + " < ") + this.predicates.get(j).time1.time) + " & ") + 
                this.predicates.get(j).event) + ".state = active ->") + this.predicates.get(i).event) + "._happened | ") + this.predicates.get(i).event) + "._expired") + ")"));
            }
            if ((((Objects.equal(this.predicates.get(i).predicate, predicateType.HAPPENSAFTER) && (Objects.equal(this.predicates.get(j).predicate, predicateType.SHAPPENSBEFORE) || Objects.equal(this.predicates.get(j).predicate, predicateType.WHAPPENSBEFORE))) && 
              Objects.equal(this.predicates.get(i).time1.type, Tpoint.Type.VARIABLE)) && Objects.equal(this.predicates.get(j).time1.type, Tpoint.Type.VARIABLE))) {
              this.pcConstraints.add(((((((((((("(" + this.predicates.get(j).time1.time) + " < ") + this.predicates.get(i).time1.time) + " & ") + 
                this.predicates.get(i).event) + ".state = active ->") + this.predicates.get(j).event) + "._happened | ") + this.predicates.get(j).event) + "._expired") + ")"));
            }
            if (((((Objects.equal(this.predicates.get(i).predicate, predicateType.SHAPPENSBEFORE) || Objects.equal(this.predicates.get(i).predicate, predicateType.WHAPPENSBEFORE)) && Objects.equal(this.predicates.get(j).predicate, predicateType.HAPPENSWITHIN)) && 
              Objects.equal(this.predicates.get(i).time1.type, Tpoint.Type.VARIABLE)) && Objects.equal(this.predicates.get(j).time1.type, Tpoint.Type.VARIABLE))) {
              this.pcConstraints.add(((((((((((("(" + this.predicates.get(i).time1.time) + " < ") + this.predicates.get(j).time1.time) + " & ") + 
                this.predicates.get(j).event) + ".state = active ->") + this.predicates.get(i).event) + "._happened | ") + this.predicates.get(i).event) + "._expired") + ")"));
            }
            if ((((Objects.equal(this.predicates.get(i).predicate, predicateType.HAPPENSWITHIN) && (Objects.equal(this.predicates.get(j).predicate, predicateType.SHAPPENSBEFORE) || Objects.equal(this.predicates.get(j).predicate, predicateType.WHAPPENSBEFORE))) && 
              Objects.equal(this.predicates.get(i).time1.type, Tpoint.Type.VARIABLE)) && Objects.equal(this.predicates.get(j).time1.type, Tpoint.Type.VARIABLE))) {
              this.pcConstraints.add(((((((((((("(" + this.predicates.get(j).time1.time) + " < ") + this.predicates.get(i).time1.time) + " & ") + 
                this.predicates.get(i).event) + ".state = active ->") + this.predicates.get(j).event) + "._happened | ") + this.predicates.get(j).event) + "._expired") + ")"));
            }
          }
        }
        if (((Objects.equal(this.predicates.get(i).predicate, predicateType.SHAPPENSBEFORE) || Objects.equal(this.predicates.get(i).predicate, predicateType.WHAPPENSBEFORE)) && Objects.equal(this.predicates.get(i).time1.type, Tpoint.Type.EVENT))) {
          SymboleoPredicate _get = this.predicates.get(i);
          String _plus = ((("(" + this.predicates.get(i).time1.time) + "._happened ->") + _get);
          String _plus_1 = (_plus + "._true");
          String _plus_2 = (_plus_1 + ")");
          this.pcConstraints.add(_plus_2);
        }
      }
    }
    String econstr = "";
    boolean first = true;
    for (final Proposition cntr : this.constraints) {
      {
        String constValue = this.generatePropositionString(null, null, null, cntr);
        if ((constValue != null)) {
          if (first) {
            String _econstr = econstr;
            econstr = (_econstr + constValue);
            first = false;
          } else {
            String _econstr_1 = econstr;
            econstr = (_econstr_1 + ("&" + constValue));
          }
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String _xifexpression = null;
    int _size = this.pcConstraints.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _xifexpression = IterableExtensions.join(this.pcConstraints, " & ");
    } else {
      _xifexpression = "";
    }
    _builder.append(_xifexpression);
    final String iconstr = _builder.toString();
    String fullconstr = "";
    if ((((cntPrecondition.length() > 0) || (econstr.length() > 0)) || (iconstr.length() > 0))) {
      String _fullconstr = fullconstr;
      fullconstr = (_fullconstr + "INVAR \n\t");
      int _length = cntPrecondition.length();
      boolean _greaterThan_1 = (_length > 0);
      if (_greaterThan_1) {
        String _fullconstr_1 = fullconstr;
        fullconstr = (_fullconstr_1 + cntPrecondition);
        int _length_1 = econstr.length();
        boolean _greaterThan_2 = (_length_1 > 0);
        if (_greaterThan_2) {
          String _fullconstr_2 = fullconstr;
          fullconstr = (_fullconstr_2 + (" & " + econstr));
        }
        int _length_2 = iconstr.length();
        boolean _greaterThan_3 = (_length_2 > 0);
        if (_greaterThan_3) {
          String _fullconstr_3 = fullconstr;
          fullconstr = (_fullconstr_3 + (" & " + iconstr));
        }
      } else {
        int _length_3 = econstr.length();
        boolean _greaterThan_4 = (_length_3 > 0);
        if (_greaterThan_4) {
          String _fullconstr_4 = fullconstr;
          fullconstr = (_fullconstr_4 + econstr);
          int _length_4 = iconstr.length();
          boolean _greaterThan_5 = (_length_4 > 0);
          if (_greaterThan_5) {
            String _fullconstr_5 = fullconstr;
            fullconstr = (_fullconstr_5 + (" & " + iconstr));
          }
        } else {
          String _fullconstr_6 = fullconstr;
          fullconstr = (_fullconstr_6 + iconstr);
        }
      }
    }
    String _xifexpression_1 = null;
    int _length_5 = fullconstr.length();
    boolean _greaterThan_6 = (_length_5 > 0);
    if (_greaterThan_6) {
      _xifexpression_1 = (fullconstr + ";");
    } else {
      _xifexpression_1 = fullconstr;
    }
    fullconstr = _xifexpression_1;
    return fullconstr;
  }

  public String compileParties() {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Obligation obligation : this.obligations) {
        String _name = obligation.getName();
        _builder.append(_name);
        _builder.append("_debtor : Party(");
        String _name_1 = obligation.getName();
        _builder.append(_name_1);
        _builder.append("._name, ");
        String _generateDotExpressionString = SymboleoPCGenerator.generateDotExpressionString(obligation.getDebtor(), null);
        _builder.append(_generateDotExpressionString);
        _builder.append(".party, FALSE, TRUE, FALSE, FALSE, FALSE, TRUE);");
        _builder.newLineIfNotEmpty();
        String _name_2 = obligation.getName();
        _builder.append(_name_2);
        _builder.append("_creditor : Party(");
        String _name_3 = obligation.getName();
        _builder.append(_name_3);
        _builder.append("._name, ");
        String _generateDotExpressionString_1 = SymboleoPCGenerator.generateDotExpressionString(obligation.getCreditor(), null);
        _builder.append(_generateDotExpressionString_1);
        _builder.append(".party, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      for(final Power power : this.powers) {
        String _name_4 = power.getName();
        _builder.append(_name_4);
        _builder.append("_debtor : Party(");
        String _name_5 = power.getName();
        _builder.append(_name_5);
        _builder.append("._name, ");
        String _generateDotExpressionString_2 = SymboleoPCGenerator.generateDotExpressionString(power.getDebtor(), null);
        _builder.append(_generateDotExpressionString_2);
        _builder.append(".party, FALSE, TRUE, FALSE, FALSE, FALSE, TRUE);");
        _builder.newLineIfNotEmpty();
        String _name_6 = power.getName();
        _builder.append(_name_6);
        _builder.append("_creditor : Party(");
        String _name_7 = power.getName();
        _builder.append(_name_7);
        _builder.append("._name, ");
        String _generateDotExpressionString_3 = SymboleoPCGenerator.generateDotExpressionString(power.getCreditor(), null);
        _builder.append(_generateDotExpressionString_3);
        _builder.append(".party, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    final String code = _builder.toString();
    return code;
  }

  public String generateAssetProblemParameters(final Attribute att) {
    StringConcatenation _builder = new StringConcatenation();
    boolean done = false;
    _builder.newLineIfNotEmpty();
    {
      DomainType _domainType = att.getDomainType();
      if ((_domainType instanceof RegularType)) {
        final RegularType base = this.getBaseType(att.getDomainType());
        _builder.newLineIfNotEmpty();
        {
          if ((base != null)) {
            {
              String _name = base.getOntologyType().getName();
              boolean _equals = Objects.equal(_name, "Asset");
              if (_equals) {
                final String astname = base.getName();
                _builder.newLineIfNotEmpty();
                {
                  for(final RegularType asset : this.assets) {
                    {
                      String _name_1 = asset.getName();
                      boolean _equals_1 = Objects.equal(_name_1, astname);
                      if (_equals_1) {
                        {
                          EList<Attribute> _attributes = asset.getAttributes();
                          for(final Attribute embatt : _attributes) {
                            String parentAst = this.generateAssetProblemParameters(embatt);
                            _builder.newLineIfNotEmpty();
                            String _replaceAll = parentAst.replaceAll("owner,", "");
                            _builder.append(_replaceAll);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        Object _xblockexpression = null;
                        {
                          done = true;
                          _xblockexpression = null;
                        }
                        _builder.append(_xblockexpression);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      if ((!done)) {
        final BaseType btype = att.getBaseType();
        _builder.newLineIfNotEmpty();
        _builder.append("type : ");
        String _name_2 = btype.getName();
        _builder.append(_name_2);
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        {
          boolean _equals_2 = btype.getName().equals("Role");
          if (_equals_2) {
          }
        }
        {
          boolean _equals_3 = btype.getName().equals("Number");
          if (_equals_3) {
            _builder.append("value : [1..1000],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_4 = btype.getName().equals("Date");
          if (_equals_4) {
            _builder.append("value : [1..1000],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_5 = btype.getName().equals("String");
          if (_equals_5) {
            _builder.append("value : [str1, str2, str3, str4],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_6 = btype.getName().equals("Boolean");
          if (_equals_6) {
            _builder.append("value : [true, false],");
            _builder.newLine();
          }
        }
      }
    }
    final String code = _builder.toString();
    return code;
  }

  public String problemVariables(final Parameter param) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = param.getName();
    _builder.append(_name);
    _builder.append(" : {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final ParameterType type = param.getType();
    _builder.newLineIfNotEmpty();
    {
      BaseType _baseType = type.getBaseType();
      boolean _tripleNotEquals = (_baseType != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        final BaseType btype = type.getBaseType();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("type : ");
        String _name_1 = btype.getName();
        _builder.append(_name_1, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        {
          boolean _equals = btype.getName().equals("Role");
          if (_equals) {
          }
        }
        {
          boolean _equals_1 = btype.getName().equals("Number");
          if (_equals_1) {
            _builder.append("\t");
            _builder.append("value : [1..1000],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_2 = btype.getName().equals("Date");
          if (_equals_2) {
            _builder.append("\t");
            _builder.append("value : [1..1000],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_3 = btype.getName().equals("String");
          if (_equals_3) {
            _builder.append("\t");
            _builder.append("value : [str1, str2, str3, str4],");
            _builder.newLine();
          }
        }
        {
          boolean _equals_4 = btype.getName().equals("Boolean");
          if (_equals_4) {
            _builder.append("\t");
            _builder.append("value : [true, false],");
            _builder.newLine();
          }
        }
      } else {
        DomainType _domainType = type.getDomainType();
        boolean _tripleNotEquals_1 = (_domainType != null);
        if (_tripleNotEquals_1) {
          {
            DomainType _domainType_1 = type.getDomainType();
            if ((_domainType_1 instanceof Enumeration)) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("type : Enumeration,");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("value : ");
              DomainType _domainType_2 = type.getDomainType();
              String _enumItems = this.getEnumItems(((Enumeration) _domainType_2));
              _builder.append(_enumItems, "\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          {
            DomainType _domainType_3 = type.getDomainType();
            if ((_domainType_3 instanceof RegularTypeImpl)) {
              _builder.append("\t");
              _builder.append("\t");
              DomainType domainType = type.getDomainType();
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              RegularType base = this.getBaseType(domainType);
              _builder.newLineIfNotEmpty();
              {
                if ((base != null)) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("type : ");
                  String _name_2 = this.getBaseType(base).getName();
                  _builder.append(_name_2, "\t\t");
                  _builder.append(",");
                  _builder.newLineIfNotEmpty();
                  {
                    String _name_3 = this.getBaseType(base).getName();
                    boolean _equals_5 = Objects.equal(_name_3, "Role");
                    if (_equals_5) {
                    }
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.newLine();
                  {
                    boolean _equals_6 = this.getBaseType(base).getName().equals("Asset");
                    if (_equals_6) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("value : {");
                      _builder.newLine();
                      {
                        EList<Attribute> _attributes = base.getAttributes();
                        for(final Attribute att : _attributes) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          String _generateAssetProblemParameters = this.generateAssetProblemParameters(att);
                          _builder.append(_generateAssetProblemParameters, "\t\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    return code;
  }

  public void generateProblemFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("domain: ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("argument: {");
    _builder.newLine();
    {
      for(final Parameter param : this.parameters) {
        _builder.append("\t\t\t\t");
        String _problemVariables = this.problemVariables(param);
        _builder.append(_problemVariables, "\t\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName_1 = model.getContractName();
    String _plus = ("./domain/contracts/problemFile_" + _contractName_1);
    String _plus_1 = (_plus + ".txt");
    fsa.generateFile(_plus_1, code);
  }

  public void generatePCSource(final IFileSystemAccess2 fsa, final Model model) {
    this.parse(model);
    this.compileDomainTypes(fsa, model.getDomainTypes());
    this.compileContract(fsa, model);
    this.generateProblemFile(fsa, model);
  }

  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Model> _filter = Iterables.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class);
    for (final Model e : _filter) {
      this.generatePCSource(fsa, e);
    }
  }
}
