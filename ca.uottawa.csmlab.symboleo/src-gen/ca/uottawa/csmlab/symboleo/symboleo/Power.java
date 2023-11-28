/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getName <em>Name</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getCreditor <em>Creditor</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getDebtor <em>Debtor</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getAntecedent <em>Antecedent</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getConsequent <em>Consequent</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower()
 * @model
 * @generated
 */
public interface Power extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' containment reference.
   * @see #setTrigger(Proposition)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Trigger()
   * @model containment="true"
   * @generated
   */
  Proposition getTrigger();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getTrigger <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger</em>' containment reference.
   * @see #getTrigger()
   * @generated
   */
  void setTrigger(Proposition value);

  /**
   * Returns the value of the '<em><b>Creditor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Creditor</em>' containment reference.
   * @see #setCreditor(Ref)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Creditor()
   * @model containment="true"
   * @generated
   */
  Ref getCreditor();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getCreditor <em>Creditor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Creditor</em>' containment reference.
   * @see #getCreditor()
   * @generated
   */
  void setCreditor(Ref value);

  /**
   * Returns the value of the '<em><b>Debtor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Debtor</em>' containment reference.
   * @see #setDebtor(Ref)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Debtor()
   * @model containment="true"
   * @generated
   */
  Ref getDebtor();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getDebtor <em>Debtor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Debtor</em>' containment reference.
   * @see #getDebtor()
   * @generated
   */
  void setDebtor(Ref value);

  /**
   * Returns the value of the '<em><b>Antecedent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Antecedent</em>' containment reference.
   * @see #setAntecedent(Proposition)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Antecedent()
   * @model containment="true"
   * @generated
   */
  Proposition getAntecedent();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getAntecedent <em>Antecedent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Antecedent</em>' containment reference.
   * @see #getAntecedent()
   * @generated
   */
  void setAntecedent(Proposition value);

  /**
   * Returns the value of the '<em><b>Consequent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Consequent</em>' containment reference.
   * @see #setConsequent(PowerFunction)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPower_Consequent()
   * @model containment="true"
   * @generated
   */
  PowerFunction getConsequent();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Power#getConsequent <em>Consequent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Consequent</em>' containment reference.
   * @see #getConsequent()
   * @generated
   */
  void setConsequent(PowerFunction value);

} // Power
