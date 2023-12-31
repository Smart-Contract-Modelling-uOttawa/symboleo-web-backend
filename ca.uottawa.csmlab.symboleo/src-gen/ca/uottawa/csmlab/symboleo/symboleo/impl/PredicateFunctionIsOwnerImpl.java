/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionIsOwner;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Function Is Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.PredicateFunctionIsOwnerImpl#getArg2 <em>Arg2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateFunctionIsOwnerImpl extends OtherFunctionImpl implements PredicateFunctionIsOwner
{
  /**
   * The default value of the '{@link #getArg2() <em>Arg2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg2()
   * @generated
   * @ordered
   */
  protected static final String ARG2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArg2() <em>Arg2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg2()
   * @generated
   * @ordered
   */
  protected String arg2 = ARG2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredicateFunctionIsOwnerImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SymboleoPackage.Literals.PREDICATE_FUNCTION_IS_OWNER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getArg2()
  {
    return arg2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArg2(String newArg2)
  {
    String oldArg2 = arg2;
    arg2 = newArg2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.PREDICATE_FUNCTION_IS_OWNER__ARG2, oldArg2, arg2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_IS_OWNER__ARG2:
        return getArg2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_IS_OWNER__ARG2:
        setArg2((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_IS_OWNER__ARG2:
        setArg2(ARG2_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_IS_OWNER__ARG2:
        return ARG2_EDEFAULT == null ? arg2 != null : !ARG2_EDEFAULT.equals(arg2);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (arg2: ");
    result.append(arg2);
    result.append(')');
    return result.toString();
  }

} //PredicateFunctionIsOwnerImpl
