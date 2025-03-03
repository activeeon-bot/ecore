/**
 */
package org.occiware.clouddesigner.occi.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.occiware.clouddesigner.occi.Attribute;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Category;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Kind;
import org.occiware.clouddesigner.occi.OCCIPackage;

/**
 * This is the item provider adapter for a
 * {@link org.occiware.clouddesigner.occi.AttributeState} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AttributeStateItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addValuePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		final IItemLabelProvider lp = new IItemLabelProvider() {
			public String getText(Object object) {
				if (object instanceof Attribute) {
					Attribute attr = (Attribute) object;
					Category cat = ((Category) attr.eContainer());
					return '[' + cat.getTerm() + "] " + attr.getName() + ':' + attr.getType().getName();
				}
				return String.valueOf(object);
			}

			public Object getImage(Object object) {
				return null;
			}
		};
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_AttributeState_name_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_AttributeState_name_feature",
								"_UI_AttributeState_type"),
						OCCIPackage.Literals.ATTRIBUTE_STATE__NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null) {
					@Override
					public Collection<?> getChoiceOfValues(Object arg0) {
						List<Attribute> l = new ArrayList<Attribute>();
						Kind kind = ((Entity) ((AttributeState) arg0).eContainer()).getKind();
						if (arg0 instanceof AttributeState && ((AttributeState) arg0).eContainer() instanceof Entity
								&& kind != null) {
							for (Attribute attribute : getAllAttributes(kind)) {
								l.add(attribute);
							}
						}
						return l;
					}

					@Override
					public void setPropertyValue(Object object, Object value) {
						if (object instanceof AttributeState && value instanceof Attribute) {
							AttributeState as = (AttributeState) object;
							as.setName(((Attribute) value).getName());
						}
						super.setPropertyValue(object, value);
					}

					@Override
					public IItemLabelProvider getLabelProvider(Object object) {
						if (object instanceof AttributeState) {
							return lp;
						}
						return super.getLabelProvider(object);
					}

					@Override
					public Object getPropertyValue(Object object) {
						if (object instanceof Attribute) {
							return ((Attribute) object).getName();
						}
						return super.getPropertyValue(object);
					}
				});
	}

	/**
	 * @generated NOT
	 */
	private static Collection<Attribute> getAllAttributes(Kind kind) {
		List<Attribute> res = new ArrayList<Attribute>();
		if (kind.getParent() != null) {
			res.addAll(getAllAttributes(kind.getParent()));
		}
		res.addAll(kind.getAttributes());
		return res;
	}

	/**
	 * This adds a property descriptor for the Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_AttributeState_value_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_AttributeState_value_feature",
								"_UI_AttributeState_type"),
						OCCIPackage.Literals.ATTRIBUTE_STATE__VALUE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns AttributeState.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeState"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AttributeState) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_AttributeState_type")
				: getString("_UI_AttributeState_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AttributeState.class)) {
		case OCCIPackage.ATTRIBUTE_STATE__NAME:
		case OCCIPackage.ATTRIBUTE_STATE__VALUE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OCCIEditPlugin.INSTANCE;
	}

}
