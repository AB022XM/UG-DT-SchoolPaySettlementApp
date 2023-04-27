import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ISchool, NewSchool } from '../school.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts ISchool for edit and NewSchoolFormGroupInput for create.
 */
type SchoolFormGroupInput = ISchool | PartialWithRequiredKeyOf<NewSchool>;

type SchoolFormDefaults = Pick<NewSchool, 'id' | 'isSchoolAccountNumberABSA' | 'schoolAccountNumber'>;

type SchoolFormGroupContent = {
  id: FormControl<ISchool['id'] | NewSchool['id']>;
  schoolId: FormControl<ISchool['schoolId']>;
  schoolCode: FormControl<ISchool['schoolCode']>;
  schoolShortcode: FormControl<ISchool['schoolShortcode']>;
  phonenumber: FormControl<ISchool['phonenumber']>;
  address: FormControl<ISchool['address']>;
  schoolName: FormControl<ISchool['schoolName']>;
  registrationdate: FormControl<ISchool['registrationdate']>;
  status: FormControl<ISchool['status']>;
  freeField1: FormControl<ISchool['freeField1']>;
  freeField2: FormControl<ISchool['freeField2']>;
  freeField3: FormControl<ISchool['freeField3']>;
  isSchoolAccountNumberABSA: FormControl<ISchool['isSchoolAccountNumberABSA']>;
  schoolAccountNumber: FormControl<ISchool['schoolAccountNumber']>;
  isDeleted: FormControl<ISchool['isDeleted']>;
};

export type SchoolFormGroup = FormGroup<SchoolFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class SchoolFormService {
  createSchoolFormGroup(school: SchoolFormGroupInput = { id: null }): SchoolFormGroup {
    const schoolRawValue = {
      ...this.getFormDefaults(),
      ...school,
    };
    return new FormGroup<SchoolFormGroupContent>({
      id: new FormControl(
        { value: schoolRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      schoolId: new FormControl(schoolRawValue.schoolId, {
        validators: [Validators.required],
      }),
      schoolCode: new FormControl(schoolRawValue.schoolCode, {
        validators: [Validators.required],
      }),
      schoolShortcode: new FormControl(schoolRawValue.schoolShortcode, {
        validators: [Validators.required],
      }),
      phonenumber: new FormControl(schoolRawValue.phonenumber, {
        validators: [Validators.required],
      }),
      address: new FormControl(schoolRawValue.address),
      schoolName: new FormControl(schoolRawValue.schoolName, {
        validators: [Validators.required, Validators.minLength(3), Validators.maxLength(200)],
      }),
      registrationdate: new FormControl(schoolRawValue.registrationdate, {
        validators: [Validators.required],
      }),
      status: new FormControl(schoolRawValue.status, {
        validators: [Validators.required],
      }),
      freeField1: new FormControl(schoolRawValue.freeField1),
      freeField2: new FormControl(schoolRawValue.freeField2),
      freeField3: new FormControl(schoolRawValue.freeField3),
      isSchoolAccountNumberABSA: new FormControl(schoolRawValue.isSchoolAccountNumberABSA),
      schoolAccountNumber: new FormControl(schoolRawValue.schoolAccountNumber),
      isDeleted: new FormControl(schoolRawValue.isDeleted),
    });
  }

  getSchool(form: SchoolFormGroup): ISchool | NewSchool {
    return form.getRawValue() as ISchool | NewSchool;
  }

  resetForm(form: SchoolFormGroup, school: SchoolFormGroupInput): void {
    const schoolRawValue = { ...this.getFormDefaults(), ...school };
    form.reset(
      {
        ...schoolRawValue,
        id: { value: schoolRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): SchoolFormDefaults {
    return {
      id: null,
      isSchoolAccountNumberABSA: false,
      schoolAccountNumber: false,
    };
  }
}
