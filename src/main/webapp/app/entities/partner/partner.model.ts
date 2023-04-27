import dayjs from 'dayjs/esm';
import { RecordStatus } from 'app/entities/enumerations/record-status.model';
import { DELFLAG } from 'app/entities/enumerations/delflag.model';

export interface IPartner {
  id: number;
  partnerId?: string | null;
  partnerCode?: number | null;
  partnerShortcode?: number | null;
  phonenumber?: string | null;
  address?: string | null;
  partnerName?: string | null;
  registrationdate?: dayjs.Dayjs | null;
  isAbsaPartner?: boolean | null;
  status?: RecordStatus | null;
  freeField1?: string | null;
  freeField2?: string | null;
  freeField3?: string | null;
  provideDebitAccount?: boolean | null;
  provideCreditAccount?: boolean | null;
  isDeleted?: DELFLAG | null;
}

export type NewPartner = Omit<IPartner, 'id'> & { id: null };
