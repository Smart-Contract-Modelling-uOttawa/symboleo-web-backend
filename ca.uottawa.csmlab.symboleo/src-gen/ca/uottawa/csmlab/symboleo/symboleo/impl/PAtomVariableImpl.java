/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.PAtomVariable;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAtom Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.PAtomVariableImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAtomVariableImpl extends PropositionImpl implements PAtomVariable
{
  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected Ref variable;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PAtomVariableImpl()
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
    return SymboleoPackage.Literals.PATOM_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Ref getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable(Ref newVariable, NotificationChain msgs)
  {
    Ref oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.PATOM_VARIABLE__VARIABLE, oldVariable, newVariable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVariable(Ref newVariable)
  {
    if (newVariable != variable)
    {
      NotificationChain msgs = null;
      if (variable != null)
        msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.PATOM_VARIABLE__VARIABLE, null, msgs);
      if (newVariable != null)
        msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.PATOM_VARIABLE__VARIABLE, null, msgs);
      msgs = basicSetVariable(newVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.PATOM_VARIABLE__VARIABLE, newVariable, newVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SymboleoPackage.PATOM_VARIABLE__VARIABLE:
        return basicSetVariable(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SymboleoPackage.PATOM_VARIABLE__VARIABLE:
        return getVariable();
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
      case SymboleoPackage.PATOM_VARIABLE__VARIABLE:
        setVariable((Ref)newValue);
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
      case SymboleoPackage.PATOM_VARIABLE__VARIABLE:
        setVariable((Ref)null);
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
      case SymboleoPackage.PATOM_VARIABLE__VARIABLE:
        return variable != null;
    }
    return super.eIsSet(featureID);
  }

} //PAtomVariableImpl