/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage
 * @generated
 */
public interface SymboleoFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SymboleoFactory eINSTANCE = ca.uottawa.csmlab.symboleo.symboleo.impl.SymboleoFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Domain Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain Type</em>'.
   * @generated
   */
  DomainType createDomainType();

  /**
   * Returns a new object of class '<em>Alias</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alias</em>'.
   * @generated
   */
  Alias createAlias();

  /**
   * Returns a new object of class '<em>Enumeration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration</em>'.
   * @generated
   */
  Enumeration createEnumeration();

  /**
   * Returns a new object of class '<em>Enum Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Item</em>'.
   * @generated
   */
  EnumItem createEnumItem();

  /**
   * Returns a new object of class '<em>Regular Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Regular Type</em>'.
   * @generated
   */
  RegularType createRegularType();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Base Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base Type</em>'.
   * @generated
   */
  BaseType createBaseType();

  /**
   * Returns a new object of class '<em>Ontology Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ontology Type</em>'.
   * @generated
   */
  OntologyType createOntologyType();

  /**
   * Returns a new object of class '<em>Attribute Modifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Modifier</em>'.
   * @generated
   */
  AttributeModifier createAttributeModifier();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Parameter Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Type</em>'.
   * @generated
   */
  ParameterType createParameterType();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>OAssignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>OAssignment</em>'.
   * @generated
   */
  OAssignment createOAssignment();

  /**
   * Returns a new object of class '<em>Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref</em>'.
   * @generated
   */
  Ref createRef();

  /**
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
  Assignment createAssignment();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Call</em>'.
   * @generated
   */
  FunctionCall createFunctionCall();

  /**
   * Returns a new object of class '<em>Obligation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obligation</em>'.
   * @generated
   */
  Obligation createObligation();

  /**
   * Returns a new object of class '<em>Power</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Power</em>'.
   * @generated
   */
  Power createPower();

  /**
   * Returns a new object of class '<em>Power Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Power Function</em>'.
   * @generated
   */
  PowerFunction createPowerFunction();

  /**
   * Returns a new object of class '<em>Proposition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Proposition</em>'.
   * @generated
   */
  Proposition createProposition();

  /**
   * Returns a new object of class '<em>Predicate Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function</em>'.
   * @generated
   */
  PredicateFunction createPredicateFunction();

  /**
   * Returns a new object of class '<em>Other Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Other Function</em>'.
   * @generated
   */
  OtherFunction createOtherFunction();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point</em>'.
   * @generated
   */
  Point createPoint();

  /**
   * Returns a new object of class '<em>Point Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Expression</em>'.
   * @generated
   */
  PointExpression createPointExpression();

  /**
   * Returns a new object of class '<em>Timevalue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timevalue</em>'.
   * @generated
   */
  Timevalue createTimevalue();

  /**
   * Returns a new object of class '<em>Interval</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interval</em>'.
   * @generated
   */
  Interval createInterval();

  /**
   * Returns a new object of class '<em>Interval Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interval Expression</em>'.
   * @generated
   */
  IntervalExpression createIntervalExpression();

  /**
   * Returns a new object of class '<em>Situation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Situation</em>'.
   * @generated
   */
  Situation createSituation();

  /**
   * Returns a new object of class '<em>Power State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Power State</em>'.
   * @generated
   */
  PowerState createPowerState();

  /**
   * Returns a new object of class '<em>Obligation State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obligation State</em>'.
   * @generated
   */
  ObligationState createObligationState();

  /**
   * Returns a new object of class '<em>Contract State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Contract State</em>'.
   * @generated
   */
  ContractState createContractState();

  /**
   * Returns a new object of class '<em>OAssign Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>OAssign Expression</em>'.
   * @generated
   */
  OAssignExpression createOAssignExpression();

  /**
   * Returns a new object of class '<em>Variable Dot Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Dot Expression</em>'.
   * @generated
   */
  VariableDotExpression createVariableDotExpression();

  /**
   * Returns a new object of class '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Ref</em>'.
   * @generated
   */
  VariableRef createVariableRef();

  /**
   * Returns a new object of class '<em>Assign Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign Expression</em>'.
   * @generated
   */
  AssignExpression createAssignExpression();

  /**
   * Returns a new object of class '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or</em>'.
   * @generated
   */
  Or createOr();

  /**
   * Returns a new object of class '<em>And</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And</em>'.
   * @generated
   */
  And createAnd();

  /**
   * Returns a new object of class '<em>Equality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality</em>'.
   * @generated
   */
  Equality createEquality();

  /**
   * Returns a new object of class '<em>Comparison</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comparison</em>'.
   * @generated
   */
  Comparison createComparison();

  /**
   * Returns a new object of class '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plus</em>'.
   * @generated
   */
  Plus createPlus();

  /**
   * Returns a new object of class '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Minus</em>'.
   * @generated
   */
  Minus createMinus();

  /**
   * Returns a new object of class '<em>Multi</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multi</em>'.
   * @generated
   */
  Multi createMulti();

  /**
   * Returns a new object of class '<em>Div</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Div</em>'.
   * @generated
   */
  Div createDiv();

  /**
   * Returns a new object of class '<em>Primary Expression Recursive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression Recursive</em>'.
   * @generated
   */
  PrimaryExpressionRecursive createPrimaryExpressionRecursive();

  /**
   * Returns a new object of class '<em>Primary Expression Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression Function Call</em>'.
   * @generated
   */
  PrimaryExpressionFunctionCall createPrimaryExpressionFunctionCall();

  /**
   * Returns a new object of class '<em>Negated Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negated Primary Expression</em>'.
   * @generated
   */
  NegatedPrimaryExpression createNegatedPrimaryExpression();

  /**
   * Returns a new object of class '<em>Atomic Expression True</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression True</em>'.
   * @generated
   */
  AtomicExpressionTrue createAtomicExpressionTrue();

  /**
   * Returns a new object of class '<em>Atomic Expression False</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression False</em>'.
   * @generated
   */
  AtomicExpressionFalse createAtomicExpressionFalse();

  /**
   * Returns a new object of class '<em>Atomic Expression Double</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression Double</em>'.
   * @generated
   */
  AtomicExpressionDouble createAtomicExpressionDouble();

  /**
   * Returns a new object of class '<em>Atomic Expression Int</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression Int</em>'.
   * @generated
   */
  AtomicExpressionInt createAtomicExpressionInt();

  /**
   * Returns a new object of class '<em>Atomic Expression Date</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression Date</em>'.
   * @generated
   */
  AtomicExpressionDate createAtomicExpressionDate();

  /**
   * Returns a new object of class '<em>Atomic Expression Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression Enum</em>'.
   * @generated
   */
  AtomicExpressionEnum createAtomicExpressionEnum();

  /**
   * Returns a new object of class '<em>Atomic Expression String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression String</em>'.
   * @generated
   */
  AtomicExpressionString createAtomicExpressionString();

  /**
   * Returns a new object of class '<em>Atomic Expression Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Expression Parameter</em>'.
   * @generated
   */
  AtomicExpressionParameter createAtomicExpressionParameter();

  /**
   * Returns a new object of class '<em>Two Arg Math Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two Arg Math Function</em>'.
   * @generated
   */
  TwoArgMathFunction createTwoArgMathFunction();

  /**
   * Returns a new object of class '<em>One Arg Math Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>One Arg Math Function</em>'.
   * @generated
   */
  OneArgMathFunction createOneArgMathFunction();

  /**
   * Returns a new object of class '<em>Three Arg String Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Three Arg String Function</em>'.
   * @generated
   */
  ThreeArgStringFunction createThreeArgStringFunction();

  /**
   * Returns a new object of class '<em>Two Arg String Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two Arg String Function</em>'.
   * @generated
   */
  TwoArgStringFunction createTwoArgStringFunction();

  /**
   * Returns a new object of class '<em>One Arg String Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>One Arg String Function</em>'.
   * @generated
   */
  OneArgStringFunction createOneArgStringFunction();

  /**
   * Returns a new object of class '<em>Three Arg Date Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Three Arg Date Function</em>'.
   * @generated
   */
  ThreeArgDateFunction createThreeArgDateFunction();

  /**
   * Returns a new object of class '<em>PF Obligation Suspended</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Obligation Suspended</em>'.
   * @generated
   */
  PFObligationSuspended createPFObligationSuspended();

  /**
   * Returns a new object of class '<em>PF Obligation Resumed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Obligation Resumed</em>'.
   * @generated
   */
  PFObligationResumed createPFObligationResumed();

  /**
   * Returns a new object of class '<em>PF Obligation Discharged</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Obligation Discharged</em>'.
   * @generated
   */
  PFObligationDischarged createPFObligationDischarged();

  /**
   * Returns a new object of class '<em>PF Obligation Terminated</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Obligation Terminated</em>'.
   * @generated
   */
  PFObligationTerminated createPFObligationTerminated();

  /**
   * Returns a new object of class '<em>PF Obligation Triggered</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Obligation Triggered</em>'.
   * @generated
   */
  PFObligationTriggered createPFObligationTriggered();

  /**
   * Returns a new object of class '<em>PF Contract Suspended</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Contract Suspended</em>'.
   * @generated
   */
  PFContractSuspended createPFContractSuspended();

  /**
   * Returns a new object of class '<em>PF Contract Resumed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Contract Resumed</em>'.
   * @generated
   */
  PFContractResumed createPFContractResumed();

  /**
   * Returns a new object of class '<em>PF Contract Terminated</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PF Contract Terminated</em>'.
   * @generated
   */
  PFContractTerminated createPFContractTerminated();

  /**
   * Returns a new object of class '<em>POr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>POr</em>'.
   * @generated
   */
  POr createPOr();

  /**
   * Returns a new object of class '<em>PAnd</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAnd</em>'.
   * @generated
   */
  PAnd createPAnd();

  /**
   * Returns a new object of class '<em>PEquality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PEquality</em>'.
   * @generated
   */
  PEquality createPEquality();

  /**
   * Returns a new object of class '<em>PComparison</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PComparison</em>'.
   * @generated
   */
  PComparison createPComparison();

  /**
   * Returns a new object of class '<em>PAtom Recursive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Recursive</em>'.
   * @generated
   */
  PAtomRecursive createPAtomRecursive();

  /**
   * Returns a new object of class '<em>Negated PAtom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negated PAtom</em>'.
   * @generated
   */
  NegatedPAtom createNegatedPAtom();

  /**
   * Returns a new object of class '<em>PAtom Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Predicate</em>'.
   * @generated
   */
  PAtomPredicate createPAtomPredicate();

  /**
   * Returns a new object of class '<em>PAtom Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Function</em>'.
   * @generated
   */
  PAtomFunction createPAtomFunction();

  /**
   * Returns a new object of class '<em>PAtom Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Enum</em>'.
   * @generated
   */
  PAtomEnum createPAtomEnum();

  /**
   * Returns a new object of class '<em>PAtom Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Variable</em>'.
   * @generated
   */
  PAtomVariable createPAtomVariable();

  /**
   * Returns a new object of class '<em>PAtom Predicate True Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Predicate True Literal</em>'.
   * @generated
   */
  PAtomPredicateTrueLiteral createPAtomPredicateTrueLiteral();

  /**
   * Returns a new object of class '<em>PAtom Predicate False Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Predicate False Literal</em>'.
   * @generated
   */
  PAtomPredicateFalseLiteral createPAtomPredicateFalseLiteral();

  /**
   * Returns a new object of class '<em>PAtom Double Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Double Literal</em>'.
   * @generated
   */
  PAtomDoubleLiteral createPAtomDoubleLiteral();

  /**
   * Returns a new object of class '<em>PAtom Int Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Int Literal</em>'.
   * @generated
   */
  PAtomIntLiteral createPAtomIntLiteral();

  /**
   * Returns a new object of class '<em>PAtom String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom String Literal</em>'.
   * @generated
   */
  PAtomStringLiteral createPAtomStringLiteral();

  /**
   * Returns a new object of class '<em>PAtom Date Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAtom Date Literal</em>'.
   * @generated
   */
  PAtomDateLiteral createPAtomDateLiteral();

  /**
   * Returns a new object of class '<em>Predicate Function Happens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Happens</em>'.
   * @generated
   */
  PredicateFunctionHappens createPredicateFunctionHappens();

  /**
   * Returns a new object of class '<em>Predicate Function WHappens Before</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function WHappens Before</em>'.
   * @generated
   */
  PredicateFunctionWHappensBefore createPredicateFunctionWHappensBefore();

  /**
   * Returns a new object of class '<em>Predicate Function SHappens Before</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function SHappens Before</em>'.
   * @generated
   */
  PredicateFunctionSHappensBefore createPredicateFunctionSHappensBefore();

  /**
   * Returns a new object of class '<em>Predicate Function Happens Within</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Happens Within</em>'.
   * @generated
   */
  PredicateFunctionHappensWithin createPredicateFunctionHappensWithin();

  /**
   * Returns a new object of class '<em>Predicate Function WHappens Before Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function WHappens Before Event</em>'.
   * @generated
   */
  PredicateFunctionWHappensBeforeEvent createPredicateFunctionWHappensBeforeEvent();

  /**
   * Returns a new object of class '<em>Predicate Function SHappens Before Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function SHappens Before Event</em>'.
   * @generated
   */
  PredicateFunctionSHappensBeforeEvent createPredicateFunctionSHappensBeforeEvent();

  /**
   * Returns a new object of class '<em>Predicate Function Happens After</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Happens After</em>'.
   * @generated
   */
  PredicateFunctionHappensAfter createPredicateFunctionHappensAfter();

  /**
   * Returns a new object of class '<em>Predicate Function Occurs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Occurs</em>'.
   * @generated
   */
  PredicateFunctionOccurs createPredicateFunctionOccurs();

  /**
   * Returns a new object of class '<em>Predicate Function Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Assignment</em>'.
   * @generated
   */
  PredicateFunctionAssignment createPredicateFunctionAssignment();

  /**
   * Returns a new object of class '<em>Predicate Function Assignment Only</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Assignment Only</em>'.
   * @generated
   */
  PredicateFunctionAssignmentOnly createPredicateFunctionAssignmentOnly();

  /**
   * Returns a new object of class '<em>Predicate Function Is Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Is Equal</em>'.
   * @generated
   */
  PredicateFunctionIsEqual createPredicateFunctionIsEqual();

  /**
   * Returns a new object of class '<em>Predicate Function Is Owner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Is Owner</em>'.
   * @generated
   */
  PredicateFunctionIsOwner createPredicateFunctionIsOwner();

  /**
   * Returns a new object of class '<em>Predicate Function Cannot Be Assigned</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Function Cannot Be Assigned</em>'.
   * @generated
   */
  PredicateFunctionCannotBeAssigned createPredicateFunctionCannotBeAssigned();

  /**
   * Returns a new object of class '<em>Variable Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Event</em>'.
   * @generated
   */
  VariableEvent createVariableEvent();

  /**
   * Returns a new object of class '<em>Power Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Power Event</em>'.
   * @generated
   */
  PowerEvent createPowerEvent();

  /**
   * Returns a new object of class '<em>Obligation Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obligation Event</em>'.
   * @generated
   */
  ObligationEvent createObligationEvent();

  /**
   * Returns a new object of class '<em>Contract Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Contract Event</em>'.
   * @generated
   */
  ContractEvent createContractEvent();

  /**
   * Returns a new object of class '<em>Point Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Function</em>'.
   * @generated
   */
  PointFunction createPointFunction();

  /**
   * Returns a new object of class '<em>Point Atom Parameter Dot Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Atom Parameter Dot Expression</em>'.
   * @generated
   */
  PointAtomParameterDotExpression createPointAtomParameterDotExpression();

  /**
   * Returns a new object of class '<em>Point Atom Obligation Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Atom Obligation Event</em>'.
   * @generated
   */
  PointAtomObligationEvent createPointAtomObligationEvent();

  /**
   * Returns a new object of class '<em>Point Atom Contract Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Atom Contract Event</em>'.
   * @generated
   */
  PointAtomContractEvent createPointAtomContractEvent();

  /**
   * Returns a new object of class '<em>Point Atom Power Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Point Atom Power Event</em>'.
   * @generated
   */
  PointAtomPowerEvent createPointAtomPowerEvent();

  /**
   * Returns a new object of class '<em>Timevalue Int</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timevalue Int</em>'.
   * @generated
   */
  TimevalueInt createTimevalueInt();

  /**
   * Returns a new object of class '<em>Timevalue Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timevalue Variable</em>'.
   * @generated
   */
  TimevalueVariable createTimevalueVariable();

  /**
   * Returns a new object of class '<em>Interval Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interval Function</em>'.
   * @generated
   */
  IntervalFunction createIntervalFunction();

  /**
   * Returns a new object of class '<em>Situation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Situation Expression</em>'.
   * @generated
   */
  SituationExpression createSituationExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SymboleoPackage getSymboleoPackage();

} //SymboleoFactory
