import dayjs from 'dayjs/esm';
import { RecordStatus } from 'app/entities/enumerations/record-status.model';
import { DELFLAG } from 'app/entities/enumerations/delflag.model';

export interface ISchool {
  id: number;
  schoolId?: string | null;
  schoolCode?: string | null;
  schoolShortcode?: number | null;
  phonenumber?: string | null;
  address?: string | null;
  schoolName?: string | null;
  registrationdate?: dayjs.Dayjs | null;
  status?: RecordStatus | null;
  freeField1?: string | null;
  freeField2?: string | null;
  freeField3?: string | null;
  isSchoolAccountNumberABSA?: boolean | null;
  schoolAccountNumber?: boolean | null;
  isDeleted?: DELFLAG | null;
}

export type NewSchool = Omit<ISchool, 'id'> & { id: null };
