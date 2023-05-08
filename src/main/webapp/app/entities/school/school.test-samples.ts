import dayjs from 'dayjs/esm';

import { RecordStatus } from 'app/entities/enumerations/record-status.model';
import { DELFLAG } from 'app/entities/enumerations/delflag.model';

import { ISchool, NewSchool } from './school.model';

export const sampleWithRequiredData: ISchool = {
  id: 82208,
  schoolId: 'f8185c2d-858f-44c9-a3e7-fb81dd39adb2',
  schoolCode: 'Avon Integration discrete',
  schoolShortcode: 94340,
  phonenumber: 'engineer Legacy Soft',
  schoolName: 'Investor mindshare Illinois',
  registrationdate: dayjs('2023-04-24'),
  status: RecordStatus['ACTIVE'],
};

export const sampleWithPartialData: ISchool = {
  id: 78042,
  schoolId: 'de3506e6-d0d0-4ee6-9bc5-c09de331ac48',
  schoolCode: 'withdrawal',
  schoolShortcode: 16657,
  phonenumber: 'Park Central',
  schoolName: 'Industrial',
  registrationdate: dayjs('2023-04-25'),
  status: RecordStatus['ACTIVE'],
  freeField2: 'Bike turquoise grow',
  schoolAccountNumber: false,
  isDeleted: DELFLAG['True'],
};

export const sampleWithFullData: ISchool = {
  id: 89405,
  schoolId: 'ea61f172-055b-4bb6-b156-4b3037ca72f1',
  schoolCode: 'Engineer Baht',
  schoolShortcode: 4633,
  phonenumber: 'partnerships Sports',
  address: 'withdrawal Configuration Lucia',
  schoolName: '1080p digital Berkshire',
  registrationdate: dayjs('2023-04-24'),
  status: RecordStatus['PENDING'],
  freeField1: 'Account Tugrik Pants',
  freeField2: 'throughput Bedfordshire Auto',
  freeField3: 'solid Baby',
  isSchoolAccountNumberABSA: false,
  schoolAccountNumber: false,
  isDeleted: DELFLAG['True'],
};

export const sampleWithNewData: NewSchool = {
  schoolId: '3b2ac31b-40d5-4d48-9da4-fe55b8da43ec',
  schoolCode: 'rich',
  schoolShortcode: 89786,
  phonenumber: 'Planner synergies',
  schoolName: 'Nigeria primary Trafficway',
  registrationdate: dayjs('2023-04-25'),
  status: RecordStatus['PENDING'],
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
