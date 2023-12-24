export interface ApiResponse{
  body: any;
  type: string;
  httpCode: number;
  errors: string[];
  hasErrors: boolean;
}
